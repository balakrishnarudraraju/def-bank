package com.def.account.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
