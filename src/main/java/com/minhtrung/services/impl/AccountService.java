package com.minhtrung.services.impl;

import java.sql.Timestamp;
import java.util.List;

import com.minhtrung.daos.IAccountDAO;
import com.minhtrung.daos.impl.AccountDAO;
import com.minhtrung.models.Account;
import com.minhtrung.services.IAccountService;

public class AccountService implements IAccountService{

	private IAccountDAO accountDAO = new AccountDAO();
	
	@Override
	public List<Account> getAll() {
		return accountDAO.getAll();
	}

	@Override
	public Account findByUsernameAndPassword(Account account) {
		return accountDAO.findByUsernameAndPassword(account);
	}

	@Override
	public Account findByUsernameAndEmail(Account account) {
		return accountDAO.findByUsernameAndEmail(account);
	}

	@Override
	public Long insert(Account account) {
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		account.setCreateTime(timestamp);
		account.setCreatedBy(account.getFullname());
		return accountDAO.insert(account);
	}
	
	

}
