package com.dao;

import java.util.List;

import com.bean.*;
//import com.exception.NoAccountException;

public interface AccountDAO {
	public int saveAccount(Account ac);
	public int updateAccount(Account ac);
	public int deleteAccount(Account ac);
	public Account getAccountById(int aid) ;
	public List<Account> getAccountList();
}
