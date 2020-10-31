package com.def.account.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.def.account.dto.input.AccountCreateRequestType;
import com.def.account.dto.output.AccountCreateResponseType;
import com.def.account.entity.Account;
import com.def.account.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	
	@Autowired
	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@MockBean
	private AccountService service;
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	
	@Test
	public void createAccountSuccessful() throws Exception {
		String uri = "/api/v1.0/accounts";

		AccountCreateRequestType acrt = new AccountCreateRequestType();
		acrt.setCurrency("INR");
		acrt.setCustomerId("1234");
		acrt.setType("S");

		Account account = new Account();
		account.setBalance(BigDecimal.ZERO);
		account.setCurrency(acrt.getCurrency());
		account.setNumber(123l);
		account.setStatus('A');
		account.setType("S");
		account.setCustomerId("1234");

		when(service.createAccount(acrt)).thenReturn(account);

		String inputJson = mapToJson(acrt);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		AccountCreateResponseType content = mapFromJson(mvcResult.getResponse().getContentAsString(),
				AccountCreateResponseType.class);
		assertTrue(content.getNumber() != 0, "account got created successfully");
	}

	
	@Test
	public void accountNotFound() throws Exception {
		String uri = "/api/v1.0/accounts/123";

		when(service.getAccount(123l)).thenThrow(new EntityNotFoundException());

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
		
	}
}
