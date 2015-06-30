package com.bondarenko.es.service;

import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.dao.UserDAO;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.User;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class UserServ {

    public void create(User user) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.create(user);

    }


    public User read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.read(userId);
    }


    public boolean update(User user) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.update(user);
    }


    public boolean delete(User user) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.delete(user);
    }
}
