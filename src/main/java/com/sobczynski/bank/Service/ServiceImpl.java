package com.sobczynski.bank.Service;

import com.sobczynski.bank.model.Account;
import com.sobczynski.bank.model.BankTransfer;
import com.sobczynski.bank.model.Credit;
import com.sobczynski.bank.model.Login;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    public List<Account> accounts;
    public List<BankTransfer> bankTransfers;
    public List<Credit> creditList;
    public List<Login> loginList;

    public ServiceImpl() {
        createAccount();
        createTransfer();
        createCredit();
        createLogin();
    }

    @Override
    public List<Account> getAccountList() {
        return accounts;
    }

    @Override
    public List<BankTransfer> getTransfersList() {
        return bankTransfers;
    }

    @Override
    public List<Credit> getCreditList() {return creditList;}

    @Override
    public BankTransfer getTransferById(Integer id) {
        return bankTransfers.stream().filter(bankTransfer -> bankTransfer.getTransferId().equals(id)).findFirst().get();
    }

    @Override
    public Account getAccountById(Integer id) {
        return accounts.stream().filter(account -> account.getId().equals(id)).findFirst().get();
    }


    @Override
    public Credit getCreditById(Integer id) {
        return creditList.stream().filter(credit -> credit.getCreditId().equals(id)).findFirst().get();
    }

    @Override
    public BankTransfer findTransferById(Integer id) {
        return bankTransfers.stream().filter(transfer -> transfer.getTransferId().equals(id)).findFirst().get();
    }

    @Override
    public void payOutCash10(Integer id) {
        if(getAccountById(id).getMoneyOnAccount() >= 10) {
            getAccountById(id).setMoneyOnAccount(getAccountById(id).getMoneyOnAccount() - 10);
        }
    }

    @Override
    public void login(Login login, Integer id, String loginName, String password) {
        login.setId(id);
        login.setLogin(loginName);
        login.setPassword(password);
    }

    @Override
    public void transferMoney(BankTransfer transfer, Integer sId, Integer rId, Double cash) {
        if(getAccountById(sId).getMoneyOnAccount() >= cash) {
            // Odejmowanie pieniędzy z salda konta robiącego przelew
            getAccountById(sId).setMoneyOnAccount(getAccountById(sId).getMoneyOnAccount() - transfer.getCashTransfer());

            // Dodawanie pieniędzy do konta odbierającego
            getAccountById(rId).setMoneyOnAccount(getAccountById(rId).getMoneyOnAccount() + transfer.getCashTransfer());
        }
    }

    @Override
    public void takeCredit(Credit credit, Integer accountId, Double cash, double bankInterest) {
        Account id = getAccountById(accountId);
        id.setMoneyOnAccount(id.getMoneyOnAccount() + cash);
        id.setDebtInBank(id.getDebtInBank() + cash + cash * bankInterest);
    }

    @Override
    public void payOffTheCredit(Credit credit, Integer accountId, Double cash) {
        Account id = getAccountById(accountId);
        if(id.getMoneyOnAccount() >= credit.getCashToReturn()) {
            id.setMoneyOnAccount(id.getMoneyOnAccount() - credit.getCashToReturn());
            id.setDebtInBank(id.getDebtInBank() - credit.getCashToReturn());
        }
    }

    private void createAccount() {
        accounts = new ArrayList<>();

        accounts.add(new Account(0, "Patryk", "Sobczyński", "601111111", 0, false, "Patryk", "Pass", 0001, 0));
        accounts.add(new Account(1, "John", "Macmillan", "666414151", 10580, true, "John", "Pass", 0002, 0));
        accounts.add(new Account(2, "Frank", " Forsyth", "999576356", 540, false, "Frankiee", "Pass", 0003, 0));
        accounts.add(new Account(3, "Lisa", "Lawson", "353484515", 100, false, "Liss", "Pass", 0004, 0));
    }

    private void createTransfer() {
        bankTransfers = new ArrayList<>();
        bankTransfers.add(new BankTransfer());
    }

    private void createCredit() {
        creditList = new ArrayList<>();
        creditList.add(new Credit());
    }

    private void createLogin() {
        loginList = new ArrayList<>();
        loginList.add(new Login());
    }
}
