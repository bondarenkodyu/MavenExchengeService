package com.bondarenko.es.dao;

import com.bondarenko.es.model.WebMoneyRUR;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public interface WebMoneyRurDAO {

    void create(WebMoneyRUR webMoney);

    WebMoneyRUR read(long userId);

    boolean update(WebMoneyRUR webMoney);

    boolean delete(WebMoneyRUR webMoney);
}
