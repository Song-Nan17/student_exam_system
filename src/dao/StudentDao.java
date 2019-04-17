package dao;

import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public List<Student> selectAllStudentInfo() {
        String sql = "SELECT * FROM student";
        return selectStudentsInfo(sql);
    }

    public List<Student> selectStudentInfoByName(String name) {
        String sql = "SELECT * FROM student WHERE name = \"" + name + "\";";
        return selectStudentsInfo(sql);
    }

    public List<Student> selectStudentsInfo(String sql) {
        List<Student> students = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                students.add(new Student(id, name, age, sex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


}
