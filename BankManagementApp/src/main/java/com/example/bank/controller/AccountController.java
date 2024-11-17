package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.entity.Account;
import com.example.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;

	// CREATE NEW ACCOUNT DETAILS
	@PostMapping("/create")
	public ResponseEntity<Account> createAcc(@RequestBody Account account) {
		Account createacc=service.createAccount(account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createacc);   // WE WILL GET THE STATUS AS 201 (this is created status)
	}
	
	// GET THE ACCOUNT DETAILS
	@GetMapping("/{accountNo}")
	public Account getAccdetails(@PathVariable Integer accountNo) {
		Account acc=service.getAccDetails(accountNo);
		return acc;
	}
	
	// GET ALL ACCOUNT DETAILS
	@GetMapping("/all")
	public List<Account> allAccs(){
		List<Account>acc=service.getAllAccs();
		return acc;
	}

	// DEPOSIT MONEY TO THE ACCOUNT
	@PutMapping("/deposit/{accountNo}/{amount}")
	public Account depositAccount(@PathVariable Integer accountNo,@PathVariable Double amount) {
		Account acc=service.depositAmount(accountNo, amount);
		return acc;
	}
	
	// WITHDRAW MONEY FROM THE ACCOUNT
		@PutMapping("/withdraw/{accountNo}/{amount}")
		public Account withdrawAccount(@PathVariable Integer accountNo,@PathVariable Double amount) {
			Account acc=service.withdrawAmount(accountNo, amount);
			return acc;
		}
		
	//CLOSE THE ACCOUNT
		@DeleteMapping("/close/{accountNo}")
		public ResponseEntity<String> closeAcc(@PathVariable Integer accountNo){
			service.closeAccount(accountNo);
			return ResponseEntity.ok("ACCOUNT CLOSED");
		}
		
}


















