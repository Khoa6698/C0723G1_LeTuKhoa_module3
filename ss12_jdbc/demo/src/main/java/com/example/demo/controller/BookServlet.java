package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookDOT;
import com.example.demo.model.Category;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.IBookService;
import com.example.demo.service.ICategoryService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private IBookService bookService = new BookService();
    private ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showForm(req,resp);
                break;
            default:
                bookList(req, resp);
                break;
        }
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/create.jsp");
        List<Category> list = categoryService.showList();
        req.setAttribute("list",list);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bookList(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> list = bookService.fillAll();
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "delete":
                delete(req,resp);
                break;
            case "create":
                create(req,resp);
                break;

        }

    }

    private void create(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        int author = Integer.parseInt(req.getParameter("author"));
        int category = Integer.parseInt(req.getParameter("category"));
        BookDOT bookDOT = new BookDOT(title,pageSize,author,category);
        bookService.save(bookDOT);
        try {
            resp.sendRedirect("/book");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.delete(id);
        try {
            resp.sendRedirect("/book");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}