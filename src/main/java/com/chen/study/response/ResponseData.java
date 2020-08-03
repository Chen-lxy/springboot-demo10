package com.chen.study.response;

public class ResponseData extends Response {

    private Object data;

    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }
}
