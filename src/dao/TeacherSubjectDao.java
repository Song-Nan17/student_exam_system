package dao;

import model.Score;
import model.Subject;
import model.Teacher;

import java.util.List;

public class TeacherSubjectDao {
    public static List<Teacher> selectByTeacherName(String name) {
        List<Teacher> teachers = new TeacherDao().selectTeacherByName(name);
        teachers.forEach(teacher -> {
            List<Subject> subjects = new SubjectDao().selectByTeacherId(teacher.getId());
            subjects.forEach(subject -> {
                List<Score> scores = new ScoreDao().selectScoreBySubjectId(subject.getId());
                subject.setScores(scores);
            });
            teacher.setSubjects(subjects);
        });
        return teachers;
    }
}
