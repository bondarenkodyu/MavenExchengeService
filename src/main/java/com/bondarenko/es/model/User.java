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
    private int isBitcoin;
    private int isYandexMoney;
    private int isWebMoneyRUR;
    private int isWebMoneyUSD;
    private int isWebMoneyEUR;
    private int isWebMoneyUAH;

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

    public int getIsBitcoin() {
        return isBitcoin;
    }

    public void setIsBitcoin(int isBitcoin) {
        this.isBitcoin = isBitcoin;
    }

    public int getIsYandexMoney() {
        return isYandexMoney;
    }

    public void setIsYandexMoney(int isYandexMoney) {
        this.isYandexMoney = isYandexMoney;
    }

    public int getIsWebMoneyRUR() {
        return isWebMoneyRUR;
    }

    public void setIsWebMoneyRUR(int isWebMoneyRUR) {
        this.isWebMoneyRUR = isWebMoneyRUR;
    }

    public int getIsWebMoneyUSD() {
        return isWebMoneyUSD;
    }

    public void setIsWebMoneyUSD(int isWebMoneyUSD) {
        this.isWebMoneyUSD = isWebMoneyUSD;
    }

    public int getIsWebMoneyEUR() {
        return isWebMoneyEUR;
    }

    public void setIsWebMoneyEUR(int isWebMoneyEUR) {
        this.isWebMoneyEUR = isWebMoneyEUR;
    }

    public int getIsWebMoneyUAH() {
        return isWebMoneyUAH;
    }

    public void setIsWebMoneyUAH(int isWebMoneyUAH) {
        this.isWebMoneyUAH = isWebMoneyUAH;
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

    public static User buildUser(long id, String firstName, String middleName, String lastName, Date birthday, Timestamp registrationDate, String sex,
                                 int isBitcoin, int isYandexMoney, int isWebMoneyEUR, int isWebMoneyUSD,
                                 int isWebMoneyUAH, int isWebMoneyRUR)
    {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setRegistrationDate(registrationDate);
        user.setSex(sex);
        user.setIsBitcoin(isBitcoin);
        user.setIsYandexMoney(isYandexMoney);
        user.setIsWebMoneyEUR(isWebMoneyEUR);
        user.setIsWebMoneyUSD(isWebMoneyUSD);
        user.setIsWebMoneyUAH(isWebMoneyUAH);
        user.setIsWebMoneyRUR(isWebMoneyRUR);
        return  user;
    }
}
