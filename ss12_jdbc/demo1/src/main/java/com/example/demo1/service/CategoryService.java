package com.example.demo1.service;

import com.example.demo1.model.Category;
import com.example.demo1.repository.CategoryRepository;
import com.example.demo1.repository.Database;
import com.example.demo1.repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository iCategoryRepository = new CategoryRepository();

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public List<Category> showList() {
        return iCategoryRepository.showList();
    }
}
