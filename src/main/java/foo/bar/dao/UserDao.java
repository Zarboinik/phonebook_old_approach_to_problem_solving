package foo.bar.dao;

import foo.bar.model.User;

import java.util.List;

public interface UserDao {
    public List<User> listUser();

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);

    public User getUserById(int id);
}
