package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;
import web.models.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {




    @PersistenceContext
    private EntityManager entityManager;


    @Override // добавить
    public void addUser(User user) {
        User manager = entityManager.merge(user);
        entityManager.persist(manager);
    }

    @Override //обновить
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override // удалить юзера
    public void removeUserById(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    //получаем юзера по айди
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    //получаем список всех юзеров
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=:username",
                User.class).setParameter("username", username);
        return query.getSingleResult();
    }
}
