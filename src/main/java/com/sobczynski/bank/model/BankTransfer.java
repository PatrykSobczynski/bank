package com.sobczynski.bank.model;

public class BankTransfer {

    private double transferId;
    private String titleTransfer;
    private double cashTransfer;
    private double senderId;
    private double receiverId;

    public BankTransfer() {
    }

    public BankTransfer(double transferId, String titleTransfer, double cashTransfer, double senderId, double receiverId) {
        this.transferId = transferId;
        this.titleTransfer = titleTransfer;
        this.cashTransfer = cashTransfer;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public double getTransferId() { return transferId; }
    public void setTransferId(double transferId) { this.transferId = transferId; }
    public String getTitleTransfer() { return titleTransfer; }
    public void setTitleTransfer(String titleTransfer) { this.titleTransfer = titleTransfer; }
    public double getCashTransfer() { return cashTransfer; }
    public void setCashTransfer(double cashTransfer) { this.cashTransfer = cashTransfer; }
    public double getSenderId() { return senderId; }
    public void setSenderId(double senderId) { this.senderId = senderId; }
    public double getReceiverId() { return receiverId; }
    public void setReceiverId(double receiverId) { this.receiverId = receiverId; }
}
