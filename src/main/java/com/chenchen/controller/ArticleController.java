package com.chenchen.controller;

import com.chenchen.base.BaseController;
import com.chenchen.base.ResultInfo;
import com.chenchen.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    public String index(){

        return "article";
    }

    //上传图片
    @RequestMapping("uploadImg")
    @ResponseBody
    public Map<String,Object> loadImg(@RequestParam(value = "uploadImg", required = false) MultipartFile file, HttpServletRequest request){

        Map<String,Object> result = articleService.uploadImg(file,request);

        return result;
    }

}
