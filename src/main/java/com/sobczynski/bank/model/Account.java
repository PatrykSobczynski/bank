package com.sobczynski.bank.model;

public class Account {

    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private double moneyOnAccount;
    private Boolean isPremiumAccount;
    private String login;
    private String password;
    private int accountNumber;
    private double debtInBank;

    public Account() {
    }

    public Account(Integer id, String name, String surname, String phoneNumber, double moneyOnAccount, Boolean isPremiumAccount, String login, String password, int accountNumber, double debtInBank) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.moneyOnAccount = moneyOnAccount;
        this.isPremiumAccount = isPremiumAccount;
        this.login = login;
        this.password = password;
        this.accountNumber = accountNumber;
        this.debtInBank = debtInBank;
    }

    public double getDebtInBank() { return debtInBank; }
    public void setDebtInBank(double debtInBank) { this.debtInBank = debtInBank; }
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public double getMoneyOnAccount() { return moneyOnAccount; }
    public void setMoneyOnAccount(double moneyOnAccount) { this.moneyOnAccount = moneyOnAccount; }
    public Boolean getPremiumAccount() { return isPremiumAccount; }
    public void setPremiumAccount(Boolean premiumAccount) { isPremiumAccount = premiumAccount; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
