package com.minhtrung.services;

import java.util.List;

import com.minhtrung.models.Account;

public interface IAccountService {
	List<Account> getAll();
	Account findByUsernameAndPassword(Account account);
	Account findByUsernameAndEmail(Account account);
	Long insert(Account account);
}
