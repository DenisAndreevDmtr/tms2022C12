package by.teachmeskills.eshop.model;

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
}

