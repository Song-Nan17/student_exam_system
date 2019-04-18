package service;

import dao.TeacherDao;
import model.Teacher;

import java.util.List;

public class TeacherService {
    public static boolean isExist(List<Teacher> teachers) {
        return teachers.size() > 0;
    }

    public static boolean isInsert(Teacher teacher) {
        TeacherDao teacherDao = new TeacherDao();
        return teacherDao.insertTeacher(teacher) == 1;
    }
}
