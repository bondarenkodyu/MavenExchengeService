package com.bondarenko.es.model;

import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class WebMoneyRUR {

    private BigDecimal amount;
    private long userId;
    private long id;

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

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public static WebMoneyRUR buildWebMoneyRUR(long id, long userId, BigDecimal RUR)
    {
        WebMoneyRUR webMoney = new WebMoneyRUR();
        webMoney.setId(id);
        webMoney.setAmount(RUR);
        webMoney.setUserId(userId);
        return webMoney;
    }
}
