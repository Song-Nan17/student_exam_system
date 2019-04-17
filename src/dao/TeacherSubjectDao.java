package dao;

import model.Subject;
import model.Teacher;

import java.util.List;

public class TeacherSubjectDao {
    public static List<Teacher> selectByTeacherName(String name) {
        TeacherDao teacherDao = new TeacherDao();
        List<Teacher> teachers = teacherDao.selectTeacherByName(name);
        teachers.forEach(teacher -> {
            SubjectDao subjectDao = new SubjectDao();
            List<Subject> subjects = subjectDao.selectByTeacherId(teacher.getId());
            subjects.forEach(subject -> {
                ScoreDao scoreDao = new ScoreDao();
                subject.setScores(scoreDao.selectScoreBySubjectId(subject.getId()));
            });
            teacher.setSubjects(subjects);
        });
        return teachers;
    }
}
