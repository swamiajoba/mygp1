package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

//import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bean.Account;
//import com.exception.NoAccountException;

@Repository("accountDAO")
// @Qualifier(name="accountDAO")
// @Component ("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	 	@Autowired
	  //@Resource  // equivalent  to @Autowired // @Inject
	  private JdbcTemplate jdbcTemplate;

	  /*
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    */
	//@Override
	public int saveAccount(Account ac) {
		// TODO Auto-generated method stub
		String sql="insert into Account values("+ac.getAid()+",'"+ac.getCustomer()+"',"+ac.getBalance()+")";
		int i=jdbcTemplate.update(sql);
		return i;
	}

	//@Override
	public int updateAccount(Account ac) {
		String sql="update Account set holder='"+ac.getCustomer()+"',balance="+ac.getBalance()+" where aid="+ac.getAid();
		int i=jdbcTemplate.update(sql);
		return i;
	}

	//@Override
	public int deleteAccount(Account ac) {
		// TODO Auto-generated method stub
		String sql="delete from Account  where aid="+ac.getAid()+"";
		int i=jdbcTemplate.update(sql);
		return i;
	}
	
	//@Override
	public Account getAccountById(int aid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from account where aid="+aid, 
				new ResultSetExtractor<Account>()
				{

		//			@Override
					public Account extractData(ResultSet rs) 
							throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						System.out.println("Rtrieving account");
						Account ob=new Account();
						if(rs.next())
						{
						ob.setAid(rs.getInt("aid"));
						ob.setCustomer(rs.getString("holder"));
						ob.setBalance(rs.getDouble("balance"));
						}
						System.out.println("Rtrieved account "+ob);
						return ob;
					}
				});	
	}
	
//	@Override
	public List<Account> getAccountList() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from account", 
				new ResultSetExtractor<List<Account>>()
				{

				//	@Override
					public List<Account> extractData(ResultSet rs) 
					throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						List<Account> alist=new ArrayList<Account>();
						while(rs.next())
						{
							Account ob=new Account();
							ob.setAid(rs.getInt("aid"));
							ob.setCustomer(rs.getString("holder"));
							ob.setBalance(rs.getDouble("balance"));
							alist.add(ob);
						}
						return alist;
					}	
				});
}
}
