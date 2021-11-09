package com.minhtrung.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	private String value;
	
	public HttpUtils(String value) {
		this.value = value;
	}
	public <T> T toModel(Class<T> class1) {
		
		try {
			return new ObjectMapper().readValue(value, class1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static HttpUtils of(BufferedReader reader) {
		String line;
		StringBuilder builder = new StringBuilder();
		try {
			while((line = reader.readLine())!=null) {
				builder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new HttpUtils(builder.toString());
	}
}
