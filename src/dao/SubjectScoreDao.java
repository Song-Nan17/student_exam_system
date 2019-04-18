package dao;

import model.Score;
import model.Subject;

import java.util.List;

public class SubjectScoreDao {
    public static List<Subject> selectBySubjectName(String name) {
        List<Subject> subjects = new SubjectDao().selectSubjectByName(name);
        subjects.forEach(subject -> {
            List<Score> scores = new ScoreDao().selectScoreBySubjectId(subject.getId());
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
