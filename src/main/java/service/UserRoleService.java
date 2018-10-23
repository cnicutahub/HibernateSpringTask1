package service;

import dao.UserRoleDao;
import dao.UserRoleDaoImplementation;
import model.UserRole;

import java.util.List;


public class UserRoleService {
    private UserRoleDaoImplementation userRoleDao;

    public UserRoleService() {
        userRoleDao = new UserRoleDaoImplementation();
    }

    public void persist(UserRole entity) {
        userRoleDao.openCurrentSessionWithTransaction();
        userRoleDao.persist(entity);
        userRoleDao.closeCurrentSessionWithTransaction();
    }

    public void update(UserRole entity) {
        userRoleDao.openCurrentSessionWithTransaction();
        userRoleDao.update(entity);
        userRoleDao.closeCurrentSessionWithTransaction();
    }

    public UserRole findById(Integer id) {
        userRoleDao.openCurrentSession();
        UserRole userRole = userRoleDao.findById(id);
        userRoleDao.closeCurrentSession();
        return userRole;
    }

    public void delete(Integer id) {
        userRoleDao.openCurrentSessionWithTransaction();
        UserRole role = userRoleDao.findById(id);
        userRoleDao.delete(role);
        userRoleDao.closeCurrentSessionWithTransaction();
    }

    public List<UserRole> findAll() {
        userRoleDao.openCurrentSession();
        List<UserRole> userRole = userRoleDao.findAll();
        userRoleDao.closeCurrentSession();
        return userRole;
    }

    public void deleteAll() {
        userRoleDao.openCurrentSessionWithTransaction();
        userRoleDao.deleteAll();
        userRoleDao.closeCurrentSessionWithTransaction();
    }

    public UserRoleDao userRoleDao() {
        return userRoleDao;
    }
}
