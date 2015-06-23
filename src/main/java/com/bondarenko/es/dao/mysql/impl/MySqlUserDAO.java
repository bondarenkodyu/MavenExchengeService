package com.bondarenko.es.dao.mysql.impl;

import com.bondarenko.es.connection.ConnectionUtil;
import com.bondarenko.es.dao.UserDAO;
import com.bondarenko.es.model.User;

import java.sql.*;

/**
 * Created by Lil Wayne on 22.06.15.
 */
public class MySqlUserDAO implements UserDAO {
    private static final String CREATE_USER = "INSERT INTO user (first_name, middle_name, last_name, birthday, sex) VALUES (?, ?, ?, ?, ?) ";
    private static final String READ_USER = "SELECT * FROM user WHERE id = ? ";
    private static final String UPDATE_USER = "UPDATE user SET first_name = ?, middle_name = ?, last_name = ?, birthday = ?, sex = ? WHERE id = ?";
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
            Date registrationDate = rs.getDate("registration_date");
            String sex = rs.getString("sex");
            user = User.buildUser(id, firstName, middleName, lastName, birthday, registrationDate, sex);

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
