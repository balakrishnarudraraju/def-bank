package com.def.account.dto.output;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AccountCreateResponseType {
	
    @NotNull
	private Long number;
	
	@NotNull
	private String type;
	
	private BigDecimal balance;
	
	@NotNull @Size(min=3, max=3)
	private String currency;
	
	@NotNull
	private char status;
	
	@NotNull
	private String customerId;
	
}


