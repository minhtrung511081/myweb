package com.minhtrung.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.minhtrung.models.Account;
import com.minhtrung.models.Role;

public class AccountMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet resultSet) {
		Account account = new Account();
		try {
			account.setId(resultSet.getLong("id"));
			account.setUsername(resultSet.getString("username"));
			account.setPassword(resultSet.getString("password"));
			account.setFullname(resultSet.getString("fullname"));
			account.setStatus(resultSet.getInt("status"));
			account.setEmail(resultSet.getString("email"));
			account.setRolecode(resultSet.getString("rolecode"));
			account.setCreatedBy(resultSet.getString("createby"));
			account.setUpdateBy(resultSet.getString("updateby"));
			account.setCreateTime(resultSet.getTimestamp("createtime"));
			account.setUpdateTime(resultSet.getTimestamp("updatetime"));
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
