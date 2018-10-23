package service;

import dao.RoleDao;
import dao.RoleDaoImplementation;
import model.Role;

import java.util.List;


public class RoleService {
    private RoleDaoImplementation roleDao;

    public RoleService() {
        roleDao = new RoleDaoImplementation();
    }

    public void persist(Role entity) {
        roleDao.openCurrentSessionWithTransaction();
        roleDao.persist(entity);
        roleDao.closeCurrentSessionWithTransaction();
    }

    public void update(Role entity) {
        roleDao.openCurrentSessionWithTransaction();
        roleDao.update(entity);
        roleDao.closeCurrentSessionWithTransaction();
    }

    public Role findById(Integer id) {
        roleDao.openCurrentSession();
        Role role = roleDao.findById(id);
        roleDao.closeCurrentSession();
        return role;
    }

    public void delete(Integer id) {
        roleDao.openCurrentSessionWithTransaction();
        Role role = roleDao.findById(id);
        roleDao.delete(role);
        roleDao.closeCurrentSessionWithTransaction();
    }

    public List<Role> findAll() {
        roleDao.openCurrentSession();
        List<Role> role = roleDao.findAll();
        roleDao.closeCurrentSession();
        return role;
    }

    public void deleteAll() {
        roleDao.openCurrentSessionWithTransaction();
        roleDao.deleteAll();
        roleDao.closeCurrentSessionWithTransaction();
    }

    public RoleDao roleDao() {
        return roleDao;
    }
}
