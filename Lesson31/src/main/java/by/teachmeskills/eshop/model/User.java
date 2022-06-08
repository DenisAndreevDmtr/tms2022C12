package by.teachmeskills.eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@EqualsAndHashCode
public class User {
    private static int idCounter = 1;
    private int idUser;
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
        this.idUser = idCounter++;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.idUser = idCounter++;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public String geteMail() {
        return eMail;
    }
}

