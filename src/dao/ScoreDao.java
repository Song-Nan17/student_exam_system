package dao;

import model.Score;
import model.Student;
import model.Subject;
import service.StudentService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class ScoreDao {
    final ConnectMySql connectMySql = new ConnectMySql();
    final Connection connection = connectMySql.getConnect();
    final Statement statement = connectMySql.getStatement(connection);

    public List<Score> selectScoreByStudentId(String studentId) {
        String sql = "SELECT * FROM score WHERE student_id = \"" + studentId + "\";";
        return selectScore(sql);
    }

    public List<Score> selectScoreBySubjectId(String subjectId) {
        String sql = "SELECT * FROM score WHERE subject_id = \"" + subjectId + "\";";
        return selectScore(sql);
    }

    public List<Score> selectScore(String sql) {
        List<Score> scores = new ArrayList<>();
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String subjectId = resultSet.getString("subject_id");
                double score = resultSet.getDouble("score");
                StudentDao studentDao = new StudentDao();
                Student student = studentDao.selectStudentById(studentId);
                    SubjectDao subjectDao = new SubjectDao();
                    Subject subject = subjectDao.selectSubjectById(subjectId);
                    scores.add(new Score(student, subject, score));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return scores;
    }

    public int insertScore(Score score) {
        String sql = "INSERT INTO score (student_id, subject_id, score) VALUES ";
        sql += "(\"" + score.getStudent().getId() + "\", \"" + score.getStudent().getId() + "\", \"" + score.getScore() + "\");";
        return connectMySql.updateSql(sql, statement, connection);
    }
}
