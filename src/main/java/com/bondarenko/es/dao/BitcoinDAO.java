package com.bondarenko.es.dao;

import com.bondarenko.es.model.Bitcoin;

/**
 * Created by Lil Wayne on 17.06.15.
 */
public interface BitcoinDAO {

    void create(Bitcoin bitcoin);

    Bitcoin read(long userId);

    boolean update(Bitcoin bitcoin);

    boolean delete(Bitcoin bitcoin);

}
