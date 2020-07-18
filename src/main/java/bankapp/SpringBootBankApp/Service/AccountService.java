package bankapp.SpringBootBankApp.Service;

import bankapp.SpringBootBankApp.Model.Account;
import bankapp.SpringBootBankApp.Model.Client;
import bankapp.SpringBootBankApp.Repository.AccountRepository;
import bankapp.SpringBootBankApp.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountService (AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account findById(Integer id){
        return accountRepository.getOne(id);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteById(Integer id){
        accountRepository.deleteById(id);
    }

}
