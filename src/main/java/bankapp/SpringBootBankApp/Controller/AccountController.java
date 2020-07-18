package bankapp.SpringBootBankApp.Controller;

import bankapp.SpringBootBankApp.Model.Account;
import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Service.AccountService;
import bankapp.SpringBootBankApp.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController (AccountService accountService){
        this.accountService = accountService;
    }


    @GetMapping("/accounts")
    public String findAll(Model model){
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }


    @PostMapping("/accounts")
    public String add(@RequestParam Integer clientId, @RequestParam Integer money, Model model){
        Account account = new Account(clientId,money);
        accountService.saveAccount(account);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }



}
