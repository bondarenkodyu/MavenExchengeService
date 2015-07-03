package com.bondarenko.es.servlets.webmoney.eur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 03.07.2015.
 */
@WebServlet(name = "CreateWebMoneyEur", urlPatterns = "/CreateWebMoneyEur")
public class CreateWebMoneyEur extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        long userId = Long.parseLong(request.getParameter("userId"));
//        double tmpAmount = Double.parseDouble(request.getParameter("amount"));
//        BigDecimal amount =

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
