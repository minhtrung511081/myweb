package com.minhtrung.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class AbstractModel {
	
    private Long id;
    private Timestamp createTime;
    private Timestamp updateTime;
	private String createdBy;
	private String updateBy;
}
