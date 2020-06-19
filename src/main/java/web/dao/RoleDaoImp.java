package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImp implements RoleDao {

    private static final long idUser = 1L;
    private static final long idAdmin = 2L;

    private SessionFactory sessionFactory;

    public RoleDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRoleUser() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("FROM Role WHERE id =" + idUser);
        Role role = query.getSingleResult();
        List<Role> roleSet = new LinkedList<>();
        roleSet.add(role);
        return role;
    }

    @Override
    public Role getRoleAdmin() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("FROM Role WHERE id =" + idAdmin);
        Role role = query.getSingleResult();
        List<Role> roleSet = new LinkedList<>();
        roleSet.add(role);
        return role;
    }
}
