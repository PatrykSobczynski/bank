package com.sobczynski.bank.Service;

import com.sobczynski.bank.model.Account;
import com.sobczynski.bank.model.BankTransfer;
import com.sobczynski.bank.model.Credit;
import com.sobczynski.bank.model.Login;

import java.util.List;

public interface Service {

    List<Account> getAccountList();

    List<BankTransfer> getTransfersList();

    List<Credit> getCreditList();

    BankTransfer getTransferById(Integer Id);

    Account getAccountById(Integer id);

    Credit getCreditById(Integer id);

    BankTransfer findTransferById(Integer id);

    void payOutCash10(Integer id);

    void login(Login newLogin, Integer id, String login, String password);

    void transferMoney(BankTransfer transfer, Integer sId, Integer rId, Double cash);

    void takeCredit(Credit credit, Integer accountId, Double cash, double bankInterest);

    void payOffTheCredit(Credit credit, Integer accountId, Double cash);

}
