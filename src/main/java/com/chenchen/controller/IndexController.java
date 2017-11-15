package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.service.UserService;
import com.chenchen.utils.LoginUserUtil;
import com.chenchen.vo.UserLoginIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("main")
	public String main(Model model, HttpServletRequest request) {
		// 获取登录用户的信息
		Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
		UserLoginIdentity userLoginIdentity = userService.findLoginUser(userId);
		model.addAttribute("currentUser", userLoginIdentity);
		return "main";
	}
	
}
