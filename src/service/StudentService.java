package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {
    public static boolean isExist(List<Student> students) {
        return students.size() > 0;
    }

    public static boolean isExist(Student student) {
        return student.getName() != null;
    }

    public static boolean isInsert(Student student) {
        StudentDao studentDao = new StudentDao();
        return studentDao.insertStudent(student) == 1;
    }

    public static boolean isUpdate(Student student) {
        StudentDao studentDao = new StudentDao();
        return studentDao.update(student) == 1;
    }
}
