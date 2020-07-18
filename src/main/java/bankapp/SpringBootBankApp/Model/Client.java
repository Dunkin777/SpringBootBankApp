package bankapp.SpringBootBankApp.Model;


import lombok.Data;
import javax.persistence.*;
import java.util.Collection;


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
    /*@OneToMany(mappedBy = "clientsByClientId")
    private Collection<Account> accountsById;*/

    public Client() {
    }

    public Client(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    /*@OneToMany(mappedBy = "clientsByClientId")
    public Collection<Account> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<Account> accountsById) {
        this.accountsById = accountsById;
    }*/

}
