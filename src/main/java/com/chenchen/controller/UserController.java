package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.base.ResultInfo;
import com.chenchen.exception.ParamException;
import com.chenchen.service.UserService;
import com.chenchen.vo.UserLoginIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/14.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(String userName, String password, HttpSession session){
        //验证码
//		String code=request.getParameter("code");
//        if (!(code.equalsIgnoreCase(session.getAttribute("code").toString()))) {  //忽略验证码大小写
//            throw new ParamException("验证码错误,请重新输入");
//        }
        UserLoginIdentity userLoginIdentity = userService.login(userName,password);
        return success(userLoginIdentity);
    }

}
