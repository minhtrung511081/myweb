package com.minhtrung.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class PurchaseDetail {
	private String productcode;
	private int quantity;
    private float price;
    private int saleid;
}
