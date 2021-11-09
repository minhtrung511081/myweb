package com.minhtrung.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Email {
	private String from;
	private String to;
	private String fromPassWord;
	private String content;
	private String subject;
}
