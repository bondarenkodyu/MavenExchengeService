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
 * Created by Lil Wayne on 02.07.2015.
 */
@WebServlet(name = "DeleteUser", urlPatterns = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            long id = Long.parseLong(request.getParameter("id"));
            UserServ userServ = new UserServ();
            User user = userServ.read(id);
            boolean result = userServ.delete(user);
            request.setAttribute("user", user);
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
