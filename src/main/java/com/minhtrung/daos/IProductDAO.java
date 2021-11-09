package com.minhtrung.daos;

import java.util.List;

import com.minhtrung.models.Product;
import com.minhtrung.paging.Pageble;

public interface IProductDAO {
	List<Product> getAll(Pageble pageble);
	Product findOne(Long id);
	Long insert(Product product);
	void update(Product product);
	void delete(Long id);
}
