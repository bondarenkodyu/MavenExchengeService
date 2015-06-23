package com.bondarenko.es.dao;


import com.bondarenko.es.model.WebMoneyUAH;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public interface WebMoneyUahDAO {

    void create(WebMoneyUAH webMoney);

    WebMoneyUAH read(long userId);

    boolean update(WebMoneyUAH webMoney);

    boolean delete(WebMoneyUAH webMoney);

}
