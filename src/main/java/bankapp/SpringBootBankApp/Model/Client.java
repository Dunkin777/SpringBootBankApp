package bankapp.SpringBootBankApp.Model;


import lombok.Data;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private Integer age;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientByClientId")
    private List<Account> accountsById;

    public Client() {
    }

    public Client(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public List<Account> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(List<Account> accountsById) {
        this.accountsById = accountsById;
    }
}
