package com.minhtrung.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString @AllArgsConstructor
public class Product{
	private String code;
	private String name;
	private float price;
	private int quantity;
    private Long categorycode;
}
