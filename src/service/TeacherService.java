package service;

import model.Teacher;

import java.util.List;

public class TeacherService {
    public static boolean isExist(List<Teacher> teachers) {
        return teachers.size() > 0;
    }

    public static boolean isExist(Teacher teacher) {
        return teacher.getName() != null;
    }
}
