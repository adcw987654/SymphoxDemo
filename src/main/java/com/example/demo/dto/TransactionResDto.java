package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResDto {

	@JsonProperty("transaction_list")
	private List<TransactionData> transactionList;

	public static class TransactionData {

		@JsonProperty("transaction_id")
		private String transactionId;

		@JsonProperty("point_amount")
		private Integer pointAmount;

		@JsonProperty("business_time")
		private String businessTime;

		@JsonProperty("process_cost")
		private Integer processCost;

		@JsonProperty("create_by")
		private String createBy;

		@JsonProperty("created_time")
		private String createdTime;
		
		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
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

		public Integer getProcessCost() {
			return processCost;
		}

		public void setProcessCost(Integer processCost) {
			this.processCost = processCost;
		}

		public String getCreateBy() {
			return createBy;
		}

		public void setCreateBy(String createBy) {
			this.createBy = createBy;
		}

		public String getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(String createdTime) {
			this.createdTime = createdTime;
		}

	}

	public List<TransactionData> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<TransactionData> transactionList) {
		this.transactionList = transactionList;
	}

}
