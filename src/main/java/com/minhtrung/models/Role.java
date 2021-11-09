package com.minhtrung.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor
public class Role {
	private Long id;
	private String name;
    private String code;
}
