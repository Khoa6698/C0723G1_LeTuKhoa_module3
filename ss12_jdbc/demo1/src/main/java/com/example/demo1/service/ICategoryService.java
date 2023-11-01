package com.example.demo1.service;

import com.example.demo1.model.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);
    List<Category> showList();
}
