package com.minhtrung.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Reciept extends AbstractModel{
	private String nameCompany;
	private String nameDeliver;
	private String code;
	private Integer totalMoney;
	private Integer accountId;
}
