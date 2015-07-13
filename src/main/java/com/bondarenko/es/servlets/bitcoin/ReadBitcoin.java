package com.bondarenko.es.servlets.bitcoin;

import com.bondarenko.es.model.Bitcoin;
import com.bondarenko.es.service.BitcoinServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 12.07.2015.
 */
@WebServlet(name = "ReadBitcoin", urlPatterns = "/ReadBitcoin")
public class ReadBitcoin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            BitcoinServ bitcoinServ = new BitcoinServ();
            Bitcoin bitcoin = bitcoinServ.read(userId);
            request.setAttribute("wallet", bitcoin);
            request.getRequestDispatcher("/walletShow.jsp").forward(request, response);
        }catch (Exception e)
        {
            request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
