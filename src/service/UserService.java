package service;


import model.User;

public class UserService {
    public static boolean isSuperAdmin(User user) {
        return isExist(user) && user.getRole().getRoleName().equals("超级管理员");
    }

    public static boolean isExist(User user) {
        return user.getRole() != null;
    }

    public static boolean logout(String input) {
        return input.equals("0");
    }
}
