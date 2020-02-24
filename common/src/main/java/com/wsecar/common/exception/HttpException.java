package com.wsecar.common.exception;

public class HttpException extends RuntimeException {

    private Integer code;

    private String msg;

    public HttpException() {
    }

    public HttpException(Integer code) {
        this.code = code;
    }

    public HttpException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpException(HttpException e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
