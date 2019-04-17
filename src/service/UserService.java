package service;

import dao.UserDao;
import model.User;

public class UserService {
    public static boolean login(String[] inputs) {
        User user = UserDao.getUser(inputs[0], inputs[1]);
        return user.getRole() != null && user.getRole().getRoleName().equals("超级管理员");
    }
}
