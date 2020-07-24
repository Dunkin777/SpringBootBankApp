package bankapp.SpringBootBankApp.Service;

import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


   private final ClientRepository clientRepository;

    @Autowired
    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client findById(Integer id){
return clientRepository.getOne(id);
    }

    public List<Client> findAll(){
return clientRepository.findAll();
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    //public Integer findByName(String )

}
