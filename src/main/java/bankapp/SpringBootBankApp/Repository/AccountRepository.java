package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
