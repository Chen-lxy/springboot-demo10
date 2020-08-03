package com.chen.study.response;

public class Response {

    private String rspCode = "200";
    private String rspMsg = "操作成功";
    private ExceptionMsg msg;

    public Response(ExceptionMsg msg) {
        this.msg = msg;
    }

    public Response(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public Response() {
    }
}
