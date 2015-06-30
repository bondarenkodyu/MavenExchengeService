package com.bondarenko.es.service;

import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.dao.WebMoneyUahDAO;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.WebMoneyUAH;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class WebMoneyUahServ {


    public void create(WebMoneyUAH webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUahDAO uahDAO = daoFactory.getWebMoneyUahDAO();
        uahDAO.create(webMoney);

    }

    public WebMoneyUAH read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUahDAO uahDAO = daoFactory.getWebMoneyUahDAO();
        return uahDAO.read(userId);
    }


    public boolean update(WebMoneyUAH webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUahDAO uahDAO = daoFactory.getWebMoneyUahDAO();
        return uahDAO.update(webMoney);
    }


    public boolean delete(WebMoneyUAH webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUahDAO uahDAO = daoFactory.getWebMoneyUahDAO();
        return uahDAO.delete(webMoney);
    }
}
