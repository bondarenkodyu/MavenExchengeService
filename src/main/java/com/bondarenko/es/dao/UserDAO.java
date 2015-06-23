package com.bondarenko.es.dao;

import com.bondarenko.es.model.User;

/**
 * Created by Lil Wayne on 17.06.15.
 */
public interface UserDAO {

    void create(User user);

    User read(long userId);

    boolean update(User user);

    boolean delete(User user);

}
