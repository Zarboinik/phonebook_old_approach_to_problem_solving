package foo.bar.service;

import foo.bar.dao.UserDao;
import foo.bar.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> listUser() {
        return this.userDao.listUser();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        this.userDao.deleteUser(id);
    }
}
