package tools;

import dao.*;
import model.Student;
import model.Subject;
import model.Teacher;

import java.util.List;

public class QueryTools {

    public static void queryAllStudentsInfo() {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.selectAllStudent();
        students.forEach(student -> System.out.println(student.toString()));
    }

    public static void queryStudentScoreByName() {
        System.out.println("请输入要查询的学生姓名");
        String name = Input.getInput();
        List<Student> students = StudentScoreDao.selectByStudentName(name);
        students.forEach(student -> {
            System.out.println(student.toString());
            System.out.println("学生" + student.getName() + "的成绩如下：");
            student.getScores().forEach(score ->
                    System.out.println("科目：" + score.getSubject().getName() + ", 成绩：" + score.getScore()));
        });
    }

    public static void queryStudentScoreByTeacherName() {
        System.out.println("请输入老师姓名：");
        String name = Input.getInput();
        List<Teacher> teachers = TeacherSubjectDao.selectByTeacherName(name);
        System.out.println("的所有学生信息及其成绩如下：");
        teachers.forEach(teacher ->
                teacher.getSubjects().forEach(subject ->
                        subject.getScores().forEach(score ->
                                System.out.println(score.getStudent() + ", 成绩：" + score.getScore())
                        )));
    }

    public static void queryStudentScoreBySubjectName() {
        System.out.println("请输入课程名称：");
        String name = Input.getInput();
        System.out.println(name + "课程的所有学生信息及其成绩为：");
        List<Subject> subjects = SubjectScoreDao.selectBySubjectName(name);
        subjects.forEach(subject ->
                subject.getScores().forEach(score ->
                        System.out.println(score.getStudent() + ", 成绩：" + score.getScore())
                ));
    }

    public static void queryAllSubjectInfo() {
        SubjectDao subjectDao = new SubjectDao();
        List<Subject> subjects = subjectDao.selectAllSubject();
        subjects.forEach(subject -> System.out.println(subject));
    }

    public static void querySubjectByItsName() {
        System.out.println("请输入课程名：");
        String name = Input.getInput();
        SubjectDao subjectDao = new SubjectDao();
        List<Subject> subjects = subjectDao.selectSubjectByName(name);
        subjects.forEach(subject -> System.out.println(subject));
    }
}
