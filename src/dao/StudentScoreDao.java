package dao;

import model.Score;
import model.Student;

import java.util.List;

public class StudentScoreDao {
    public static List<Student> selectByStudentName(String name) {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.selectStudentByName(name);
        System.out.println(students.size());
        students.forEach(student -> {
            ScoreDao scoreDao = new ScoreDao();
            List<Score> scores = scoreDao.selectScoreByStudentId(student.getId());
            student.setScores(scores);
        });
        return students;
    }
}
