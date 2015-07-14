package com.bondarenko.es.servlets.user;

import com.bondarenko.es.model.User;
import com.bondarenko.es.service.UserServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by Lil Wayne on 30.06.2015.
 */
@WebServlet(name = "CreateUser")
public class CreateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String firstName = request.getParameter("first");
        String middleName = request.getParameter("middle");
        String lastName = request.getParameter("last");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String sex = request.getParameter("sex");
        User user = new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setSex(sex);
        UserServ userServ = new UserServ();
        userServ.create(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
