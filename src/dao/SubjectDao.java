package dao;

import model.Subject;
import model.Teacher;
import service.SubjectService;

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
        Subject subject = new Subject();
        String sql = "SELECT * FROM subject WHERE id = \"" + id + "\";";
        List<Subject> subjects = selectSubject(sql);
        if (SubjectService.isExist(subjects)) {
            subject = subjects.get(0);
        }
        return subject;
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

    public int insertSubject(Subject subject) {
        String sql = "INSERT INTO subject (id, name, teacher_id) VALUES ";
        sql += "(\"" + subject.getId() + "\", \"" + subject.getName() + "\", \"" + subject.getTeacher().getId() + "\");";
        return connectMySql.updateSql(sql, statement, connection);
    }

    public int update(Subject subject) {
        String sql = "UPDATE subject SET id = \"" + subject.getId() +
                "\", name = \"" + subject.getName() +
                "\", teacher_id = \"" + subject.getTeacher().getId() +
                "\" WHERE id = \"" + subject.getId() + "\";";
        return connectMySql.updateSql(sql, statement, connection);
    }
}
