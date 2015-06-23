package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.WebMoneyUahDAO;
import com.bondarenko.es.model.WebMoneyUAH;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlWebMoneyUahDAO implements WebMoneyUahDAO {

    private static final String CREATE_WEBMONEY_UAH = "INSERT INTO webmoney_uah(user_id, amount) VALUES (?, ?) ";
    private static final String READ_WEBMONEY_UAH = "SELECT * FROM webmoney_uah WHERE user_id = ?";
    private static final String UPDATE_WEBMONEY_UAH = "UPDATE webmoney_uah SET  amount = ? WHERE user_id = ?";
    private static final String DELETE_WEBMONEY_UAH = "DELETE FROM webmoney_uah WHERE id = ?";

    @Override
    public void create(WebMoneyUAH webMoney) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_WEBMONEY_UAH);
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
    public WebMoneyUAH read(long userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        WebMoneyUAH webMoney = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_WEBMONEY_UAH);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            BigDecimal UAH = rs.getBigDecimal("amount");
            webMoney = WebMoneyUAH.buildWebMoneyUAH(id, user_id, UAH);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webMoney;
    }

    @Override
    public boolean update(WebMoneyUAH webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_WEBMONEY_UAH);
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
    public boolean delete(WebMoneyUAH webMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_WEBMONEY_UAH);
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
