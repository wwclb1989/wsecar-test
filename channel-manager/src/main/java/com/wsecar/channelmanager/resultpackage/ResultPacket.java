package com.wsecar.channelmanager.resultpackage;

import java.io.Serializable;

/**
 * 响应结果打包
 */
public class ResultPacket implements Serializable {

    // 响应码
    private Integer code;

    // 响应消息
    private String msg;

    // 响应数据
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
