package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.AccountDAO;
import com.bean.Account;
import static org.mockito.Mockito.*;


//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
	
	@Mock
	AccountDAO accountDAO;
	
	@InjectMocks
	AccountService accountService=new AccountServiceImpl();

	@Test
	public void testCreateAccount() {
		Account ob=new Account(108,"Deepa",60000.00);
		when(accountDAO.saveAccount(ob)).thenReturn(1);
		
		assertTrue(accountService.saveAccount(ob) == 1);
		
		verify(accountDAO,times(1)).saveAccount(ob);
	}

}
