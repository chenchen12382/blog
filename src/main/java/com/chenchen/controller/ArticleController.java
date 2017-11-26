package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.base.ResultInfo;
import com.chenchen.model.Article;
import com.chenchen.model.Tag;
import com.chenchen.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16.
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("index")
    public String index(Model model,HttpServletRequest request){
        List<Tag> tags=articleService.selectAllTag(request);
        model.addAttribute("tags",tags);
        return "article";
    }

    //上传图片
    @RequestMapping("uploadImg")
    @ResponseBody
    public Map<String,Object> loadImg(@RequestParam(value = "uploadImg", required = false) MultipartFile file, HttpServletRequest request){

        Map<String,Object> result = articleService.uploadImg(file,request);

        return result;
    }


    //标签页
    @RequestMapping("tag")
    @ResponseBody
    public ResultInfo insertTag(Tag tag,HttpServletRequest request){
         articleService.insertTag(tag,request);
         return success("标签插入成功");

    }

    //批量删除
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteTag(String tags,HttpServletRequest request){

        articleService.deleteBatch(tags,request);
        return success("删除成功");
    }

    //写文章
    @RequestMapping("insert")
    @ResponseBody
    public ResultInfo insert(Article article){
        articleService.insert(article);
        return success("提交成功");


    }
}
