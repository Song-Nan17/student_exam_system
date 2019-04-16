package dao;

import model.Account;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Select {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public Account selectAdministrator(String sql) throws SQLException {
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

    public List<Student> selectAllStudentsInfo() throws SQLException {
        List<Student> students = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, "SELECT * FROM student");
        while (resultSet.next()) {
            String id = resultSet.getString("stu_id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            students.add(new Student(id, name, age, sex));
        }
        connectMySql.closeConnect(resultSet, statement, connection);
        return students;
    }
}
