package com.bondarenko.es.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Lil Wayne on 23.06.15.
 */
public class Transaction {
    private long id;
    private Timestamp dateOfTr;
    private User userFrom;
    private User userTo;
    private BigDecimal amount;
    private String record;


}
