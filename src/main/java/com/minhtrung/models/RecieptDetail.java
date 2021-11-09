package com.minhtrung.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RecieptDetail {
	private Integer id;
	private Integer quantity;
	private Integer unitPrice;
	private String unit;
	private Integer productId;
	private Integer recieptId;
	private Integer totalMoney;
}
