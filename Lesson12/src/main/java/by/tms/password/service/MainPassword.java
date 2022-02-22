package by.tms.password.service;

import by.tms.password.module.Autorization;

public class MainPassword {
    public static void main(String[] args) {
        Autorization.checkAuthorization("qwerty_99", "1234", "1234");
        System.out.println("______");
        Autorization.checkAuthorization("qwerty_99", "1234", "12345");
        System.out.println("______");
        Autorization.checkAuthorization("qwerty_99", "1г234", "1234");
        System.out.println("______");
        Autorization.checkAuthorization("qwe rty_99", "1234", "1234");
    }
}
