package com.bondarenko.es.dao;

import com.bondarenko.es.model.YandexMoney;

/**
 * Created by Lil Wayne on 17.06.15.
 */
public interface YandexMoneyDAO {

    void create(YandexMoney yandexMoney);

    YandexMoney read(long userId);

    boolean update(YandexMoney yandexMoney);

    boolean delete(YandexMoney yandexMoney);
}
