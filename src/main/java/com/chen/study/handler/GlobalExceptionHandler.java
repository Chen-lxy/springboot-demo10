package com.chen.study.handler;

import com.chen.study.exception.BusinessException;
import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map<String,Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        LOGGER.error("缺少请求参数",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        LOGGER.error("缺少请求参数",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error("参数验证失败",e);
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String field = fieldError.getField();
        String code = fieldError.getDefaultMessage();
        String message = String.format("%s:%s",field,code);
        Map<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg",message);
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Map<String,Object> handleBindingException(BindException e){
        LOGGER.error("缺少请求参数",e);
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String field = fieldError.getField();
        String code = fieldError.getDefaultMessage();
        String message = String.format("%s:%s",field,code);
        Map<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg",message);
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Map<String,Object> handleValidationException(ValidationException e){
        LOGGER.error("参数验证失败",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String,Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        LOGGER.error("不支持当前请求方法",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",405);
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String,Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        LOGGER.error("不支持当前媒体类型",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",415);
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    //  自定义异常类
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Map<String,Object> handleBusinessException(BusinessException e){
        LOGGER.error("自定义业务失败",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleException(Exception e){
        LOGGER.error("自定义业务失败",e);
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg",e.getMessage());
        // 如果发生异常则记录日志，写入数据库或其他处理，此处省略
        return map;
    }

}
