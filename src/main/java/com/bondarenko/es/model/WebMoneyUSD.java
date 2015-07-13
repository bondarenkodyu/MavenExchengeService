package com.bondarenko.es.model;

import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class WebMoneyUSD {

    private long id;
    private long userId;
    private BigDecimal amount;
    private final String name = "WebMoneyUSD";



    public WebMoneyUSD() {
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

    public String getName() {
        return name;
    }


    public static WebMoneyUSD buildWebMoneyUSD(long id, long userId, BigDecimal USD)
    {
        WebMoneyUSD webMoney = new WebMoneyUSD();
        webMoney.setId(id);
        webMoney.setAmount(USD);
        webMoney.setUserId(userId);
        return webMoney;
    }
}
