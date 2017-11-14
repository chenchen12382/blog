package com.chenchen.service;

import com.chenchen.base.AssertUtil;
import com.chenchen.dao.UserDao;
import com.chenchen.exception.ParamException;
import com.chenchen.model.User;
import com.chenchen.utils.MD5Util;
import com.chenchen.utils.UserIDBase64;
import com.chenchen.vo.UserLoginIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/14.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;



    public UserLoginIdentity login(String userName, String password) {
        // 非空验证
        AssertUtil.isNotEmpty(userName, "请输入用户名");
        AssertUtil.isNotEmpty(password, "请输入密码");

        // 根据用户名查询用户在验证
        User user = userDao.findByUserName(userName.trim());

        AssertUtil.notNull(user,"用户名或密码错误,请重新输入!");
        if (!MD5Util.md5Method(password).equals(user.getPassword())) {
            throw new ParamException(103, "用户名或密码错误,请重新输入!");
        }
        UserLoginIdentity userLoginIdentity = buildLoginIdentity(user);
        return userLoginIdentity;

    }


    /**
     * 构建登录信息
     *
     * @param user
     * @return
     */
    private static UserLoginIdentity buildLoginIdentity(User user) {
        UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
        userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
        userLoginIdentity.setRealName(user.getTrueName());
        userLoginIdentity.setUserName(user.getUserName());
        return userLoginIdentity;
    }


}
