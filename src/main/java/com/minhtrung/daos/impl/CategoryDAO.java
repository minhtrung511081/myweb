package com.minhtrung.daos.impl;

import com.minhtrung.daos.ICategoryDAO;
import com.minhtrung.mapper.CategoryMapper;
import com.minhtrung.models.Category;

public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO{

	@Override
	public Category findById(Category category) {
		StringBuilder sql = new StringBuilder("select * from category where id=?");
		return query(sql.toString(), new CategoryMapper(), category.getId()).get(0);
	}

}
