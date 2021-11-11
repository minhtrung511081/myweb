package com.minhtrung.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class SaleDetail {
	private Long productid;
	private int quantity;
    private float price;
    private Long saleid;
}
