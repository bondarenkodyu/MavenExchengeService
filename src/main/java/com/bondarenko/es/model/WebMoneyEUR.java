package com.bondarenko.es.model;

import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class WebMoneyEUR {


    private BigDecimal amount;
    private long userId;
    private long id;
    private final String name = "WebMoneyEUR";

    public String getName() {
        return name;
    }

    public WebMoneyEUR() {
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


    public static WebMoneyEUR buildWebMoneyEUR(long id, long userId, BigDecimal EUR)
    {
        WebMoneyEUR webMoney = new WebMoneyEUR();
        webMoney.setId(id);
        webMoney.setAmount(EUR);
        webMoney.setUserId(userId);
        return webMoney;
    }
}
