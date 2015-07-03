package com.bondarenko.es.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Lil Wayne on 17.06.15.
 */
public class User {

    private long id;
    private String firstName;
    private  String middleName;
    private  String lastName;
    private Date birthday;
    private Timestamp registrationDate;
    private String sex;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static User buildUser(long id, String firstName, String middleName, String lastName, Date birthday, Timestamp registrationDate, String sex)
    {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setRegistrationDate(registrationDate);
        user.setSex(sex);
        return  user;
    }
}
