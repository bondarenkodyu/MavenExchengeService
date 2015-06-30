package com.bondarenko.es.service;

import com.bondarenko.es.dao.BitcoinDAO;
import com.bondarenko.es.dao.DAOFactory;
import com.bondarenko.es.dao.mysql.impl.MySqlDAOFactory;
import com.bondarenko.es.model.Bitcoin;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class BitcoinServ {

    public void create(Bitcoin bitcoin) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        BitcoinDAO bitcoinDAO =  daoFactory.getBitcoinDAO();
        bitcoinDAO.create(bitcoin);
    }


    public Bitcoin read(long userId) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        BitcoinDAO bitcoinDAO =  daoFactory.getBitcoinDAO();
        return bitcoinDAO.read(userId);
    }


    public boolean update(Bitcoin bitcoin) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        BitcoinDAO bitcoinDAO =  daoFactory.getBitcoinDAO();
        return bitcoinDAO.update(bitcoin);
    }


    public boolean delete(Bitcoin bitcoin) {
        DAOFactory daoFactory = new MySqlDAOFactory();
        BitcoinDAO bitcoinDAO =  daoFactory.getBitcoinDAO();
        return bitcoinDAO.delete(bitcoin);
    }
}
