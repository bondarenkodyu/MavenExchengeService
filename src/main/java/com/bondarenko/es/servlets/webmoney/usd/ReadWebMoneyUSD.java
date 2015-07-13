package com.bondarenko.es.servlets.webmoney.usd;

import com.bondarenko.es.model.WebMoneyUSD;
import com.bondarenko.es.service.WebMoneyUsdServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 12.07.2015.
 */
@WebServlet(name = "ReadWebMoneyUSD", urlPatterns = "/ReadWebMoneyUSD")
public class ReadWebMoneyUSD extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            WebMoneyUsdServ webMoneyRurServ = new WebMoneyUsdServ();
            WebMoneyUSD webMoneyUSD = webMoneyRurServ.read(userId);
            request.setAttribute("wallet", webMoneyUSD);
            request.getRequestDispatcher("walletShow.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
