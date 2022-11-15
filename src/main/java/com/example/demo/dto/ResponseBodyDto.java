package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBodyDto<T> {

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("body")
	private T body;

	public ResponseBodyDto(T body) {
		this.body = body;
		this.msg = "請求完成";
	}

	public ResponseBodyDto(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
