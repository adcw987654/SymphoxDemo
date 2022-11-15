package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.dto.SendTransactionReqDto;
import com.example.demo.dto.TransactionResDto;
import com.example.demo.dto.TransactionResDto.TransactionData;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.utils.DateUtil;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;

	public String sendTransaction(SendTransactionReqDto reqDto) {
		TransactionEntity entity = toEntity(reqDto);
		repository.save(entity);
		return "交易成功";
	}

	public TransactionResDto getAllTransaction() {
		TransactionResDto resDto = new TransactionResDto();
		List<TransactionEntity> list = repository.findAll();
		List<TransactionData> transactionList = list.stream().map(this::convertEntity).collect(Collectors.toList());
		resDto.setTransactionList(transactionList);
		return resDto;
	}

	private TransactionData convertEntity(TransactionEntity entity) {
		TransactionData data = new TransactionData();
		BeanUtils.copyProperties(entity, data);
		data.setBusinessTime(DateUtil.formatDateTime(entity.getBusinessTime()));
		data.setCreatedTime(DateUtil.formatDateTime(entity.getCreatedTime()));
		return data;
	}

	private TransactionEntity toEntity(SendTransactionReqDto reqDto) {
		TransactionEntity entity = new TransactionEntity();
		Integer processCost = getProcessCost(reqDto.getPointAmount());
		entity.setProcessCost(processCost);
		entity.setTransactionId(reqDto.getTransasctionId());
		entity.setCreateBy("RayLiu");
		entity.setCreatedTime(LocalDateTime.now());
		entity.setPointAmount(reqDto.getPointAmount());
		entity.setBusinessTime(DateUtil.parseDateTime(reqDto.getBusinessTime()));
		return entity;
	}

	private Integer getProcessCost(Integer pointAmount) {
		Random random = new Random();
		Integer randomNum = random.nextInt(200) + 300;
		return pointAmount * randomNum;
	}

}
