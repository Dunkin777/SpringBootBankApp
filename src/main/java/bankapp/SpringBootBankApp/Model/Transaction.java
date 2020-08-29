package bankapp.SpringBootBankApp.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_from")
    private Integer accountFrom;
    @Column(name = "account_to")
    private Integer accountTo;
    @Column(name = "money")
    private Integer money;
    @Column(name = "date")
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_from", referencedColumnName = "id", insertable = false, updatable = false)
    private Account accountByAccountFrom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_to", referencedColumnName = "id", insertable = false, updatable = false)
    private Account accountByAccountTo;

    public Transaction() {
    }

    public Transaction(Integer accountFrom, Integer accountTo, Integer money, Date date) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
        this.date = date;
    }
}
