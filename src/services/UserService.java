package services;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Classe de serviços para objetos User
public class UserService {
    // Lista de User que será usada no gerenciamento
    private final List<User> users = new ArrayList<>();

    // Método de adicionar usuários
    public void addUser(User user) {
        users.add(user);
    }

    // Métodos de retornar todos os usuários
    public List<User> getAllUsers() {
        return users;
    }

    // Método que pode retornar um usuário a partir do seu nome
    public Optional<User> getUserByName(String userName) {
        return getAllUsers().stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst();
    }
}
