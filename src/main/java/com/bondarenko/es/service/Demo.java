package com.bondarenko.es.service;

import com.bondarenko.es.model.User;

import java.sql.Date;

/**
 * Created by Lil Wayne on 29.06.2015.
 */
public class Demo {


    public static void main(String [] args)
    {
        UserServ userServ = new UserServ();
        userServ.create(User.buildUser(1, "a", "b", "c", new Date(32946326L), new Date(62346723L), "F"));
    }
}
