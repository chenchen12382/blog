package com.chenchen.dao;

import com.chenchen.model.Center;
import com.chenchen.model.Sql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/1/5.
 */
public interface MapDao {

    @Select("select * from center")
    List<Center> findAllCenter();

    @Select("select * from t_2013")
    List<Sql> findAllSql();

    @Update("update t_2013 set center=#{center} where id = #{id}")
    void updateSql(@Param("id") Integer id, @Param("center") String center);

}
