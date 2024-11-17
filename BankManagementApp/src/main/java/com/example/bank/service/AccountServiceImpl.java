package com.example.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	// THIS LAYER WILL BE OUR SERVICE LAYER . HERE WILL WILL DO ALL THE IMPLEMENTATIONS
	
	@Autowired 
	AccountRepo repo;

	
	public Account createAccount(Account account) {
		Account acc=repo.save(account);
		return acc;
	}

	
	public Account getAccDetails(Integer accountNo) {     // OPTIONAL WILL GET FROM UTIL PAKAGE
		Optional <Account>account=repo.findById(accountNo);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present!!!");
		}
		Account acc=account.get();
		return acc;
	}

	
	public List<Account> getAllAccs() {
		List<Account>ListofAcc=repo.findAll();
		return ListofAcc;
	}

	
	public Account depositAmount(Integer accountNo, Double amount) {
		Optional <Account>account=repo.findById(accountNo);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present!!!");
		}
		Account accPresent=account.get();
		Double total=accPresent.getBalance()+amount;
		accPresent.setBalance(total);
		repo.save(accPresent);
		return accPresent;
	}

	
	public Account withdrawAmount(Integer accountNo, Double amount) {
		Optional <Account>account=repo.findById(accountNo);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present!!!");
		}
		Account accPre=account.get();
		Double total2=accPre.getBalance()-amount;
		accPre.setBalance(total2);
		repo.save(accPre);
		return accPre;
	}

	public void closeAccount(Integer accountNo) {
		getAccDetails(accountNo);
		repo.deleteById(accountNo);
		
	}

	
}
