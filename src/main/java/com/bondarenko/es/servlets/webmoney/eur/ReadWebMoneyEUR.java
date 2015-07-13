package com.bondarenko.es.servlets.webmoney.eur;

import com.bondarenko.es.model.WebMoneyEUR;
import com.bondarenko.es.service.WebMoneyEurServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 12.07.2015.
 */
@WebServlet(name = "ReadWebMoneyEUR", urlPatterns = "/ReadWebMoneyEUR")
public class ReadWebMoneyEUR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            WebMoneyEurServ webMoneyRurServ = new WebMoneyEurServ();
            WebMoneyEUR webMoneyEUR = webMoneyRurServ.read(userId);

            request.setAttribute("wallet", webMoneyEUR);
            request.getRequestDispatcher("walletShow.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}