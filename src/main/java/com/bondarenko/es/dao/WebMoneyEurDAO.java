package com.bondarenko.es.dao;

import com.bondarenko.es.model.WebMoneyEUR;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public interface WebMoneyEurDAO {

    void create(WebMoneyEUR webMoney);

    WebMoneyEUR read(long userId);

    boolean update(WebMoneyEUR webMoney);

    boolean delete(WebMoneyEUR webMoney);
}
