package com.minhtrung.services;

import java.util.List;

import com.minhtrung.models.Product;
import com.minhtrung.paging.Pageble;

public interface IProductService {
	List<Product> getAll(Pageble pageble);
	Product findOne(Long id);
	Long insert(Product product);
	void update(Product product);
	void delete(Long[] ids);
}
