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

/**
 * Created by Lil Wayne on 13.07.2015.
 */
@WebServlet(name = "DeleteWebMoneyRUR", urlPatterns = "/DeleteWebMoneyRUR")
public class DeleteWebMoneyRUR extends HttpServlet {
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                long userId = Long.parseLong(request.getParameter("userId"));
                WebMoneyRurServ webMoneyRurServ = new WebMoneyRurServ();
                WebMoneyRUR webMoneyRUR = webMoneyRurServ.read(userId);
                webMoneyRurServ.delete(webMoneyRUR);
                UserServ userServ = new UserServ();
                User user = userServ.read(userId);
                user.setIsWebMoneyRUR(0);
                boolean result = userServ.update(user);
                if (result)
                    request.getRequestDispatcher("successful.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
            }catch (Exception e){
                request.getRequestDispatcher("notSuccessful.jsp").forward(request, response);
            }

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }
}
