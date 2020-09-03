package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByDateAfter(Date date);
    List<Transaction> findByDateBefore(Date date);
}
