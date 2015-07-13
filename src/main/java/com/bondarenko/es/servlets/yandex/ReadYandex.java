package com.bondarenko.es.servlets.yandex;

import com.bondarenko.es.model.YandexMoney;
import com.bondarenko.es.service.YandexMoneyServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lil Wayne on 08.07.2015.
 */
@WebServlet(name = "ReadYandex", urlPatterns = "/ReadYandex")
public class ReadYandex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      try {
          long userId = Long.parseLong(request.getParameter("userId"));
          YandexMoneyServ yandexMoneyServ = new YandexMoneyServ();
          YandexMoney yandexMoney = yandexMoneyServ.read(userId);
          request.setAttribute("wallet", yandexMoney);
          request.getRequestDispatcher("walletShow.jsp").forward(request, response);
      }catch (Exception e)
      {
          request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
      }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
