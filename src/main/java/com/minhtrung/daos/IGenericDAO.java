package com.minhtrung.daos;

import java.util.List;

import com.minhtrung.mapper.RowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql,RowMapper<T> mapper, Object ...objects);
	Long insert(String sql, RowMapper<T> mapper, Object... parameters);
	void update(String sql, Object... parameters);
}
