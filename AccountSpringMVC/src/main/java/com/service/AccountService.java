package com.service;

import java.util.List;

import com.bean.Account;
import com.exception.NoAccountException;

public interface AccountService {
	public int saveAccount(Account ac);
	public int updateAccount(Account ac);
	
	public int deposite(Account ac,double amount);
	public int withdraw(Account ac,double amount);
	public int deleteAccount(Account ac);
	public Account getAccountById(int aid) throws NoAccountException ;
	public List<Account> getAccountList();
}
