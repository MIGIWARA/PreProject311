package ru.buffett.PreProject311.crudApi.dao;


import org.springframework.stereotype.Component;
import ru.buffett.PreProject311.crudApi.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("select u from User u").getResultList();
    }

    @Override
    public User getUserById(int id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        getEntityManager().persist(user);
    }

    @Override
    public void updateUser(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public void removeUser(int id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

}