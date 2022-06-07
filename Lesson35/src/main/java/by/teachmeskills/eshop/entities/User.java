package by.teachmeskills.eshop.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User extends BaseEntity {
    private String login;
    private String password;
    private String name;
    private String surname;
    private LocalDate dateBorn;
    private String eMail;
    private BigDecimal balance;

    public User(int id, String login, String password, String name, String surname, LocalDate dateBorn, String eMail, BigDecimal balance) {
        super(id);
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateBorn = dateBorn;
        this.eMail = eMail;
        this.balance = balance;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String surname, LocalDate dateBorn, String eMail, BigDecimal balance) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateBorn = dateBorn;
        this.eMail = eMail;
        this.balance = balance;
    }
}