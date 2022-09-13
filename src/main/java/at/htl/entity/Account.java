package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "seq_account",
        initialValue = 1000
)
@Table(name = "BC_ACCOUNT")
public class Account extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    @Column(name = "AC_ID")
    public Long id;

    @Column(name = "AC_NAME")
    public String name;

    @Column(name = "AC_ADDRESS")
    public String address;

    @Column(name = "AC_PHONE")
    public String phone;

    @Column(name = "AC_EMAIL")
    public String email;

    public Account() {
    }

    public Account(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
