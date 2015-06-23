package com.bondarenko.es.dao;

import com.bondarenko.es.model.WebMoneyUSD;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public interface WebMoneyUsdDAO {

    void create(WebMoneyUSD webMoney);

    WebMoneyUSD read(long userId);

    boolean update(WebMoneyUSD webMoney);

    boolean delete(WebMoneyUSD webMoney);

}
