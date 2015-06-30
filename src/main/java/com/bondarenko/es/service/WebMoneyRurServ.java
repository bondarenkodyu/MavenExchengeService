package com.bondarenko.es.service;


import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.dao.WebMoneyRurDAO;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.WebMoneyRUR;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class WebMoneyRurServ {

    public void create(WebMoneyRUR webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyRurDAO rurDAO = daoFactory.getWebMoneyRurDAO();
        rurDAO.create(webMoney);
    }


    public WebMoneyRUR read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyRurDAO rurDAO = daoFactory.getWebMoneyRurDAO();
        return rurDAO.read(userId);
    }


    public boolean update(WebMoneyRUR webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyRurDAO rurDAO = daoFactory.getWebMoneyRurDAO();
        return rurDAO.update(webMoney);
    }


    public boolean delete(WebMoneyRUR webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyRurDAO rurDAO = daoFactory.getWebMoneyRurDAO();
        return rurDAO.delete(webMoney);
    }
}
