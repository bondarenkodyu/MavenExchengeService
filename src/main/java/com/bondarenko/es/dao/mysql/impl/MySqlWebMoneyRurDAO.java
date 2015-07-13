package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.WebMoneyRurDAO;
import com.bondarenko.es.model.WebMoneyRUR;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlWebMoneyRurDAO implements WebMoneyRurDAO {

    private static final String CREATE_WEBMONEY_RUR = "INSERT INTO webmoney_rur(user_id, amount) VALUES (?, ?) ";
    private static final String READ_WEBMONEY_RUR = "SELECT * FROM webmoney_rur WHERE user_id = ?";
    private static final String UPDATE_WEBMONEY_RUR = "UPDATE webmoney_rur SET  amount = ? WHERE user_id = ?";
    private static final String DELETE_WEBMONEY_RUR = "DELETE FROM webmoney_rur WHERE id = ?";
    @Override
    public void create(WebMoneyRUR webMoney) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_WEBMONEY_RUR);
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
    public WebMoneyRUR read(long userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        WebMoneyRUR webMoney = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_WEBMONEY_RUR);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            BigDecimal RUR = rs.getBigDecimal("amount");
            webMoney = WebMoneyRUR.buildWebMoneyRUR(id, user_id, RUR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }

        return webMoney;
    }

    @Override
    public boolean update(WebMoneyRUR webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_WEBMONEY_RUR);
            ps.setBigDecimal(k++, webMoney.getAmount());
            ps.setLong(k++, webMoney.getUserId());
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
    public boolean delete(WebMoneyRUR webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_WEBMONEY_RUR);
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
