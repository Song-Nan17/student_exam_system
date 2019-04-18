package dao;

import model.Score;
import model.Subject;

import java.util.List;

public class SubjectScoreDao {
    public static List<Subject> selectBySubjectName(String name) {
        List<Subject> subjects = new SubjectDao().selectSubjectByName(name);
        subjects.forEach(subject -> setScores(subject));
        return subjects;
    }

    public static Subject selectBySubjectId(String id) {
        Subject subject = new SubjectDao().selectSubjectById(id);
        return setScores(subject);
    }

    public static List<Subject> selectByTeacherId(String id) {
        List<Subject> subjects = new SubjectDao().selectByTeacherId(id);
        subjects.forEach(subject -> setScores(subject));
        return subjects;
    }

    public static Subject setScores(Subject subject) {
        List<Score> scores = new ScoreDao().selectScoreBySubjectId(subject.getId());
        subject.setScores(scores);
        return subject;
    }
}
