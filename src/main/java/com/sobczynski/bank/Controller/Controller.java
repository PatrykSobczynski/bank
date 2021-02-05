package com.sobczynski.bank.Controller;

import com.sobczynski.bank.Service.Service;
import com.sobczynski.bank.model.BankTransfer;
import com.sobczynski.bank.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    // todo logowanie
    @GetMapping("/accounts/login")
    public String login(Model model, Double id) {
        model.addAttribute("accounts", service.getAccountList());
        if(id != null) {
            model.addAttribute("account", service.getAccountById(id));
            return "account";
        }
        return "loginPage";
    }

    @GetMapping("/accounts/{id}")
    public String account(Model model, @PathVariable Double id) {
        model.addAttribute("account", service.getAccountById(id));
        model.addAttribute("transfer", service.getTransferById((double) 0));
        return "account";
    }

    @GetMapping("/accounts/{id}/transfer")
    public String transfer(Model model, @PathVariable Double id) {
        model.addAttribute("account", service.getAccountById(id));
        model.addAttribute("transfer", service.getTransfersList());
        model.addAttribute("newTransfer", new BankTransfer());
        return "transfer";
    }

    @GetMapping("/accounts/{id}/takeCredit")
    public String credit(Model model, @PathVariable Double id) {
        model.addAttribute("account", service.getAccountById(id));
        model.addAttribute("credit", service.getCreditList());
        model.addAttribute("newCredit", new Credit());
        return "credit";
    }

    @PostMapping("/accounts/{id}/payout")
    public String payOut(@PathVariable Double id) {
        service.payOutCash10(id);
        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/{id}/transferFinalize")
    public String submitTransfer(@ModelAttribute BankTransfer eTransfer, @PathVariable Double id) {

        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.setSenderId(id);
        bankTransfer.setReceiverId(eTransfer.getReceiverId());
        bankTransfer.setCashTransfer(eTransfer.getCashTransfer());

        service.transferMoney(bankTransfer, bankTransfer.getSenderId(), bankTransfer.getReceiverId(), bankTransfer.getCashTransfer());

        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/{id}/takeCreditFinalize")
    public String submitCredit(@ModelAttribute Credit eCredit, @PathVariable Double id) {

        Credit credit = new Credit();
        credit.setAccountId(id);
        credit.setCash(eCredit.getCash());

        service.takeCredit(credit, credit.getAccountId(), credit.getCash(), credit.getBankInterest());

        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/{id}/payOffTheCredit")
    public String payOffCredit(@PathVariable Double id) {
        service.payOffTheCredit(id);
        return "redirect:/accounts/{id}";
    }
}
