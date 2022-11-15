package com.example.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SendTransactionReqDto {

	@JsonProperty("transaction_id")
	@NotBlank
	@Schema(description = "交易編號", example = "ab93e00b5a96bc1a25b5c4a83305316e")
	private String transasctionId;

	@JsonProperty("point_amount")
	@Max(value = 10)
	@Schema(example = "10")
	private Integer pointAmount;

	@JsonProperty("business_time")
	@Schema(description = "交易時間", example = "2022-11-10 10:16:05")
	private String businessTime;

	public String getTransasctionId() {
		return transasctionId;
	}

	public void setTransasctionId(String transasctionId) {
		this.transasctionId = transasctionId;
	}

	public Integer getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(Integer pointAmount) {
		this.pointAmount = pointAmount;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

}
