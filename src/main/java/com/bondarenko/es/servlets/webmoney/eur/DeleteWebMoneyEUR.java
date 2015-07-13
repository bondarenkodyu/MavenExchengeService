package com.bondarenko.es.servlets.webmoney.eur;

import com.bondarenko.es.model.User;
import com.bondarenko.es.model.WebMoneyEUR;
import com.bondarenko.es.service.UserServ;
import com.bondarenko.es.service.WebMoneyEurServ;
import com.bondarenko.es.service.WebMoneyRurServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 13.07.2015.
 */
@WebServlet(name = "DeleteWebMoneyEUR", urlPatterns = "/DeleteWebMoneyEUR")
public class DeleteWebMoneyEUR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            WebMoneyEurServ webMoneyEurServ = new WebMoneyEurServ();
            WebMoneyEUR webMoneyEUR = webMoneyEurServ.read(userId);
            webMoneyEurServ.delete(webMoneyEUR);
            UserServ userServ = new UserServ();
            User user = userServ.read(userId);
            user.setIsWebMoneyEUR(0);
            boolean result = userServ.update(user);
            if (result)
                request.getRequestDispatcher("successful.jsp").forward(request, response);
            else
                request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }catch (Exception e){
            request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
