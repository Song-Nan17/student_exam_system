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

    public static Subject selectBySubjectId(String id) {
        Subject subject = new SubjectDao().selectSubjectById(id);
        List<Score> scores = new ScoreDao().selectScoreBySubjectId(id);
        subject.setScores(scores);
        return subject;
    }
}
