package com.minhtrung.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import com.minhtrung.daos.ICategoryDAO;
import com.minhtrung.models.Product;

public class ProductMapper implements RowMapper<Product>{
	
	@Override
	public Product mapRow(ResultSet resultSet) {
		Product product = new Product();
		try {
			product.setId(resultSet.getLong("id"));
			product.setName(resultSet.getString("name"));
			product.setCode(resultSet.getString("code"));
			product.setPrice(resultSet.getFloat("price"));
			product.setAmount(resultSet.getInt("amount"));
			product.setCategoryid(resultSet.getLong("categoryid"));
			product.setCreatedBy(resultSet.getString("createby"));
			product.setModifiedBy(resultSet.getString("modifiedby"));
			product.setCreateTime(resultSet.getTimestamp("createtime"));
			product.setUpdateTime(resultSet.getTimestamp("updatetime"));
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
