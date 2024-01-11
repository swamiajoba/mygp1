package com.bean;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Account {
	@Min(value = 100,message = "Value should be 100 onwords")
	private int aid;
	
	@NotBlank(message = "Enter Customer name")
	private String customer;
	
	@DecimalMin(value = "2000.00",message = "Balance should be minimum 2000.00")
	private double balance;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(int aid, String customer, double balance) {
		super();
		this.aid = aid;
		this.customer = customer;
		this.balance = balance;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", customer=" + customer + ", balance=" + balance + "]";
	}
	
}
