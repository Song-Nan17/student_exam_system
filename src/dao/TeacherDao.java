package dao;

import model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public Teacher selectTeacherById(String id) {
        String sql = "SELECT * FROM teacher WHERE teacher_id = \"" + id + "\"";
        return Optional.ofNullable(selectTeacher(sql).get(0))
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    public List<Teacher> selectTeacherByName(String name) {
        String sql = "SELECT * FROM teacher WHERE name = \"" + name + "\"";
        return selectTeacher(sql);
    }

    public List<Teacher> selectTeacher(String sql) {
        List<Teacher> teachers = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("teacher_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                teachers.add(new Teacher(id, name, age, sex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
