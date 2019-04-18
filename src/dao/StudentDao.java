package dao;

import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public List<Student> selectAllStudent() {
        String sql = "SELECT * FROM student";
        List<Student> students = selectStudents(sql);
        return students;
    }

    public List<Student> selectStudentByName(String name) {
        String sql = "SELECT * FROM student WHERE name = \"" + name + "\";";
        return selectStudents(sql);
    }

    public Student selectStudentById(String id) {
        String sql = "SELECT * FROM student WHERE student_id = \"" + id + "\";";
        return Optional.ofNullable(selectStudents(sql).get(0))
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    public List<Student> selectStudents(String sql) {
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
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return students;
    }

    public int insertStudent(Student student) {
        String sql = "INSERT INTO student (student_id, name, age, sex) VALUES ";
        sql += "(\"" + student.getId() + "\",\"" + student.getName() + "\"," + student.getAge() + ",\"" + student.getSex() + "\");";
        return connectMySql.updateSql(sql, statement, connection);
    }
}
