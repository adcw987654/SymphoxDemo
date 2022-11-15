package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseBodyDto;
import com.example.demo.dto.SendTransactionReqDto;
import com.example.demo.dto.TransactionResDto;
import com.example.demo.service.TransactionService;
import com.example.demo.valid.TransactionValidation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "TransactionController", description = "交易服務管理")
public class TransactionController {

	@Autowired
	TransactionValidation validation;

	@Autowired
	TransactionService service;

	@PostMapping("/sendTransaction")
	@Operation(summary = "新增交易", description = "新增一筆交易")
	public ResponseBodyDto<Object> sendTransaction(@RequestBody @Valid SendTransactionReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		validation.validate(reqDto, bindingResult);

		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		String msg = service.sendTransaction(reqDto);
		return new ResponseBodyDto<Object>(msg);
	}

	@PostMapping("/getAllTransaction")
	@Operation(summary = "取得所有交易紀錄", description = "取得所有交易紀錄")
	public ResponseBodyDto<TransactionResDto> getAllTransaction() throws Exception {
		return new ResponseBodyDto<TransactionResDto>(service.getAllTransaction());
	}

}
