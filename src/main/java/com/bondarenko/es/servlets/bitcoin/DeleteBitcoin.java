package com.bondarenko.es.servlets.bitcoin;

import com.bondarenko.es.model.User;
import com.bondarenko.es.service.UserServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 03.07.2015.
 */
@WebServlet(name = "DeleteBitcoin", urlPatterns = "DeleteBitcoin")
public class DeleteBitcoin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        long userId = Long.parseLong(request.getParameter("userId"));
        UserServ userServ = new UserServ();
        User user = userServ.read(userId);
        boolean result = userServ.delete(user);
        request.getRequestDispatcher("successful.jsp").forward(request, response);
    }
    catch (Exception e) {
        request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
