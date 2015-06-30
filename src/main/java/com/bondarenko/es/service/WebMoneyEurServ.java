package com.bondarenko.es.service;


import com.bondarenko.es.dao.DAOFactory;

import com.bondarenko.es.dao.WebMoneyEurDAO;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.WebMoneyEUR;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class WebMoneyEurServ  {

    public void create(WebMoneyEUR webMoney) {

        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyEurDAO eurDAO = daoFactory.getWebMoneyEurDAO();
        eurDAO.create(webMoney);
    }


    public WebMoneyEUR read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyEurDAO eurDAO = daoFactory.getWebMoneyEurDAO();
        return eurDAO.read(userId);
    }


    public boolean update(WebMoneyEUR webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyEurDAO eurDAO = daoFactory.getWebMoneyEurDAO();
        return eurDAO.update(webMoney);
    }


    public boolean delete(WebMoneyEUR webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyEurDAO eurDAO = daoFactory.getWebMoneyEurDAO();
        return eurDAO.delete(webMoney);
    }
}
