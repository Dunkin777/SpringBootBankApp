package bankapp.SpringBootBankApp.Repository;

import bankapp.SpringBootBankApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.JavaCompiler;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
