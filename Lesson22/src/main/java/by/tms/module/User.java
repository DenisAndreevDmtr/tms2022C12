package by.tms.module;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String login;
    private String password;

    {
        login = "логин";
        password = "пароль";
    }
}
