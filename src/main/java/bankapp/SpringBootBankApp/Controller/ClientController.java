package bankapp.SpringBootBankApp.Controller;

import bankapp.SpringBootBankApp.Model.Account;
import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Model.Transactions;
import bankapp.SpringBootBankApp.Repository.AccountRepository;
import bankapp.SpringBootBankApp.Repository.ClientRepository;
import bankapp.SpringBootBankApp.Repository.TransactionRepository;
import bankapp.SpringBootBankApp.Service.AccountService;
import bankapp.SpringBootBankApp.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    //private final ClientService clientService;
private final ClientRepository clientRepository;
private final AccountRepository accountRepository;
private final TransactionRepository transactionRepository;

    @Autowired
    public ClientController (ClientRepository clientRepository,AccountRepository accountRepository, TransactionRepository transactionRepository){
        //this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }


    @GetMapping("/")
    public String index(Model model){
        String siteOwnerName = "User";
        model.addAttribute("name", siteOwnerName);
        return "index";
    }

    @GetMapping("/clients")
    public String findAllclients(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clientsList";
    }

    @GetMapping("/transactions")
    public String findAlltransactions(Model model){
        List<Transactions> transactions = transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "transactionList";
    }


    @PostMapping("/clients")
    public String add(@RequestParam String name,@RequestParam String address,@RequestParam Integer age, Model model){
        Client client = clientRepository.findClientByName(name);
        if(client != null){
            model.addAttribute("message", "Client exist!");
        } else {
            client = new Client(name,address,age);
            clientRepository.save(client);
        }
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clientsList";
    }

    @GetMapping("/accounts/{name}")
    public String accountsByName(@PathVariable("name") String name, Model model){
        Client client = clientRepository.findClientByName(name);
        List<Account> accountsById = client.getAccountsById();
        model.addAttribute("accountsList", accountsById);
        return "accountsByName";
    }

    @PostMapping("/accounts/{name}")
    public String addNewAccount(@RequestParam Integer money,@PathVariable("name") String name, Model model){
        Integer client_id = clientRepository.findClientByName(name).getId();
        Account account = new Account(client_id, money);
        accountRepository.save(account);
        Client client = clientRepository.findClientByName(name);
        List<Account> accountsById = client.getAccountsById();
        model.addAttribute("accountsList", accountsById);
        return "accountsByName";
    }

}
