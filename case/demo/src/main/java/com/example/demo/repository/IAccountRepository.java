package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.EmployeeDOT;

import java.util.List;

public interface IAccountRepository {
    Account findById(int id);
    List<Account> findAll();

    Boolean createAccount(Account account);
}
