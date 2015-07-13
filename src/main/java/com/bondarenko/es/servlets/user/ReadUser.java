package com.bondarenko.es.servlets.user;

import com.bondarenko.es.model.User;
import com.bondarenko.es.service.UserServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lil Wayne on 30.06.2015.
 */
@WebServlet(name = "ReadUser", urlPatterns = "/ReadUser")
public class ReadUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        UserServ userServ = new UserServ();
        User user = userServ.read(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/readUser.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
