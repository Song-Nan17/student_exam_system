package dao;

import model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    public static Account selectAdministrator(String sql) throws SQLException {
        ConnectMySql connectMySql = new ConnectMySql();
        Connection connection = connectMySql.getConnect();
        Statement statement = connectMySql.getStatement(connection);
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        String id = "";
        String password = "";
        while (resultSet.next()) {
            id = resultSet.getString("id");
            password = resultSet.getString("password");
        }
        connectMySql.closeConnect(resultSet, statement, connection);
        return new Account(id, password);
    }
}
