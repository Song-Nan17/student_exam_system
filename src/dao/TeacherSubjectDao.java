package dao;

import model.Subject;
import model.Teacher;

import java.util.List;

public class TeacherSubjectDao {
    public static List<Teacher> selectByTeacherName(String name) {
        List<Teacher> teachers = new TeacherDao().selectTeacherByName(name);
        teachers.forEach(teacher -> setSubejcts(teacher));
        return teachers;
    }

    public static Teacher selectByTeacherId(String id) {
        Teacher teacher = new TeacherDao().selectTeacherById(id);
        return setSubejcts(teacher);
    }

    public static Teacher setSubejcts(Teacher teacher) {
        List<Subject> subjects = SubjectScoreDao.selectByTeacherId(teacher.getId());
        teacher.setSubjects(subjects);
        return teacher;
    }
}
