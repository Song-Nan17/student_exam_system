package dao;

import model.Score;
import model.Subject;

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
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT * FROM score WHERE student_id = \"" + studentId + "\";";
        ResultSet resultSet = connectMySql.executeSQL(statement, sql);
        try {
            while (resultSet.next()) {
                String subjectId = resultSet.getString("subject_id");
                SubjectDao subjectDao = new SubjectDao();
                Subject subject = subjectDao.subjectSubjectById(subjectId);
                double score = resultSet.getDouble("score");
                scores.add(new Score(subject,score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectMySql.closeConnect(resultSet, statement, connection);
        }
        return scores;
    }
}
