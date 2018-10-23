package dao;

import model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class UserRoleDaoImplementation implements UserRoleDao<UserRole, Integer> {
    private Session currentSession;

    private Transaction currentTransaction;

    public UserRoleDaoImplementation() {
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

    public void persist(UserRole entity) {
        getCurrentSession().save(entity);
    }

    public void update(UserRole entity) {
        getCurrentSession().update(entity);
    }

    public UserRole findById(Integer id) {
        UserRole userRole = getCurrentSession().get(UserRole.class, id);
        return userRole;
    }

    public void delete(UserRole entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<UserRole> findAll() {
        List<UserRole> userRoles = (List<UserRole>) getCurrentSession().createQuery("from UserRole").list();
        return userRoles;
    }

    public void deleteAll() {
        List<UserRole> entityList = findAll();
        for (UserRole entity : entityList) {
            delete(entity);
        }
    }
}
