package bankapp.SpringBootBankApp.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "money")
    private Integer money;

    public Account() {
    }

    public Account(Integer clientId, Integer money) {
        this.clientId = clientId;
        this.money = money;
    }

}
