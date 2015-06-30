package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.WebMoneyUsdDAO;
import com.bondarenko.es.model.WebMoneyUSD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlWebMoneyUsdDAO implements WebMoneyUsdDAO {

    private static final String CREATE_WEBMONEY_USD = "INSERT INTO webmoney_usd(user_id, amount) VALUES (?, ?) ";
    private static final String READ_WEBMONEY_USD = "SELECT * FROM webmoney_usd WHERE user_id = ?";
    private static final String UPDATE_WEBMONEY_USD = "UPDATE webmoney_usd SET  amount = ? WHERE user_id = ?";
    private static final String DELETE_WEBMONEY_USD = "DELETE FROM webmoney_usd WHERE id = ?";

    @Override
    public void create(WebMoneyUSD webMoney) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_WEBMONEY_USD);
            int k = 1;
            ps.setLong(k++, webMoney.getUserId());
            ps.setBigDecimal(k++, webMoney.getAmount());
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }

    }

    @Override
    public WebMoneyUSD read(long userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        WebMoneyUSD webMoney = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_WEBMONEY_USD);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            BigDecimal USD = rs.getBigDecimal("amount");
            webMoney = WebMoneyUSD.buildWebMoneyUSD(id, user_id, USD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }
        return webMoney;
    }

    @Override
    public boolean update(WebMoneyUSD webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_WEBMONEY_USD);
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
    public boolean delete(WebMoneyUSD webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_WEBMONEY_USD);
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
