package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {
    public static boolean isExist(List<Student> students) {
        return students.size() > 0;
    }

    public static boolean isInsert(Student student) {
        StudentDao studentDao = new StudentDao();
        return studentDao.insertStudent(student) == 1;
    }
}
