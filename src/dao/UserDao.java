package dao;

import model.Role;
import model.User;
import tools.Input;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public User getUser() {
        String[] infos = Input.getInput().split(":");
        User user = new User();
        String sql = "SELECT * FROM users WHERE user_name = \"" + infos[0] +
                "\" AND password = \"" + infos[1] + "\";";
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String userId = resultSet.getString("id");
                String roleId = resultSet.getString("role_id");
                Role role = RoleDao.getRole(roleId);
                user.setId(userId);
                user.setUserName(infos[0]);
                user.setPassword(infos[1]);
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
