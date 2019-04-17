package dao;

import java.sql.Connection;
import java.sql.Statement;

public class Insert {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public void insert(String sql) {}
}
