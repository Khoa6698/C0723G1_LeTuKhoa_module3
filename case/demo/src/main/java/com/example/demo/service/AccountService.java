package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.IAccountRepository;

import java.util.List;

public class AccountService implements IAccountService{
    private IAccountRepository accountRepository = new AccountRepository();
    @Override
    public Account findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Boolean createAccount(Account account) {
        return accountRepository.createAccount(account);
    }
}
