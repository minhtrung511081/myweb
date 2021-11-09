package com.minhtrung.daos.impl;

import java.util.List;

import com.minhtrung.daos.IAccountDAO;
import com.minhtrung.mapper.AccountMapper;
import com.minhtrung.models.Account;

public class AccountDAO extends AbstractDAO<Account> implements IAccountDAO{

	@Override
	public List<Account> getAll() {
		StringBuilder sql = new StringBuilder("select * from account natural join role");
		return query(sql.toString(), new AccountMapper());
	}

	@Override
	public Account findByUsernameAndPassword(Account account) {
		StringBuilder sql = new StringBuilder("select * from account natural join role");
		sql.append("where username=? and password=?");
		List<Account> accounts = query(sql.toString(), new AccountMapper(), account.getUsername(),account.getPassword());
		return  accounts.isEmpty() ? null : accounts.get(0);
	}

	@Override
	public Account findByUsernameAndEmail(Account account) {
		StringBuilder sql = new StringBuilder("select * from account natural join role");
		sql.append("where username=? and email=?");
		List<Account> accounts = query(sql.toString(), new AccountMapper(), account.getUsername(),account.getEmail());
		return accounts.isEmpty() ? null : accounts.get(0);
	}

	@Override
	public Long insert(Account account) {
		StringBuilder sql = new StringBuilder("insert account(username,password,fullname,email,createtime)");
		sql.append(" value(?,?,?,?,?)");
		return insert(sql.toString(),null, account.getUsername(),account.getPassword(),account.getFullname(),account.getEmail(),account.getCreateTime());
	}

}
