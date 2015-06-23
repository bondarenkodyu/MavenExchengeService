package com.bondarenko.es.dao;



/**
 * Created by Lil Wayne on 17.06.15.
 */
public abstract class DAOFactory {

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (instance == null){
            Class<?> clazz = Class.forName(DAOFactory.daoFactoryFCN);
            instance = (DAOFactory) clazz.newInstance();
        }
        return instance;
    }

    protected DAOFactory() {
    }

    private static String daoFactoryFCN;

    public static void setDaoFactoryFCN(String daoFactoryFCN)
    {
        instance = null;
        DAOFactory.daoFactoryFCN = daoFactoryFCN;
    }

    public abstract UserDAO getUserDAO();

    public abstract BitcoinDAO getBitcoinDAO();

    public abstract YandexMoneyDAO getYandexMoneyDAO();

    public abstract WebMoneyUsdDAO getWebMoneyUsdDAO();

    public abstract WebMoneyUahDAO getWebMoneyUahDAO();

    public abstract WebMoneyEurDAO getWebMoneyEurDAO();

    public abstract WebMoneyRurDAO getWebMoneyRurDAO();

}
