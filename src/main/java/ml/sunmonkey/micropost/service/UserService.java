package ml.sunmonkey.micropost.service;

import ml.sunmonkey.micropost.common.ServiceResultEnum;
import ml.sunmonkey.micropost.dao.UserDao;
import ml.sunmonkey.micropost.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public String addUser(User user) {
        User tmp = userDao.findUserByEmail(user.getEmail());
        if (user == null || tmp != null)
            return ServiceResultEnum.EMAIL_EXIST.name();

        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        newUser.setAvatar("");

        userDao.save(newUser);
        return ServiceResultEnum.SUCCESS_MESSAGE.name();
    }

    public String login(String email, String password) {
        System.out.println("1");
        User tmp = userDao.findUserByEmail(email);
        if (tmp == null) {
            return ServiceResultEnum.USER_NULL.name();
        }
        System.out.println("2");
        if (tmp.getEmail().equals(email) && tmp.getPassword().equals(password)) {
            return ServiceResultEnum.SUCCESS_MESSAGE.name();
        }
        System.out.println("3");
        return ServiceResultEnum.EMAIL_OR_PASSWORD_ERROR.name();
    }

    public String logout(Long id) {
        User user = userDao.findUserById(id);
        if (user == null) {
            return ServiceResultEnum.USER_NULL.name();
        }
        int i = userDao.removeUserById(id);
        if (i != 0) {
            return ServiceResultEnum.SUCCESS_MESSAGE.name();
        }
        return ServiceResultEnum.ERROR_MESSAGE.name();
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        Iterable<User> IUser = userDao.findAll();
        for (User user : IUser) {
            users.add(user);
        }
        return users;
    }
}
