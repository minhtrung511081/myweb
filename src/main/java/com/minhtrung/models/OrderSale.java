package com.minhtrung.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @ToString @Setter @Getter
public class OrderSale extends AbstractModel{
	private String name;
	private int gender;
	private String phone;
    private String status;
    private float total;
    private Long accountid;
    private String paymentscode;
    private String towncode;
    private List<SaleDetail> detail = new ArrayList<>();
}
