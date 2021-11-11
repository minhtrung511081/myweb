package com.minhtrung.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.minhtrung.models.Category;

public class CategoryMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet resultSet) {
		Category category = new Category();
		try {
			category.setName(resultSet.getString("name"));
			category.setCode(resultSet.getString("code"));
			return category;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
