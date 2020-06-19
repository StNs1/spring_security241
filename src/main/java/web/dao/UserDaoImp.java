package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserById(long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = : id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :param_email");
        query.setParameter("param_email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
