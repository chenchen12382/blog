package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/16.
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("index")
    public String index(){

        return "article";
    }

}
