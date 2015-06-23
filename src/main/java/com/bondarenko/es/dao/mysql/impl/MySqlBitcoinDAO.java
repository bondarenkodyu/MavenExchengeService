package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.BitcoinDAO;
import com.bondarenko.es.model.Bitcoin;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlBitcoinDAO implements BitcoinDAO {

    private static final String CREATE_BITCOIN = "INSERT INTO bitcoin (user_id, amount) VALUES (?, ?) ";
    private static final String READ_BITCOIN = "SELECT * FROM bitcoin WHERE user_id = ?";
    private static final String UPDATE_BITCOIN = "UPDATE bitcoin SET  amount = ? WHERE user_id = ?";
    private static final String DELETE_BITCOIN = "DELETE FROM bitcoin WHERE id = ?";

    @Override
    public void create(Bitcoin bitcoin) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_BITCOIN);
            int k = 1;
            ps.setLong(k++, bitcoin.getUserId());
            ps.setBigDecimal(k++, bitcoin.getAmount());

            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con,ps);
        }


    }

    @Override
    public Bitcoin read(long userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bitcoin bitcoin = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_BITCOIN);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            rs.next();
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            BigDecimal b = rs.getBigDecimal("amount");
            bitcoin = Bitcoin.buildBitcoin(id, user_id, b );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bitcoin;
    }

    @Override
    public boolean update(Bitcoin bitcoin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_BITCOIN);
            ps.setBigDecimal(k++, bitcoin.getAmount());
            ps.setLong(k++, bitcoin.getUserId());
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
    public boolean delete(Bitcoin bitcoin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 1;
        int a = 0;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_BITCOIN);
            ps.setLong(k++, bitcoin.getId());
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
