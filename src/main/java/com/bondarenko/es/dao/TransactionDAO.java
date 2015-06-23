package com.bondarenko.es.dao;

import com.bondarenko.es.model.Transaction;


/**
 * Created by Lil Wayne on 23.06.15.
 */
public interface TransactionDAO {

    void create(Transaction transaction);

    Transaction read(long id);

    boolean update(Transaction transaction);

    boolean delete(Transaction transaction);
}
