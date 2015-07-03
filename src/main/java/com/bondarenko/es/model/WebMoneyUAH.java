package com.bondarenko.es.model;

import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class WebMoneyUAH {

    private BigDecimal amount;
    private long userId;
    private long id;

    public WebMoneyUAH() {
    }

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


    public static WebMoneyUAH buildWebMoneyUAH(long id, long userId, BigDecimal UAH)
    {
        WebMoneyUAH webMoney = new WebMoneyUAH();
        webMoney.setId(id);
        webMoney.setAmount(UAH);
        webMoney.setUserId(userId);
        return webMoney;
    }


}
