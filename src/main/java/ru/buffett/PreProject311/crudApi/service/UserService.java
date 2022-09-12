package ru.buffett.PreProject311.crudApi.service;


import ru.buffett.PreProject311.crudApi.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);
}