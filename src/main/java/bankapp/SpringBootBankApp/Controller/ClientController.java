package bankapp.SpringBootBankApp.Controller;

import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Repository.ClientRepository;
import bankapp.SpringBootBankApp.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController (ClientService clientService){
        this.clientService = clientService;
    }


    @GetMapping("/")
    public String index(Model model){
        String siteOwnerName = "Dima";
        model.addAttribute("name", siteOwnerName);
        return "index";
    }

    @GetMapping("/clients")
    public String findAll(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clientsList";
    }


    @PostMapping("/clients")
    public String add(@RequestParam String name,@RequestParam String address,@RequestParam Integer age, Model model){
        Client client = new Client(name,address,age);
        clientService.saveClient(client);
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clientsList";
    }



}
