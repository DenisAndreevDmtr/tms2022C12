package by.teachmeskills.eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String login;
    private String password;
    private String confirmPassword;
    private String name;
    private String surname;
    private LocalDate dateBorn;
    private String eMail;

    public User(String login, String password, String confirmPassword, String name, String surname, LocalDate dateBorn, String eMail) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.surname = surname;
        this.dateBorn = dateBorn;
        this.eMail = eMail;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

