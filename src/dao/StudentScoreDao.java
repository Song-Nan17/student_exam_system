package dao;

import model.Score;
import model.Student;

import java.util.List;

public class StudentScoreDao {
    public static List<Student> selectByStudentName(String name) {
        List<Student> students = new StudentDao().selectStudentByName(name);
        students.forEach(student -> {
            List<Score> scores = new ScoreDao().selectScoreByStudentId(student.getId());
            student.setScores(scores);
        });
        return students;
    }

    public static Student selectByStudentId(String id) {
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.selectStudentById(id);
        ScoreDao scoreDao = new ScoreDao();
        List<Score> scores = scoreDao.selectScoreByStudentId(student.getId());
        student.setScores(scores);
        return student;
    }
}
