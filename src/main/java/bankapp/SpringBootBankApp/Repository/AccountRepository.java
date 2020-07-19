package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
//репозитории - набор функций общения с базой данных
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
