package com.minhtrung.daos;

import java.util.List;

import com.minhtrung.models.Account;

public interface IAccountDAO {
	List<Account> getAll();
	Account findByUsernameAndPassword(Account account);
	Account findByUsernameAndEmail(Account account);
	Long insert(Account account);
}
