package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.entity.TransactionEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	TransactionRepository repository;

	@Test
	void sendTransactionTest() throws Exception {
		String input = getInput("input");
		mockMvc.perform(post("/sendTransaction").content(input).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("msg", is("交易成功")));
		Assert.notEmpty(repository.findAll(), "必須要有交易紀錄");
		// 交易ID重複
		mockMvc.perform(post("/sendTransaction").content(input).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is(400));

		List<TransactionEntity> transactionList = repository.findAll();
		TransactionEntity transaction = transactionList.get(0);
		Assert.isTrue(transaction.getTransactionId().equals("ab93e00b5a96bc1a25b5c4a83305316e"), "transaction_d不符");
		Assert.isTrue(transaction.getCreateBy().equals("RayLiu"), "create_by不符");
		Assert.isTrue(checkProcessCost(transaction.getProcessCost(), transaction.getPointAmount()), "process_cost不符");
	}

	@Test
	void sendErrorTransactionTest() throws Exception {
		String errInput = getInput("errInput");
		mockMvc.perform(post("/sendTransaction").content(errInput).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is(400));
	}

	@Test
	void selectAllTransactionTest() throws Exception {
		mockMvc.perform(post("/getAllTransaction").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("msg", is("請求完成")));
	}

	private String getInput(String input) throws IOException {
		return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(input + ".json"),
				StandardCharsets.UTF_8);
	}

	private Boolean checkProcessCost(Integer processCost, Integer pointAmount) {
		Integer checkVal = processCost / pointAmount;
		return checkVal <= 500 && checkVal >= 300;
	}

}
