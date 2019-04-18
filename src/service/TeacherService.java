package service;

import dao.TeacherDao;
import model.Teacher;

public class TeacherService {
    public static boolean isInsert(Teacher teacher) {
        TeacherDao teacherDao = new TeacherDao();
        return teacherDao.insertTeacher(teacher) == 1;
    }
}
