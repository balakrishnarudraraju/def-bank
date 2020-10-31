package com.def.account.dto.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AccountCreateRequestType {
	
	@NotNull	
	private String type;
	
	@NotNull @Size(min=3, max=3)
	private String currency;
	
	@NotNull
	private String customerId;
		
}
