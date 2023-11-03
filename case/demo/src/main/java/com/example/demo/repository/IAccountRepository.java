package com.example.demo.repository;

import com.example.demo.model.Account;

public interface IAccountRepository {
    Account findById(int id);
}
