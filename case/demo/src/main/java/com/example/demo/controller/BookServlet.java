package com.example.demo.controller;

import com.example.demo.repository.BookRepository;
import com.example.demo.repository.IBookRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.IBookService;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "book", value = "/book")
public class BookServlet extends HttpServlet {
    private IBookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "search":
                showFormSearch(req,resp);
                break;
        }
    }

    private void showFormSearch(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        req.setAttribute("book", bookService.searchAdvanced(name));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/listBook.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
