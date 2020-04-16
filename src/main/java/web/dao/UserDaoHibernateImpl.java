package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Consumer;

@Repository
@Transactional
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User application) {
        em.persist(application);
    }

    @Override
    public void deleteUser(int userId) {
        em.remove(getUserById(userId));
    }

    @Override
    public void updateUser(User application) {
        em.merge(application);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("FROM " + User.class.getName()).getResultList();
    }

    @Override
    public User getUserById(int userId) {
        return (User) em.find(User.class, userId);
    }

}
