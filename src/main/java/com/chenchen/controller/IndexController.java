package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.base.BaseQuery;
import com.chenchen.dao.ArticleDao;
import com.chenchen.model.Article;
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
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("main")
	public String main(HttpServletRequest request,Model model,BaseQuery query) {
		// 获取登录用户的信息
		Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
		User user = userService.findLoginUser(userId);
//		session.addAttribute("user", user);
		request.getSession().setAttribute("user",user);
//		//文章简略信息
//		articleService.findAllArticle();
		PageList<Article> result = articleService.findAllArticle(query);
//		Map<String,Object> articles=findAllArticle(query);
		model.addAttribute("articles",result);
		model.addAttribute("page",result.getPaginator());
		return "main";
	}

	@RequestMapping("a")
	public String findAllArticle(Integer id,Model model,BaseQuery query){
		Article article=articleService.findArticleById(id);
//		PageList<Article> result = articleService.findAllArticle(query);
		Integer pre = articleDao.findPrePage(id);
		Integer next = articleDao.findNextPage(id);
		model.addAttribute("pre",pre);
		model.addAttribute("next",next);
		model.addAttribute("article",article);
		return "ac";
	}

	
}
