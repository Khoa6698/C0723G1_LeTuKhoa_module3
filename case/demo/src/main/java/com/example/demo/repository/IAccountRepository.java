package com.example.demo.repository;

import com.example.demo.model.Account;

import java.util.List;

public interface IAccountRepository {
    Account findById(int id);
    List<Account> findAll();
}
