package com.chenchen.dao;

import com.chenchen.base.BaseQuery;
import com.chenchen.dto.CommentQuery;
import com.chenchen.dto.IndexQuery;
import com.chenchen.model.Article;
import com.chenchen.model.Comment;
import com.chenchen.model.Tag;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
public interface ArticleDao {

    @Insert("insert into t_note_type (type_name) values(#{typeName})")
    void insertTag(Tag tag);

    @Select("select count(1) from t_note_type where type_name=#{typeName}")
    Integer findByTagName(@Param("typeName") String typeName);

    @Select("select id,type_name from t_note_type")
    List<Tag> selectAllTag();

    @Delete("DELETE FROM t_note_type WHERE type_name =#{typeName} ")
    void deleteBatch(@Param(value = "typeName") String typeName);

    @Insert("insert into t_note set title=#{title},img=#{img}, intro=#{intro},content=#{content},type_id=#{typeId},create_date=now() , " +
            " update_date=now()")
    void insert(Article article);

    PageList<Article> findAllArticle(IndexQuery query, PageBounds pageBounds);

    @Select("select id,title,img,intro,type_id,content,create_date from t_note where id=#{id}")
    Article findArticleById(@Param("id") Integer id);

    @Select("SELECT id FROM t_note  WHERE id < ${id} ORDER BY id DESC  LIMIT 0,1 ")
    Integer findPrePage(@Param("id") Integer id);

    @Select("select id FROM t_note WHERE id > ${id} ORDER BY id   LIMIT 0,1")
    Integer findNextPage(@Param("id") Integer id);

    @Insert("insert into t_comment (aid,nike_name,content,create_date) values (#{aid},#{nikeName},#{content},now())")
    void insertComment(Comment comment);

    PageList<Comment> findCommentByAid(CommentQuery query, PageBounds pageBounds);

    @Insert("insert into t_img (img,img_name,create_date,update_date) values(#{img},#{fileName},now(),now() )")
    void insertImg(@Param("img") String img, @Param("fileName") String fileName);
}
