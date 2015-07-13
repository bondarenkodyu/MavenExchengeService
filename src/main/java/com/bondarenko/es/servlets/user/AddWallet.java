package com.bondarenko.es.servlets.user;

import com.bondarenko.es.model.User;
import com.bondarenko.es.service.UserServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 12.07.2015.
 */
@WebServlet(name = "AddWallet", urlPatterns = "/AddWallet")
public class AddWallet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("userId"));
        UserServ userServ = new UserServ();
        User user = userServ.read(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/AddWallet.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
