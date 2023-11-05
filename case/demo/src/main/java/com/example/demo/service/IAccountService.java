package com.example.demo.service;

import com.example.demo.model.Account;

import java.util.List;

public interface IAccountService {
    Account findById(int id);

    List<Account> findAll();
}
