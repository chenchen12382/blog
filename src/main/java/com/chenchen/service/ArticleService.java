package com.chenchen.service;

import com.chenchen.exception.ParamException;
import com.chenchen.utils.CookieUtil;
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
}
