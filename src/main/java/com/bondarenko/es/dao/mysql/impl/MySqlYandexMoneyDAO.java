package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.YandexMoneyDAO;
import com.bondarenko.es.model.YandexMoney;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlYandexMoneyDAO implements YandexMoneyDAO {

    private static final String CREATE_YANDEXMONEY = "INSERT INTO yandex_money(user_id, amount) VALUES (?, ?) ";
    private static final String READ_YANDEXMONEY = "SELECT * FROM yandex_money WHERE user_id = ?";
    private static final String UPDATE_YANDEXMONEY = "UPDATE yandex_money SET  amount = ? WHERE user_id = ?";
    private static final String DELETE_YANDEXMONEY = "DELETE FROM yandex_money WHERE id = ?";
    @Override
    public void create(YandexMoney yandexMoney) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_YANDEXMONEY);
            int k = 1;
            ps.setLong(k++, yandexMoney.getUserId());
            ps.setBigDecimal(k++, yandexMoney.getAmount());
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }

    }

    @Override
    public YandexMoney read(long userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        YandexMoney yandexMoney = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_YANDEXMONEY);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            BigDecimal RUR = rs.getBigDecimal("amount");
            yandexMoney = YandexMoney.buildYandexMoney(id, user_id, RUR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }
        return yandexMoney;
    }

    @Override
    public boolean update(YandexMoney yandexMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_YANDEXMONEY);
            ps.setBigDecimal(k++, yandexMoney.getAmount());
            ps.setLong(k++, yandexMoney.getUserId());
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
    public boolean delete(YandexMoney yandexMoney) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_YANDEXMONEY);
            ps.setLong(1, yandexMoney.getId());
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
