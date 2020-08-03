package com.chen.study.response;

public enum ExceptionMsg {
    SUCCESS("200","操作成功"),
    FAILED("999999","操作失败");
    private ExceptionMsg(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
}
