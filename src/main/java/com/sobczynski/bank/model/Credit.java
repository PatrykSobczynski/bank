package com.sobczynski.bank.model;

public class Credit {

    private Integer creditId;
    private Integer accountId;
    private double cash;
    private double cashToReturn;
    private double bankInterest = 0.20;

    public Credit() {
    }

    public Credit(Integer creditId, Integer accountId, double cash, double bankInterest) {
        this.creditId = creditId;
        this.accountId = accountId;
        this.cash = cash;
        this.bankInterest = bankInterest;
    }

    public Integer getCreditId() { return creditId; }
    public void setCreditId(Integer creditId) { this.creditId = creditId; }
    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }
    public double getCash() { return cash; }
    public void setCash(double cash) { this.cash = cash; }
    public double getBankInterest() { return bankInterest; }

    public double getCashToReturn() {
        return cashToReturn;
    }

    public void setCashToReturn(double cashToReturn) {
        this.cashToReturn = cashToReturn;
    }

    public void setBankInterest(double bankInterest) {
        this.bankInterest = bankInterest;
    }
}
