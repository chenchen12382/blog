package com.chenchen.dao;

import com.chenchen.model.Article;
import com.chenchen.model.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
public interface ArticleDao {

    @Insert("insert into t_note_type (type_name,user_id) values(#{typeName},#{userId})")
    void insertTag(Tag tag);

    @Select("select count(1) from t_note_type where type_name=#{typeName}")
    Integer findByTagName(@Param("typeName") String typeName);

    @Select("select id,type_name from t_note_type where user_id=#{userId}")
    List<Tag> selectAllTag(@Param("userId") Integer userId);

    @Delete("DELETE FROM t_note_type WHERE type_name =#{typeName} and user_id=#{userId}")
    void deleteBatch(@Param(value = "typeName") String typeName, @Param(value = "userId") Integer userId);

    @Insert("insert into t_note set title=#{title},img=#{img}, intro=#{intro},content=#{content},type_id=#{typeId},create_date=now() , " +
            " update_date=now()")
    void insert(Article article);
}
