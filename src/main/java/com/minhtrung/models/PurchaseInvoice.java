package com.minhtrung.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @ToString @Setter @Getter
public class PurchaseInvoice {
	private String name;
	private int gender;
	private String phone;
    private String status;
    private Long accountid;
    
   
    private Integer totalMoney;
    private String payments;
    private String houseNumber;
    private Integer town_id;
}
