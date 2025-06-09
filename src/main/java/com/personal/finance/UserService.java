package com.personal.finance;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public boolean register(String username, String email, String password) {
        if (users.containsKey(username)) {
            return false; // 用户名已存在
        }
        users.put(username, new User(username, email, password));
        return true;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }
}
