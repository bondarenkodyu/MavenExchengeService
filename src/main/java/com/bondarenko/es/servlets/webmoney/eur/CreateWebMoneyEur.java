package com.bondarenko.es.servlets.webmoney.eur;

import com.bondarenko.es.model.User;
import com.bondarenko.es.model.WebMoneyEUR;
import com.bondarenko.es.service.UserServ;
import com.bondarenko.es.service.WebMoneyEurServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 13.07.2015.
 */
@WebServlet(name = "CreateWebMoneyEur", urlPatterns = "/CreateWebMoneyEUR")
public class CreateWebMoneyEur extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            WebMoneyEurServ webMoneyEurServ = new WebMoneyEurServ();
            WebMoneyEUR webMoneyEUR = new WebMoneyEUR();
            webMoneyEUR.setUserId(userId);
            webMoneyEUR.setAmount(new BigDecimal(0));
            webMoneyEurServ.create(webMoneyEUR);
            UserServ userServ = new UserServ();
            User user = userServ.read(userId);
            user.setIsWebMoneyEUR(1);
            userServ.update(user);
            request.getRequestDispatcher("successful.jsp").forward(request, response);
        }catch (Exception e){
            request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
