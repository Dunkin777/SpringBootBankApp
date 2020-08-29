package bankapp.SpringBootBankApp.Controller;

import bankapp.SpringBootBankApp.Model.Account;
import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Model.Transaction;
import bankapp.SpringBootBankApp.Repository.AccountRepository;
import bankapp.SpringBootBankApp.Repository.ClientRepository;
import bankapp.SpringBootBankApp.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;

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
    /*список клиентов*/
    @GetMapping("/clients")
    public String findAllclients(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clientsList";
    }
    /*список транзакций*/
/*    @GetMapping("/transactions")
    public String findAlltransactions(Model model){
        List<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "transactionList";
    }*/
    /*фильтр клиентов*/
/*    @PostMapping("filter")
    public String filter(@RequestParam Date filter, Model model) {
        if (filter != null && filter.isEmpty()) {

        }
    }*/

    /*добавление клиента*/
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
    /*список клиентов*/
    @GetMapping("/accounts/{name}")
    public String accountsByName(@PathVariable("name") String name, Model model){
        Client client = clientRepository.findClientByName(name);
        List<Account> accountsById = client.getAccountsById();
        model.addAttribute("accountsList", accountsById);
        return "accountsByName";
    }
    /*список аккаунтов по имени (использование join)*/
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
    /*удаление клиента*/
    @GetMapping("/client-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }

}
