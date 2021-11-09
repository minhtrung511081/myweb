package com.minhtrung.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class FormUtils {
	@SuppressWarnings("deprecation")
	public static <T> T toModels(Class<T> class1 , HttpServletRequest request){
		T object = null;
		try {
			object = class1.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException |InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return object;
	}
}
