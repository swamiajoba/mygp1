package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountDAO;
import com.bean.Account;
import com.exception.NoAccountException;

@Service("accountService")
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDAO accountDAO;
	

	//@Override
	public int saveAccount(Account ac) {

		return accountDAO.saveAccount(ac);
	}

	

	//@Override
	public int deleteAccount(Account ac) {

		return accountDAO.deleteAccount(ac);
	}

	//@Override
	public Account getAccountById(int aid) throws NoAccountException{
		Account ob=accountDAO.getAccountById(aid);
		if(ob==null || ob.getAid()==0) {
			throw new NoAccountException("Account with aid "+aid + "does not exists");
		}
		return ob;
	}

	//@Override
	public List<Account> getAccountList() {

		return accountDAO.getAccountList();
	}
	//@Override
	public int deposite(Account ac, double amount) {

		double originalbalance=ac.getBalance();
		double changedbalance=originalbalance+amount;
		if(amount>500)
		{
			ac.setBalance(changedbalance);
		}
		else
		{
			throw new IllegalArgumentException("No valid Amount.Minimum amount should be 500 Amount was "+amount);
		}
		return accountDAO.updateAccount(ac);
	}
	//@Override
	public int withdraw(Account ac, double amount) {

		double originalbalance=ac.getBalance();
		double changedbalance=originalbalance-amount;
		if(amount>1000)
		{
			ac.setBalance(changedbalance);
		}
		else
		{
			throw new IllegalArgumentException("No valid Amount.Minimum amount should be 1000 Amount was "+amount);
		}
		return accountDAO.updateAccount(ac);
	}



	public int updateAccount(Account ac) {

		return accountDAO.updateAccount(ac);
	}

}
