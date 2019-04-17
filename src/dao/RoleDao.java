package dao;

import model.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleDao {
    public static Role getRole(String roleId) {
        Role role = new Role();
        ConnectMySql connectMySql = new ConnectMySql();
        Connection connection = connectMySql.getConnect();
        Statement statement = connectMySql.getStatement(connection);
        String sql = "SELECT * FROM role WHERE id = \"" + roleId + "\";";
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String roleName = resultSet.getString("role_name");
                role.setRoleId(roleId);
                role.setRoleName(roleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return role;
    }
}
