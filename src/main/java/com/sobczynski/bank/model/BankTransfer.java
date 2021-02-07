package com.sobczynski.bank.model;

public class BankTransfer {

    private Integer transferId;
    private String titleTransfer;
    private double cashTransfer;
    private Integer senderId;
    private Integer receiverId;

    public BankTransfer() {
    }

    public BankTransfer(Integer transferId, String titleTransfer, double cashTransfer, Integer senderId, Integer receiverId) {
        this.transferId = transferId;
        this.titleTransfer = titleTransfer;
        this.cashTransfer = cashTransfer;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Integer getTransferId() { return transferId; }
    public void setTransferId(Integer transferId) { this.transferId = transferId; }
    public String getTitleTransfer() { return titleTransfer; }
    public void setTitleTransfer(String titleTransfer) { this.titleTransfer = titleTransfer; }
    public double getCashTransfer() { return cashTransfer; }
    public void setCashTransfer(double cashTransfer) { this.cashTransfer = cashTransfer; }
    public Integer getSenderId() { return senderId; }
    public void setSenderId(Integer senderId) { this.senderId = senderId; }
    public Integer getReceiverId() { return receiverId; }
    public void setReceiverId(Integer receiverId) { this.receiverId = receiverId; }
}
