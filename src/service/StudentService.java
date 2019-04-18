package service;

import model.Student;

import java.util.List;

public class StudentService {
    public static boolean isExist(List<Student> students) {
        return students.size() > 0;
    }

    public static boolean isExist(Student student) {
        return student.getName() != null;
    }
}
