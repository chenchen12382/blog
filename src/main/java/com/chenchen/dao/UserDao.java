package com.chenchen.dao;

import com.chenchen.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/11/14.
 */
public interface UserDao {
    @Select("select id, user_name, password, nick_name, mood, img from t_user "
            + "where user_name = #{userName}")
    User findByUserName(@Param(value="userName")String userName);

    @Select("select id, user_name, password, nick_name, mood, img from t_user where id = #{id}")
    User findById(@Param("id") Integer userId);
}
