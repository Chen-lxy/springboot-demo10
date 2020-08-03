package com.chen.study.controller;

import com.chen.study.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
public class TestController {

    @RequestMapping("/businessException")
    public String testResponseException(@RequestParam("i") int i) throws Exception {
        if (i == 0){
            throw new BusinessException("自定义业务错误",600);
        }else{
            throw new ValidationException("缺少参数");
        }
    }
}
