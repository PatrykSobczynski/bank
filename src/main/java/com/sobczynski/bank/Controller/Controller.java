package com.sobczynski.bank.Controller;

import com.sobczynski.bank.Service.Service;
import com.sobczynski.bank.model.Account;
import com.sobczynski.bank.model.BankTransfer;
import com.sobczynski.bank.model.Credit;
import com.sobczynski.bank.model.Login;
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

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("readLogin", new Login());
        return "login";
    }

    @GetMapping("/accounts/{id}")
    public String account(Model model, @PathVariable Integer id) {
        model.addAttribute("account", service.getAccountById(id));
        return "account";
    }

    @GetMapping("/accounts/{id}/transfer")
    public String transfer(Model model, @PathVariable Integer id) {
        model.addAttribute("account", service.getAccountById(id));
        model.addAttribute("transfer", service.getTransfersList());
        model.addAttribute("newTransfer", new BankTransfer());
        return "transfer";
    }

    @GetMapping("/accounts/{id}/takeCredit")
    public String credit(Model model, @PathVariable Integer id) {
        model.addAttribute("account", service.getAccountById(id));
        model.addAttribute("credit", service.getCreditList());
        model.addAttribute("newCredit", new Credit());
        return "credit";
    }

    @GetMapping("/accounts/{id}/payOffCredit")
    public String payOff(Model model, @PathVariable Integer id) {
        model.addAttribute("account", service.getAccountById(id));
        model.addAttribute("credit", service.getCreditList());
        model.addAttribute("newPayOffCredit", new Credit());
        return "payOffCredit";
    }

    @PostMapping("/accounts/{id}/payout")
    public String payOut(@PathVariable Integer id) {
        service.payOutCash10(id);
        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/{id}/transferFinalize")
    public String submitTransfer(@ModelAttribute BankTransfer eTransfer, @PathVariable Integer id) {

        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.setSenderId(id);
        bankTransfer.setReceiverId(eTransfer.getReceiverId());
        bankTransfer.setCashTransfer(eTransfer.getCashTransfer());

        service.transferMoney(bankTransfer, bankTransfer.getSenderId(), bankTransfer.getReceiverId(), bankTransfer.getCashTransfer());

        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/{id}/takeCreditFinalize")
    public String submitCredit(@ModelAttribute Credit eCredit, @PathVariable Integer id) {

        Credit credit = new Credit();
        credit.setAccountId(id);
        credit.setCash(eCredit.getCash());

        service.takeCredit(credit, credit.getAccountId(), credit.getCash(), credit.getBankInterest());

        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/{id}/payOffTheCreditFinalize")
    public String submitPayOffCredit(@ModelAttribute Credit eCredit, @PathVariable Integer id) {

        Credit credit = new Credit();
        credit.setCashToReturn(eCredit.getCashToReturn());

        service.payOffTheCredit(credit, id, credit.getCashToReturn());

        return "redirect:/accounts/{id}";
    }

    @PostMapping("/accounts/login")
    public String submitLogin(@ModelAttribute Login eLogin) {

        Login login = new Login();
        login.setId(eLogin.getId());

        service.login(login, login.getId(), login.getLogin(), login.getPassword());

        return "redirect:/login";
    }
}
