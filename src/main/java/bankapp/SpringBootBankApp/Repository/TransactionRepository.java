package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
