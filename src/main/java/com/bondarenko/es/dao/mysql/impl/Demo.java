package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.model.User;
import com.bondarenko.es.model.WebMoneyEUR;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class Demo {

    public static  void main(String [] args)
    {
        DAOFactory daoFactory = new MySqlDAOFactory();
        MySqlUserDAO userDAO = (MySqlUserDAO) daoFactory.getUserDAO();
        User user = User.buildUser(1, "Vasyl" , "Petrovich", "Schetkov", new Date(122483489L), new Date(36264326L), "M");
        System.out.println(userDAO.read(1));

//        MySqlWebMoneyEurDAO eurDAO = (MySqlWebMoneyEurDAO) daoFactory.getWebMoneyEurDAO();
//        WebMoneyEUR webMoneyEUR = WebMoneyEUR.buildWebMoneyEUR(1, 2, new BigDecimal(986.90));
////        eurDAO.create(webMoneyEUR);
//
//        webMoneyEUR = eurDAO.read(2);
//        webMoneyEUR.setAmount(new BigDecimal(883));
//        System.out.println(eurDAO.read(2));
//        eurDAO.delete(webMoneyEUR);






    }
}
