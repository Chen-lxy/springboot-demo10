package com.chen.study.controller;

import com.chen.study.entity.Article;
import com.chen.study.mapper.ArticleMapper;
import com.chen.study.response.ExceptionMsg;
import com.chen.study.response.Response;
import com.chen.study.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class CenterController {

    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }

    protected Response result(){
        return new Response();
    }

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/")
    public ResponseData getAllArticle(){
        List<Article> allArticle = articleMapper.getAllArticle();
        return new ResponseData(ExceptionMsg.SUCCESS,allArticle);
    }

    @PostMapping("/")
    public ResponseData save(Article article){
        articleMapper.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable int id){
        articleMapper.deleteById(id);
        return result(ExceptionMsg.SUCCESS);
    }

    @PutMapping("/")
    public ResponseData update(Article article){
        articleMapper.update(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    @GetMapping("/{id}")
    public ResponseData finById(@PathVariable("id") Integer id){
        Article article = articleMapper.findById(id);
        if (article != null){
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        }else{
            return new ResponseData(ExceptionMsg.FAILED,article);
        }
    }

}
