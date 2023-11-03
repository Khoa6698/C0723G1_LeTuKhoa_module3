package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.IAccountRepository;

public class AccountService implements IAccountService{
    private IAccountRepository accountRepository = new AccountRepository();
    @Override
    public Account findById(int id) {
        return accountRepository.findById(id);
    }
}
