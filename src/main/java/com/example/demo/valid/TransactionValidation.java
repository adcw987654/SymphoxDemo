package com.example.demo.valid;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.dto.SendTransactionReqDto;
import com.example.demo.utils.DateUtil;

@Component
public class TransactionValidation implements Validator {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SendTransactionReqDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SendTransactionReqDto reqDto = (SendTransactionReqDto) target;
		String businessTimeStr = reqDto.getBusinessTime();
		LocalDateTime businessTime = DateUtil.parseDateTime(businessTimeStr);
		if (transactionRepository.existsById(reqDto.getTransasctionId())) {
			errors.rejectValue("transasctionId", "trxId.invalid", "transaction_id 不可重覆");
		} 
		if (businessTime.isAfter(LocalDateTime.now())) {
			errors.rejectValue("businessTime", "busTime.invalid", "business_time 不可大於當前時間");
		}
	}

}
