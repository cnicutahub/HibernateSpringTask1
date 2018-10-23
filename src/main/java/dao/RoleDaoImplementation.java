package dao;

import model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class RoleDaoImplementation implements RoleDao<Role, Integer> {
    private Session currentSession;

    private Transaction currentTransaction;

    public RoleDaoImplementation() {
    }

    private static SessionFactory getSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Role entity) {
        getCurrentSession().save(entity);
    }

    public void update(Role entity) {
        getCurrentSession().update(entity);
    }

    public Role findById(Integer id) {
        Role role = getCurrentSession().get(Role.class, id);
        return role;
    }

    public void delete(Role entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        List<Role> roles = (List<Role>) getCurrentSession().createQuery("from Role").list();
        return roles;
    }

    public void deleteAll() {
        List<Role> entityList = findAll();
        for (Role entity : entityList) {
            delete(entity);
        }
    }
}
