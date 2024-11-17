package com.example.bank.service;

import java.util.List;

import com.example.bank.entity.Account;

public interface AccountService {
	
	// THIS INTERFACE WILL BE OUR DESIGN LAYER OF OUR APPLICATION.HERE 
	// WE CAN PROVIDE ALL THE DESIGN THINGS THAT WE NEED TO IMPLEMENT IN OUR APPLICATION

	public Account createAccount(Account account);
	public Account getAccDetails(Integer accountNo);
	public List<Account>getAllAccs();
	public Account depositAmount(Integer accountNo,Double amount);
	public Account withdrawAmount(Integer accountNo,Double amount);
	public void closeAccount(Integer accountNo);
	
}
