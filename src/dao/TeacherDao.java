package dao;

import model.Teacher;
import service.TeacherService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public List<Teacher> selectAllTeacher() {
        String sql = "SELECT * FROM teacher";
        return selectTeacher(sql);
    }

    public Teacher selectTeacherById(String id) {
        Teacher teacher = new Teacher();
        String sql = "SELECT * FROM teacher WHERE teacher_id = \"" + id + "\"";
        List<Teacher> teachers = selectTeacher(sql);
        if (TeacherService.isExist(teachers)) {
            teacher = teachers.get(0);
        }
        return teacher;
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
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return teachers;
    }

    public int insertTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher (teacher_id, name, age, sex) VALUES ";
        sql += "(\"" + teacher.getId() + "\",\"" + teacher.getName() + "\"," + teacher.getAge() + ",\"" + teacher.getSex() + "\");";
        return connectMySql.updateSql(sql, statement, connection);
    }

    public int update(Teacher teacher) {
        String sql = "UPDATE teacher SET teacher_id = \"" + teacher.getId()
                + "\", name = \"" + teacher.getName() +
                "\", age = " + teacher.getAge() +
                ", sex = \"" + teacher.getSex() +
                "\" WHERE teacher_id = \"" + teacher.getId() + "\";";
        return connectMySql.updateSql(sql, statement, connection);
    }
}
