package com.bondarenko.es.servlets.bitcoin;

import com.bondarenko.es.model.Bitcoin;
import com.bondarenko.es.model.User;
import com.bondarenko.es.service.BitcoinServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 03.07.2015.
 */
@WebServlet(name = "UpdateBitcoin")
public class UpdateBitcoin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try{
         Bitcoin bitcoin = (Bitcoin) request.getAttribute("bitcoin");
         BitcoinServ bitcoinServ = new BitcoinServ();
         boolean result =  bitcoinServ.update(bitcoin);
         request.getRequestDispatcher("successful.jsp").forward(request, response);
    }
    catch (Exception e) {
        request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
    }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
