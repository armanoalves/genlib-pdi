package services;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserByName(String userName) {
        return getAllUsers().stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst();
    }
}
