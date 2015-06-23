package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.dao.*;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }

    @Override
    public BitcoinDAO getBitcoinDAO() {
        return new MySqlBitcoinDAO();
    }

    @Override
    public YandexMoneyDAO getYandexMoneyDAO() {
        return new MySqlYandexMoneyDAO();
    }

    @Override
    public WebMoneyUsdDAO getWebMoneyUsdDAO() {
        return new MySqlWebMoneyUsdDAO();
    }

    @Override
    public WebMoneyUahDAO getWebMoneyUahDAO() {
        return new MySqlWebMoneyUahDAO();
    }

    @Override
    public WebMoneyEurDAO getWebMoneyEurDAO() {
        return new MySqlWebMoneyEurDAO();
    }

    @Override
    public WebMoneyRurDAO getWebMoneyRurDAO() {
        return new MySqlWebMoneyRurDAO();
    }
}
