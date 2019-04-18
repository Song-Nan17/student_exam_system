package service;

import dao.StudentDao;
import model.Student;

public class StudentService {
    public static boolean isInsert(Student student) {
        StudentDao studentDao = new StudentDao();
        return studentDao.insertStudent(student) == 1;
    }
}
