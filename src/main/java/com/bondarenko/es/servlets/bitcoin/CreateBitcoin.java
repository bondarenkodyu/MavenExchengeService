package com.bondarenko.es.servlets.bitcoin;

import com.bondarenko.es.model.Bitcoin;
import com.bondarenko.es.model.User;
import com.bondarenko.es.service.BitcoinServ;
import com.bondarenko.es.service.UserServ;

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
@WebServlet(name = "CreateBitcoin", urlPatterns = "/CreateBitcoin")
public class CreateBitcoin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        long userId = Long.parseLong(request.getParameter("userId"));
        BitcoinServ bitcoinServ = new BitcoinServ();
        Bitcoin bitcoin = new Bitcoin();
        bitcoin.setUserId(userId);
        bitcoin.setAmount(new BigDecimal(0));
        bitcoinServ.create(bitcoin);
        UserServ userServ = new UserServ();
        User user = userServ.read(userId);
        user.setIsBitcoin(1);
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
