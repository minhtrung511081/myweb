package com.minhtrung.daos.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.minhtrung.daos.IProductDAO;
import com.minhtrung.mapper.ProductMapper;
import com.minhtrung.models.Product;
import com.minhtrung.paging.Pageble;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO{

	@Override
	public List<Product> getAll(Pageble pageble) {
		
		
		StringBuilder sql = new StringBuilder("select * from product ");
		if(pageble.getSorter()!=null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy()) ) {
			sql.append(" order by "+pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
			
		}
		if(pageble.getOffset()!=null && pageble.getLimit()!=null) {
			sql.append(" limit ?,? ");
		}
		return query(sql.toString(), new ProductMapper(), pageble.getOffset(), pageble.getLimit());
	}

	@Override
	public Product findOne(Long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product ");
		sql.append("where id=?");
		return query(sql.toString(),new ProductMapper(), id).get(0);
	}
	
	@Override
	public Long insert(Product product) {
		StringBuilder sql = new StringBuilder("insert into product");
		sql.append("(name,code,price,quantity,categorycode,createby,createtime)");
		sql.append(" value (?,?,?,?,?,?,?)");
		return insert(sql.toString(),new ProductMapper(), product.getName(),product.getCode(),
				product.getPrice(),product.getQuantity(),product.getCategorycode(),product.getCreatedBy(),product.getCreateTime());
	}

	@Override
	public void update(Product product) {
		StringBuilder sql = new StringBuilder("update product set ");
		sql.append("name=?, code=?, price=?, quantity=?");
		sql.append(" where categorycode=?");
		update(sql.toString(),product.getName(),product.getCode(), product.getPrice(),product.getQuantity(),product.getCategorycode());
	}

	@Override
	public void delete(Long id) {
		StringBuilder sql = new StringBuilder("delete from product where id=?");
		update(sql.toString(),id);
		
	}

}
