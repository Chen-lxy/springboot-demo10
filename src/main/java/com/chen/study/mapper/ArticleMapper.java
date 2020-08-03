package com.chen.study.mapper;

import com.chen.study.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticleMapper {

    @Select("select * from article")
    List<Article> getAllArticle();

    @Insert("insert into article(title,body) values(#{title},#{body})")
    void save(Article article);

    @Delete("delete from article where id=#{id}")
    void deleteById(Integer id);

    @Update("update article set title=#{title},body=#{body} where id=#{id}")
    void update(Article article);

    @Select("select * from article where id = #{id}")
    Article findById(Integer id);
}
