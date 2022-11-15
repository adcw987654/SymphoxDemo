package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "point_amount")
	private Integer pointAmount;

	@Column(name = "business_time")
	private LocalDateTime businessTime;

	@Column(name = "process_cost")
	private Integer processCost;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "created_time")
	private LocalDateTime createdTime;

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

	public LocalDateTime getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(LocalDateTime businessTime) {
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

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

}
