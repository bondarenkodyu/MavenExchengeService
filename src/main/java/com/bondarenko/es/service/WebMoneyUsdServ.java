package com.bondarenko.es.service;

import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.dao.WebMoneyUsdDAO;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.WebMoneyUSD;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class WebMoneyUsdServ {


    public void create(WebMoneyUSD webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUsdDAO usdDAO = daoFactory.getWebMoneyUsdDAO();
        usdDAO.create(webMoney);
    }


    public WebMoneyUSD read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUsdDAO usdDAO = daoFactory.getWebMoneyUsdDAO();
        return usdDAO.read(userId);
    }


    public boolean update(WebMoneyUSD webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUsdDAO usdDAO = daoFactory.getWebMoneyUsdDAO();
        return usdDAO.update(webMoney);
    }


    public boolean delete(WebMoneyUSD webMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        WebMoneyUsdDAO usdDAO = daoFactory.getWebMoneyUsdDAO();
        return usdDAO.delete(webMoney);
    }
}
