package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
