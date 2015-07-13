package com.bondarenko.es.model;

import java.math.BigDecimal;

/**
 * Created by Lil Wayne on 17.06.15.
 */
public class Bitcoin {

    private long id;
    private  long userId;
    private BigDecimal amount;
    private final String name = "Bitcoin";

   

    public Bitcoin() {
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

    public void setUserId(long user_id) {
        this.userId = user_id;
    }

    public String getName() {
        return name;
    }

    public static Bitcoin buildBitcoin(long id, long userId, BigDecimal B)
    {
        Bitcoin bitcoin = new Bitcoin();
        bitcoin.setId(id);
        bitcoin.setUserId(userId);
        bitcoin.setAmount(B);
        return bitcoin;
    }

}
