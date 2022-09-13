package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "BC_DEBTOR")
public class Debtor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DE_ID")
    public Long id;

    @Column(name = "DE_NAME")
    public String name;

    @ManyToOne(cascade = CascadeType.ALL)
    public Account account;

    public Debtor() {
    }

    public Debtor(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Debtor{" +
                "id=" + id +
                ", user=" + account +
                '}';
    }

}
