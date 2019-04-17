package dao;

import model.Role;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public static User getUser(String userName, String password) {
        ConnectMySql connectMySql = new ConnectMySql();
        Connection connection = connectMySql.getConnect();
        Statement statement = connectMySql.getStatement(connection);

        User user = new User();
        String sql = "SELECT * FROM users WHERE user_name = \"" + userName +
                "\" AND password = \"" + password + "\";";
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String userId = resultSet.getString("id");
                String roleId = resultSet.getString("role_id");
                Role role = RoleDao.getRole(roleId);
                user.setId(userId);
                user.setUserName(userName);
                user.setPassword(password);
                user.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return user;
    }
}
