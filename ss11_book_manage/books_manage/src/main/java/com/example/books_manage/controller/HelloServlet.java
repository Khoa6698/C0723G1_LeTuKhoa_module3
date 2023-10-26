package com.example.books_manage.controller;

import com.example.books_manage.model.Book;
import com.example.books_manage.service.BookService;
import com.example.books_manage.service.IBookService;

import java.awt.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/book")
public class HelloServlet extends HttpServlet {
    private final IBookService bookService = new BookService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateBook(request, response);
                break;
            case "edit":
                showEditBook(request, response);
                break;
            case "delete":
                showDeleteBook(request, response);
                break;
            default:
                listBook(request, response);
                break;
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Book> lists = this.bookService.findAll();
            request.setAttribute("books", lists);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.findAll();
        bookService.deleteBook(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("bookList",bookList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = this.bookService.findById(id);
        request.setAttribute("book", book);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateBook(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editBook(req, resp);
                break;
            case "new":
                newBook(req,resp);
                break;
            case "search":
                searchByName(req,resp);
                break;
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        Book book = bookService.findByTitle(req.getParameter("title"));
        String notFound = "Not Book found!";
        if(book!=null){
            req.setAttribute("result",book);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("search.jsp");
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            List<Book> books = bookService.findAll();
            req.setAttribute("books",books);
            req.setAttribute("reselt", notFound);
            RequestDispatcher requestDispatcher =req.getRequestDispatcher("/index.jsp");
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void newBook(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        Book book = new Book( title, pageSize, author, category);
        bookService.newBook(book);
        List<Book> books = bookService.findAll();
        req.setAttribute("books",books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editBook(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        Book book = new Book(id, title, pageSize, author, category);
        bookService.updateBook(book);
        List<Book> books = bookService.findAll();
        req.setAttribute("book", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}