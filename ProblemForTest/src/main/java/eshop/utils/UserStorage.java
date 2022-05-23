package eshop.utils;

import eshop.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserStorage {
    private static List<User> users = new ArrayList<>();


    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserStorage.users = users;
    }

    public static boolean сheckUser(String login, String password) {
        for (User u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean сheckUserExist(String login) {
        for (User u : users) {
            if (u.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }


    public static User returnUser(String login, String password) {
        User user = null;
        for (User u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                user = u;
                break;
            }
        }
        return user;
    }
}

