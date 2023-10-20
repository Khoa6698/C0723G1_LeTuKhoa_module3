package com.example.demo.controller;

import com.example.demo.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value ="")
public class StudentServlet extends HttpServlet {
    private static List<Student> studentList;
    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Nguyen Thi A","Nu",10));
        studentList.add(new Student(2,"Truong Cong B","Nam",5));
        studentList.add(new Student(3,"Le Tu C","Nam",9));
        studentList.add(new Student(4,"Bui Van D","Nam",2));
        studentList.add(new Student(5,"Nguyen Huu E","Nam",7));
        studentList.add(new Student(5,"Nguyen Thi G","Nu",8));
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("studentList",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}