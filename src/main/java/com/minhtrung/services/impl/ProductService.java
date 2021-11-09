package com.minhtrung.services.impl;

import java.sql.Timestamp;
import java.util.List;

import com.minhtrung.daos.IProductDAO;
import com.minhtrung.daos.impl.ProductDAO;
import com.minhtrung.models.Product;
import com.minhtrung.paging.Pageble;
import com.minhtrung.services.IProductService;

public class ProductService implements IProductService{

	private IProductDAO dao = new ProductDAO();
	
	@Override
	public List<Product> getAll(Pageble pageble) {
		return dao.getAll(pageble);
	}

	@Override
	public Product findOne(Long id) {
		return dao.findOne(id);
	}

	@Override
	public Long insert(Product product) {
		product.setCreateTime(getCurrentTime());
		return dao.insert(product);
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	@Override
	public void update(Product product) {
		product.setUpdateTime(getCurrentTime());
		dao.update(product);
		
	}
	
	@Override
	public void delete(Long[] ids) {
		for(int i = 0; i<ids.length;i++) {
			dao.delete(ids[i]);
		}
	}
	
}
