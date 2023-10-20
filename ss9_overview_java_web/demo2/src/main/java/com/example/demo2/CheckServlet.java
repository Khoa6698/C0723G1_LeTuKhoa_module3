package com.example.demo2;

import javafx.scene.input.DataFormat;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello")
public class CheckServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (username == null || username.isEmpty()) {
            String error ="Username khong duoc de trong";
            request.setAttribute("Error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (password == null || password.isEmpty()) {
            String error = "Password khong duoc de trong";
            request.setAttribute("Error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!username.matches("admin")) {
            String error ="Username khong hop le";
            request.setAttribute("Error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!password.matches("123abc")) {
            String error = "Password khong hop le";
            request.setAttribute("Error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
            request.setAttribute("date", simpleDateFormat.format(date));
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
