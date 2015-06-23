package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.WebMoneyEurDAO;
import com.bondarenko.es.model.WebMoneyEUR;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlWebMoneyEurDAO implements WebMoneyEurDAO {

    private static final String CREATE_WEBMONEY_EUR = "INSERT INTO webmoney_eur(user_id, amount) VALUES (?, ?) ";
    private static final String READ_WEBMONEY_EUR = "SELECT * FROM webmoney_eur WHERE user_id = ?";
    private static final String UPDATE_WEBMONEY_EUR = "UPDATE webmoney_eur SET  amount = ? WHERE id = ?";
    private static final String DELETE_WEBMONEY_EUR = "DELETE FROM webmoney_eur WHERE id = ?";

    @Override
    public void create(WebMoneyEUR webMoney) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_WEBMONEY_EUR);
            int k = 1;
            ps.setLong(k++, webMoney.getUserId());
            ps.setBigDecimal(k++, webMoney.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }

    }

    @Override
    public WebMoneyEUR read(long userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        WebMoneyEUR webMoney = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_WEBMONEY_EUR);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            BigDecimal EUR = rs.getBigDecimal("amount");
            webMoney = WebMoneyEUR.buildWebMoneyEUR(id, user_id, EUR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webMoney;
    }

    @Override
    public boolean update(WebMoneyEUR webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_WEBMONEY_EUR);

            ps.setBigDecimal(k++, webMoney.getAmount());
            ps.setLong(k++, webMoney.getId());

            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con, ps);
        }
        if (a != 1)
            return false;

        return true;
    }

    @Override
    public boolean delete(WebMoneyEUR webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_WEBMONEY_EUR);
            ps.setLong(1, webMoney.getId());
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con, ps);
        }
        if (a != 1)
            return false;

        return true;
    }

}
