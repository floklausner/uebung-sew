package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BC_ENTRY")
public class Entry extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EN_ID")
    public Long id;

    @Column(name = "EN_DATE")
    public LocalDateTime date;

    @Column(name = "EN_AMOUNT")
    public double amount;

    @Column(name = "EN_REASON")
    public String reason;

    @Column(name = "EN_EDITED")
    public boolean edited;

    @ManyToOne
    public Debtor debtor;

    public Entry() {
    }

    public Entry(LocalDateTime date, double amount, String reason, boolean edited, Debtor debtor) {
        this.date = date;
        this.amount = amount;
        this.reason = reason;
        this.edited = edited;
        this.debtor = debtor;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", edited=" + edited +
                ", debtor=" + debtor +
                '}';
    }
}
