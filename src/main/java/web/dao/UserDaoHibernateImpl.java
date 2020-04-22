package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RoleDaoImp roleDaoImp;

    @Override
    public void addUser(User application) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDaoImp.getRoleById((long) 2));
        application.setRoles(roles);
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

    @Override
    public User getUserByUsername(String username) {
        return (User) em.createQuery("FROM User where login =: login")
                .setParameter("login", username)
                .getSingleResult();
    }

}
