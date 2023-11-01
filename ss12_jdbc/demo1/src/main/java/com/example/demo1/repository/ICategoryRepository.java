package com.example.demo1.repository;

import com.example.demo1.model.Category;

import java.util.List;

public interface ICategoryRepository {
    Category findById(int id);
    List<Category> showList();
}
