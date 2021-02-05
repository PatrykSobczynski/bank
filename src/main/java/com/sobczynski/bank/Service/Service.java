package com.sobczynski.bank.Service;

import com.sobczynski.bank.model.Account;
import com.sobczynski.bank.model.BankTransfer;
import com.sobczynski.bank.model.Credit;

import java.util.List;

public interface Service {

    List<Account> getAccountList();

    List<BankTransfer> getTransfersList();

    List<Credit> getCreditList();

    BankTransfer getTransferById(Double Id);

    Account getAccountById(Double id);

    Credit getCreditById(Double id);

    BankTransfer findTransferById(Double id);

    void payOutCash10(Double id);

    void transferMoney(BankTransfer transfer, Double sId, Double rId, Double cash);

    void takeCredit(Credit credit, Double accountId, Double cash, double bankInterest);

    void payOffTheCredit(Double accountId);

//    void updateTM(BankTransfer transfer, Double sId, Double rId, Double cash);
}
