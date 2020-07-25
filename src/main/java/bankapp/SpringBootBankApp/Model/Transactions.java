package bankapp.SpringBootBankApp.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transactions {
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

}
