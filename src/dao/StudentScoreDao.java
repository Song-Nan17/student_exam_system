package dao;

import model.Score;
import model.Student;

import java.util.List;

public class StudentScoreDao {
    public static List<Student> selectByStudentName(String name) {
        List<Student> students = new StudentDao().selectStudentByName(name);
        students.forEach(student -> setScores(student));
        return students;
    }

    public static Student selectByStudentId(String id) {
        Student student = new StudentDao().selectStudentById(id);
        return setScores(student);
    }

    public static Student setScores(Student student) {
        List<Score> scores = new ScoreDao().selectScoreByStudentId(student.getId());
        student.setScores(scores);
        return student;
    }
}
