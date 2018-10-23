package service;

import dao.UserDao;
import dao.UserDaoImplementation;
import model.User;

import java.util.List;


public class UserService {
    private UserDaoImplementation userDao;

    public UserService() {
        userDao = new UserDaoImplementation();
    }

    public void persist(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionWithTransaction();
    }

    public void update(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionWithTransaction();
    }

    public User findById(Integer id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Integer id) {
        userDao.openCurrentSessionWithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionWithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> user = userDao.findAll();
        userDao.closeCurrentSession();
        return user;
    }

    public void deleteAll() {
        userDao.openCurrentSessionWithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionWithTransaction();
    }

    public UserDao userDao() {
        return userDao;
    }
}
