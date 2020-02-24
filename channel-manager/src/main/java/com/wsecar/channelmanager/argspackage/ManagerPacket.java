package com.wsecar.channelmanager.argspackage;

import java.io.Serializable;

/**
 * 运营后台请求消息体打包
 */
public class ManagerPacket implements Serializable {

	private String op;		// 操作唯一标识符   服务器和客户端收到数据依据op进行业务逻辑处理
	
	private String token;	// 认证令牌

	private String data;	// 参数数据

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
