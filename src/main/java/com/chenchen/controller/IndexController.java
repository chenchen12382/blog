package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.base.BaseQuery;
import com.chenchen.base.ResultInfo;
import com.chenchen.dao.ArticleDao;
import com.chenchen.dto.CommentQuery;
import com.chenchen.dto.IndexQuery;
import com.chenchen.model.Article;
import com.chenchen.model.Comment;
import com.chenchen.model.Tag;
import com.chenchen.model.User;
import com.chenchen.service.ArticleService;
import com.chenchen.service.UserService;
import com.chenchen.utils.CookieUtil;
import com.chenchen.utils.LoginUserUtil;
import com.chenchen.utils.UserIDBase64;
import com.chenchen.vo.UserLoginIdentity;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleDao articleDao;
	
	@RequestMapping("login")
	public String index() {
		return "index";
	}

	@RequestMapping("/")
	public String main(HttpServletRequest request,Model model,IndexQuery query) {
		// 获取登录用户的信息
		Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
		if(userId==null){
			userId=1;
		}
		User user = userService.findLoginUser(userId);
//		session.addAttribute("user", user);
		request.getSession().setAttribute("user",user);
//		//文章简略信息
//		articleService.findAllArticle();
		PageList<Article> result = articleService.findAllArticle(query);

//		Map<String,Object> articles=findAllArticle(query);
		model.addAttribute("articles",result);
		model.addAttribute("page",result.getPaginator());

		//查询标签
		List<Tag> tags=articleService.selectAllTag(request);
		request.getSession().setAttribute("rightTags",tags);
//		model.addAttribute("rightTags",tags);
		return "main";
	}

	@RequestMapping("a")
	public String findAllArticle(Integer id,Model model,CommentQuery query){
		Article article=articleService.findArticleById(id);
//		PageList<Article> result = articleService.findAllArticle(query);
		Integer pre = articleDao.findPrePage(id);
		Integer next = articleDao.findNextPage(id);
		model.addAttribute("pre",pre);
		model.addAttribute("next",next);
		model.addAttribute("article",article);

		//文章评论信息
		query.setAid(id);
		PageList<Comment> comments = articleService.findCommentByAid(query);
		model.addAttribute("comments",comments);
		model.addAttribute("paginator",comments.getPaginator());


		return "ac";
	}

	@RequestMapping("comment")
	@ResponseBody
	public ResultInfo insertComment(Comment comment){
		articleService.insertComment(comment);
		return success("发表成功");

	}

	@RequestMapping("img")
	public String imgCtrl(){
		return "img";
	}

}
