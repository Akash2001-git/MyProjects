package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.entity.Account;

public interface AccountRepo extends JpaRepository<Account,Integer> {

	// THIS INTERFACE WILL HELP TO DO WORK WITH OUR DB. we extends the account repository from JPA REPOSITORY
}
