package bankapp.SpringBootBankApp.Controller;

import bankapp.SpringBootBankApp.Model.Account;
import bankapp.SpringBootBankApp.Model.Transaction;
import bankapp.SpringBootBankApp.Repository.AccountRepository;
import bankapp.SpringBootBankApp.Repository.TransactionRepository;
import bankapp.SpringBootBankApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService; //зачем нужен сервис если методы достаются через интерфейс?
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController (AccountService accountService, TransactionRepository transactionRepository,
                              AccountRepository accountRepository){
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    /*вывод аккаунтов*/
    @GetMapping("/accounts")
    public String findAllaccounts(Model model){
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }
    /*вывод транзакций*/
    @GetMapping("/transaction")
    public String findAlltransactions(Model model){
        List<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "transactionList";
    }

    /*@PostMapping("/accounts")
    public String add(@RequestParam Integer clientId, @RequestParam Integer money, Model model){
        Account account = new Account(clientId,money);
        accountService.saveAccount(account);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }*/
/*создание транзакции*/
    @PostMapping("/accounts") //перегрузка метода не работает
    public String addTransaction(@RequestParam(name="accountIDfrom", required = false) Integer accountIDfrom,
                                 @RequestParam(name="accountIDto", required = false) Integer accountIDto,
                                 @RequestParam(name="money", required = false) Integer money, Model model){
        Account accountFrom = accountService.findById(accountIDfrom);
        Integer buff = accountFrom.getMoney();
        accountFrom.setMoney(buff - money);
        Account accountFrom2 = accountService.findById(accountIDto);
        buff = accountFrom2.getMoney();
        accountFrom2.setMoney(buff + money);
        Date date = new Date();
        Transaction transaction = new Transaction(accountIDfrom,accountIDto,money,date);
        transactionRepository.save(transaction);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }

/*    @PostMapping("/accounts")
    public String addMoneyToAccount(@RequestParam(name="accountID", required = false) Integer accountID, @RequestParam Integer money, Model model){
        Account account = accountService.findById(accountID);
        Integer buff = account.getMoney();
        account.setMoney(buff - money);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accountsList";
    }*/


    /*удаление аккаунта(не работает)*/
    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable("id") Integer id){
        accountRepository.deleteById(id);
        return "redirect:/";
    }
    /*добавление денег(не работает)*/
   @GetMapping("/addmoney/{id}/{money}")
    public String addMoney(@PathVariable("id") Integer id, @PathVariable("money") Integer money){
        Account account = accountService.findById(id);
        Integer buff = account.getMoney();
        account.setMoney(buff + money);
        return "redirect:/";
    }
}
