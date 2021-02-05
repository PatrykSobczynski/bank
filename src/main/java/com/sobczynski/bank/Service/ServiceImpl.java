package com.sobczynski.bank.Service;

import com.sobczynski.bank.model.Account;
import com.sobczynski.bank.model.BankTransfer;
import com.sobczynski.bank.model.Credit;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    public List<Account> accounts;
    public List<BankTransfer> bankTransfers;
    public List<Credit> creditList;

    public ServiceImpl() {
        createAccount();
        createTransfer();
        createCredit();
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
    public BankTransfer getTransferById(Double id) {
        return bankTransfers.stream().filter(bankTransfer -> bankTransfer.getTransferId() == id).findFirst().get();
    }

    @Override
    public Account getAccountById(Double id) {
        return accounts.stream().filter(account -> account.getId() == id).findFirst().get();
    }

    @Override
    public Credit getCreditById(Double id) {
        return creditList.stream().filter(credit -> credit.getCreditId() == id).findFirst().get();
    }

    @Override
    public BankTransfer findTransferById(Double id) {
        return bankTransfers.stream().filter(transfer -> transfer.getTransferId() == id).findFirst().get();
    }

    @Override
    public void payOutCash10(Double id) {
        if(getAccountById(id).getMoneyOnAccount() >= 10) {
            getAccountById(id).setMoneyOnAccount(getAccountById(id).getMoneyOnAccount() - 10);
        }
    }

    @Override
    public void transferMoney(BankTransfer transfer, Double sId, Double rId, Double cash) {
        if(getAccountById(sId).getMoneyOnAccount() >= cash) {
            // Odejmowanie pieniędzy z salda konta robiącego przelew
            getAccountById(sId).setMoneyOnAccount(getAccountById(sId).getMoneyOnAccount() - transfer.getCashTransfer());

            // Dodawanie pieniędzy do konta odbierającego
            getAccountById(rId).setMoneyOnAccount(getAccountById(rId).getMoneyOnAccount() + transfer.getCashTransfer());
        }
    }

    @Override
    public void takeCredit(Credit credit, Double accountId, Double cash, double bankInterest) {
        getAccountById(accountId).setMoneyOnAccount(getAccountById(accountId).getMoneyOnAccount() + cash);
        getAccountById(accountId).setDebtInBank(getAccountById(accountId).getDebtInBank() + cash + cash * bankInterest);
    }

    @Override
    public void payOffTheCredit(Double accountId) {
        if(getAccountById(accountId).getMoneyOnAccount() >= getAccountById(accountId).getDebtInBank()) {
            getAccountById(accountId).setMoneyOnAccount(getAccountById(accountId).getMoneyOnAccount() - getAccountById(accountId).getDebtInBank());
            getAccountById(accountId).setDebtInBank(0);
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
}
