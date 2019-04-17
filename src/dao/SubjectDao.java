package dao;

import model.Subject;
import model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public List<Subject> selectAllSubject() {
        String sql = "SELECT * FROM subject;";
        return selectSubject(sql);
    }

    public Subject selectSubjectById(String id) {
        String sql = "SELECT * FROM subject WHERE id = \"" + id + "\";";
        return Optional.ofNullable(selectSubject(sql).get(0))
                .orElseThrow(IndexOutOfBoundsException::new);
    }


    public List<Subject> selectSubjectByName(String name) {
        String sql = "SELECT * FROM subject WHERE name = \"" + name + "\";";
        return selectSubject(sql);
    }

    public List<Subject> selectByTeacherId(String teacherId) {
        String sql = "SELECT * FROM subject WHERE teacher_id = \"" + teacherId + "\";";
        return selectSubject(sql);
    }

    public List<Subject> selectSubject(String sql) {
        List<Subject> subjects = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String teacherId = resultSet.getString("teacher_id");
                TeacherDao teacherDao = new TeacherDao();
                Teacher teacher = teacherDao.selectTeacherById(teacherId);
                subjects.add(new Subject(id, name, teacher));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return subjects;
    }
}
