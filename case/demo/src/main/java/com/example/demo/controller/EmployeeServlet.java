package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDOT;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.IAccountService;
import com.example.demo.service.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":
                showFormDetail(req,resp);
                break;
            case "update":
                formUpdate(req,resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void formUpdate(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeService.findById(id);
        req.setAttribute("employee",employee);
        req.setAttribute("account", accountService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view_admin/update.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDetail(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeService.findById(id);
        req.setAttribute("employee",employee);
        req.setAttribute("account", accountService.findAll());
//        req.setAttribute("list", accounts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view_admin/detail.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> list = employeeService.listEmp();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view_admin/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                delete(req,resp);
                break;
            case "create":
                create(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
            case "update":
                update(req,resp);
                break;
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String birthDay = req.getParameter("birthDay");;
        String phone = req.getParameter("phone");
        String img = req.getParameter("img");
        int accountId = Integer.parseInt(req.getParameter("accountId"));
        EmployeeDOT employeeDOT = new EmployeeDOT(id,name,birthDay,phone,img,accountId);
        employeeService.updateEmployee(employeeDOT);
        try {
            resp.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        req.setAttribute("employee", employeeService.searchByName(name));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view_admin/search.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) {
        String name =req.getParameter("name");
        String passWord =  req.getParameter("passWord");
        String typeAc = req.getParameter("typeAc");
        Account account = new Account(name,passWord,typeAc);
        accountService.createAccount(account);
        try {
            resp.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeService.deleteEmployee(id);
        try {
            resp.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}