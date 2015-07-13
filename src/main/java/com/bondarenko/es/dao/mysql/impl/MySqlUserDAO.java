package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.UserDAO;
import com.bondarenko.es.model.User;

import java.sql.*;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlUserDAO implements UserDAO {
    private static final String CREATE_USER = "INSERT INTO user (first_name, middle_name, last_name, birthday, sex) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String READ_USER = "SELECT * FROM user WHERE id = ? ";
    private static final String UPDATE_USER = "UPDATE user SET first_name = ?, middle_name = ?, last_name = ?, birthday = ?, sex = ?, is_bitcoin = ?, is_yandex_money = ?, is_webmoney_eur = ?," +
            "is_webmoney_usd = ?, is_webmoney_uah = ?, is_webmoney_rur = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
    @Override
    public void create(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int k = 1;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(CREATE_USER);
            ps.setString(k++, user.getFirstName());
            ps.setString(k++, user.getMiddleName());
            ps.setString(k++, user.getLastName());
            ps.setDate(k++, user.getBirthday());
            ps.setString(k++, user.getSex());
            ps.setInt(k++, user.getIsBitcoin());
            ps.setInt(k++, user.getIsYandexMoney());
            ps.setInt(k++, user.getIsWebMoneyEUR());
            ps.setInt(k++, user.getIsWebMoneyUSD());
            ps.setInt(k++, user.getIsWebMoneyUAH());
            ps.setInt(k++, user.getIsWebMoneyRUR());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con, ps);
        }


    }

    @Override
    public User read(long id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(READ_USER);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            rs.next();

            String firstName = rs.getString("first_name");
            String middleName = rs.getString("middle_name");
            String lastName = rs.getString("last_name");
            Date birthday = rs.getDate("birthday");
            Timestamp registrationDate = rs.getTimestamp("registration_date");
            String sex = rs.getString("sex");
            int isBitcoin = rs.getInt("is_bitcoin");
            int isYandexMoney = rs.getInt("is_yandex_money");
            int isWebMoneyEUR = rs.getInt("is_webmoney_eur");
            int isWebMoneyUSD = rs.getInt("is_webmoney_usd");
            int isWebMoneyUAH = rs.getInt("is_webmoney_uah");
            int isWebMoneyRUR = rs.getInt("is_webmoney_rur");
            user = User.buildUser(id, firstName, middleName, lastName, birthday, registrationDate, sex,
                    isBitcoin, isYandexMoney, isWebMoneyEUR, isWebMoneyUSD, isWebMoneyUAH, isWebMoneyRUR);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.close(con, ps);
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int a = 0;
        int k = 1;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_USER);
            ps.setString(k++, user.getFirstName());
            ps.setString(k++, user.getMiddleName());
            ps.setString(k++, user.getLastName());
            ps.setDate(k++, user.getBirthday());
            ps.setString(k++, user.getSex());
            ps.setInt(k++, user.getIsBitcoin());
            ps.setInt(k++, user.getIsYandexMoney());
            ps.setInt(k++, user.getIsWebMoneyEUR());
            ps.setInt(k++, user.getIsWebMoneyUSD());
            ps.setInt(k++, user.getIsWebMoneyUAH());
            ps.setInt(k++, user.getIsWebMoneyRUR());
            ps.setLong(k++, user.getId());
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
    public boolean delete(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int a = 0;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_USER);
            ps.setLong(1, user.getId());

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
