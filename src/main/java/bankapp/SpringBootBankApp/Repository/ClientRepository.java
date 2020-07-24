package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Account;
import bankapp.SpringBootBankApp.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
   //@Query("SELECT id from Client where name = name")
   Client findClientByName(String name);
}
