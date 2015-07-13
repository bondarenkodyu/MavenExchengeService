package com.bondarenko.es.service;

import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.dao.YandexMoneyDAO;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.YandexMoney;

/**
 * Created by Lil Wayne on 08.07.2015.
 */
public class YandexMoneyServ {


    public void create(YandexMoney yandexMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        YandexMoneyDAO yandexMoneyDAO = daoFactory.getYandexMoneyDAO();
        yandexMoneyDAO.create(yandexMoney);
    }


    public YandexMoney read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        YandexMoneyDAO yandexMoneyDAO = daoFactory.getYandexMoneyDAO();
        return yandexMoneyDAO.read(userId);
    }


    public boolean update(YandexMoney yandexMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        YandexMoneyDAO yandexMoneyDAO = daoFactory.getYandexMoneyDAO();
        return yandexMoneyDAO.update(yandexMoney);
    }


    public boolean delete(YandexMoney yandexMoney) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        YandexMoneyDAO yandexMoneyDAO = daoFactory.getYandexMoneyDAO();
        return yandexMoneyDAO.delete(yandexMoney);
    }
}
