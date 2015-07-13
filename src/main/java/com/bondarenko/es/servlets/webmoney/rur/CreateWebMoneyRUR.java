package com.bondarenko.es.servlets.webmoney.rur;

import com.bondarenko.es.model.User;
import com.bondarenko.es.model.WebMoneyRUR;
import com.bondarenko.es.service.UserServ;
import com.bondarenko.es.service.WebMoneyRurServ;

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
@WebServlet(name = "CreateWebMoneyRUR", urlPatterns = "/CreateWebMoneyRUR")
public class CreateWebMoneyRUR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            WebMoneyRurServ webMoneyRurServ = new WebMoneyRurServ();
            WebMoneyRUR webMoneyRUR = new WebMoneyRUR();
            webMoneyRUR.setUserId(userId);
            webMoneyRUR.setAmount(new BigDecimal(0));
            webMoneyRurServ.create(webMoneyRUR);
            UserServ userServ = new UserServ();
            User user = userServ.read(userId);
            user.setIsWebMoneyRUR(1);
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
