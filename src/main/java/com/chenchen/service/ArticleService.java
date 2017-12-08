package com.chenchen.service;

import com.chenchen.base.AssertUtil;
import com.chenchen.base.BaseQuery;
import com.chenchen.dao.ArticleDao;
import com.chenchen.dao.UserDao;
import com.chenchen.dto.CommentQuery;
import com.chenchen.exception.ParamException;
import com.chenchen.model.Article;
import com.chenchen.model.Comment;
import com.chenchen.model.Tag;
import com.chenchen.utils.CookieUtil;
import com.chenchen.utils.MD5Util;
import com.chenchen.utils.UserIDBase64;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16.
 */
@Service
public class ArticleService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArticleDao articleDao;

    public Map<String, Object> uploadImg(MultipartFile file, HttpServletRequest request) {
//        String userName= CookieUtil.getCookieValue(request,"userName");
//
//
//        String center = userDao.findUserCenter(userName);
        if(file == null){
            throw new ParamException("图片为空!");
        }

        String path = request.getSession( ).getServletContext( ).getRealPath( "/" )+"/upload";

//        System.out.println(path);
        String time=System.currentTimeMillis()+"";

        String fileName=new String( "img"+time+".jpg");
//        String fileName = file.getOriginalFilename();
        File targetFile = new File(path,fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        }catch(Exception e){
            e.printStackTrace();
        }
//        String result = targetFile.getPath();
        Map<String,Object> result = new HashMap<>();
        result.put("errno",0);
        List<String> paths = new ArrayList<>();
//        String bathPath =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        paths.add(request.getContextPath()+"/upload/"+fileName);
        result.put("data",paths);

        return result;

    }

    /**
     * 插入标签
     * @param tag
     * @param request
     */
    public void insertTag(Tag tag, HttpServletRequest request) {
        AssertUtil.isNotEmpty(tag.getTypeName(),"标签名不能为空！");
        Integer tags=articleDao.findByTagName(tag.getTypeName());
        if(tags!=0){
            throw new ParamException("标签已存在");
        }
//       String userId= CookieUtil.getCookieValue(request,"userIdString");
        Integer userId = getUserID(request);
        tag.setUserId(userId);
//        String userId=CookieUtil.getCookieValue(request,"userIdString");
//        tag.setUserId(UserIDBase64.decoderUserID(userId));
        //插入tag
        articleDao.insertTag(tag);

    }

    /**
     * 查询所有标签遍历到前台
     * @return
     * @param request
     */
    public List<Tag> selectAllTag(HttpServletRequest request) {
//        Integer userId=UserIDBase64.decoderUserID(CookieUtil.getCookieValue(request,"userIdString"));
        Integer userId = getUserID(request);
        List<Tag> tags= articleDao.selectAllTag(userId);
        return tags;
    }

    /**
     * 批量删除
     * @param tags
     * @param request
     */
    public void deleteBatch(String tags, HttpServletRequest request) {
        AssertUtil.isNotEmpty(tags,"请选择标签删除");
        Integer userId = getUserID(request);
        String tag = tags.substring(0,tags.length()-1);
        String[] typeNames= tag.split(",");
        try {
            for (int i=0;i<typeNames.length;i++){
                articleDao.deleteBatch(typeNames[i],userId);
            }
        }catch (RuntimeException e){

            throw new ParamException("删除出错！");
        }


//        articleDao.deleteBatch(tag,userId);
    }

    public Integer getUserID(HttpServletRequest request){
        Integer userId = UserIDBase64.decoderUserID(CookieUtil.getCookieValue(request,"userIdString"));
        return userId;
    }

    /**
     * 插入文章
     * @param article
     */
    public void insert(Article article) {
        AssertUtil.isNotEmpty(article.getTitle(),"请输入标题");
        AssertUtil.isNotEmpty(article.getIntro(),"请填写简介");
        AssertUtil.isNotEmpty(article.getContent(),"请填写正文");
        AssertUtil.isNotEmpty(article.getTypeId(),"请选择标签");

        articleDao.insert(article);

    }

    public PageList<Article> findAllArticle(BaseQuery query) {
        PageList<Article> articles = articleDao.findAllArticle(query,query.buildPageBounds());

        return articles;

    }

    public Article findArticleById(Integer id) {
        AssertUtil.intIsNotEmpty(id,"请选择！");
        Article article=articleDao.findArticleById(id);
        return article;
    }

    /**
     * 插入评论
     * @param comment
     */
    public void insertComment(Comment comment) {

        AssertUtil.isNotEmpty(comment.getNikeName(),"请填写昵称");
        AssertUtil.isNotEmpty(comment.getContent(),"请填写评论");

        articleDao.insertComment(comment);

    }

    public PageList<Comment> findCommentByAid(CommentQuery query) {
        PageList<Comment> comments = articleDao.findCommentByAid(query,query.buildPageBounds());
        return  comments;

    }
}
