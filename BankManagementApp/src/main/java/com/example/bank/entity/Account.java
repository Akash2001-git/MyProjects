package com.example.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// THIS CLASS WILL HELPS TO COMMUNICATE OR INTERACT WITH OUR DATABASE
@Entity
@Table(name="Accounts")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountNo;
	@Column(name="Name")
	private String accountHolder;
	@Column(name="Salary")
	private Double balance;
	public Account() {
	
	}
	public Account(String accountHolder, Double balance) {
		super();
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountHolder=" + accountHolder + ", balance=" + balance + "]";
	} 
	
	
	
}
