package com.chenchen.dao;

import com.chenchen.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/11/14.
 */
public interface UserDao {
    @Select("select id, user_name, password, true_name, email, phone from t_user "
            + "where user_name = #{userName} and is_valid = 1")
    User findByUserName(@Param(value="userName")String userName);
}
