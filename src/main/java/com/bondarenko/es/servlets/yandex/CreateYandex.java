package com.bondarenko.es.servlets.yandex;

import com.bondarenko.es.dao.YandexMoneyDAO;
import com.bondarenko.es.model.User;
import com.bondarenko.es.model.YandexMoney;
import com.bondarenko.es.service.UserServ;
import com.bondarenko.es.service.YandexMoneyServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 08.07.2015.
 */
@WebServlet(name = "CreateYandex", urlPatterns = "/CreateYandex")
public class CreateYandex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            YandexMoneyServ yandexMoneyServ = new YandexMoneyServ();
            YandexMoney yandexMoney = new YandexMoney();
            yandexMoney.setUserId(userId);
            yandexMoney.setAmount(new BigDecimal(0));
            yandexMoneyServ.create(yandexMoney);
            UserServ userServ = new UserServ();
            User user = userServ.read(userId);
            user.setIsYandexMoney(1);
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
