package dao;

import model.Score;
import model.Subject;

import java.util.List;

public class SubjectScoreDao {
    public static List<Subject> selectBySubjectName(String name) {
        SubjectDao subjectDao = new SubjectDao();
        List<Subject> subjects = subjectDao.selectSubjectByName(name);
        subjects.forEach(subject -> {
            ScoreDao scoreDao = new ScoreDao();
            List<Score> scores = scoreDao.selectScoreBySubjectId(subject.getId());
            subject.setScores(scores);
        });
        return subjects;
    }
}
