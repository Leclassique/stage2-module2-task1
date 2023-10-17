package com.example.servlet;
import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add", value = "/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/add.jsp");
        requestDispatcher.forward(req, resp);
    }
        @Override
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = new User(request.getParameter("firstName"), request.getParameter("lastName"));
        request.setAttribute("user", user);
            Warehouse users = Warehouse.getInstance();
            users.addUser(user);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/add.jsp");
            requestDispatcher.forward(request, response);

    }
}

