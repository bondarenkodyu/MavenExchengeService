package com.bondarenko.es.model;

import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 17.06.15.
 */
public class YandexMoney {



    private  long id;
    private  long userId;
    private BigDecimal amount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long user_id) {
        this.userId = user_id;
    }

    public static YandexMoney buildYandexMoney(long id, long userId, BigDecimal RUR)
    {
        YandexMoney yandexMoney = new YandexMoney();
        yandexMoney.setId(id);
        yandexMoney.setUserId(userId);
        yandexMoney.setAmount(RUR);
        return yandexMoney;
    }
}
