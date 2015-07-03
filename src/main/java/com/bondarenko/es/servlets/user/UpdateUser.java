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
 * Created by Lil Wayne on 03.07.2015.
 */
@WebServlet(name = "UpdateUser", urlPatterns = "/UpdateUser")
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        UserServ userServ = new UserServ();
        User user = (User) request.getAttribute("user");
        boolean result = userServ.update(user);
        if (result)
            request.getRequestDispatcher("successful.jsp").forward(request, response);
    }
    catch (Exception e)
    {
        request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
    }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
