package com.bondarenko.es.servlets.bitcoin;

import com.bondarenko.es.model.User;

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
@WebServlet(name = "CreateBitcoin", urlPatterns = "CreateBitcoin")
public class CreateBitcoin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            User user = new User();
            long userId = Long.parseLong(request.getParameter("userId"));
            double tmpAmount = Double.parseDouble(request.getParameter("amount"));
            BigDecimal amount = BigDecimal.valueOf(tmpAmount);
            request.getRequestDispatcher("successful.jsp").forward(request, response);
        }
        catch (Exception e){
            request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}