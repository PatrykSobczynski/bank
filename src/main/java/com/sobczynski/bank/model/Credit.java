package com.sobczynski.bank.model;

public class Credit {

    private double creditId;
    private double accountId;
    private double cash;
    private double bankInterest = 0.20;

    public Credit() {
    }

    public Credit(double creditId, double accountId, double cash, double bankInterest) {
        this.creditId = creditId;
        this.accountId = accountId;
        this.cash = cash;
        this.bankInterest = bankInterest;
    }

    public double getCreditId() { return creditId; }
    public void setCreditId(double creditId) { this.creditId = creditId; }
    public double getAccountId() { return accountId; }
    public void setAccountId(double accountId) { this.accountId = accountId; }
    public double getCash() { return cash; }
    public void setCash(double cash) { this.cash = cash; }
    public double getBankInterest() { return bankInterest; }
    public void setBankInterest(int bankInterest) { this.bankInterest = bankInterest; }
}
