package ru.buffett.PreProject311.crudApi.dao;


import ru.buffett.PreProject311.crudApi.model.User;

import javax.persistence.EntityManager;
import java.util.List;


public interface UserDao {

    EntityManager getEntityManager();

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);
}