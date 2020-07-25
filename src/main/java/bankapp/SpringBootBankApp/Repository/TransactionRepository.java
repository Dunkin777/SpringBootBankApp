package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {



}
