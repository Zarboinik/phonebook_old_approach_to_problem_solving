package foo.bar.service;

import foo.bar.model.User;

import java.util.List;

public interface UserService {
    public List<User> listUser();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer id);
}
