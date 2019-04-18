package tools;

import dao.*;
import model.Student;
import model.Subject;
import model.Teacher;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;

import java.util.List;

public class QueryTools {

    public static void queryAllStudentsInfo() {
        List<Student> students = new StudentDao().selectAllStudent();
        students.forEach(student -> System.out.println(student.toString()));
    }

    public static void queryStudentScoreByName() {
        System.out.println("请输入要查询的学生姓名");
        String name = Input.getInput();
        List<Student> students = StudentScoreDao.selectByStudentName(name);
        if (StudentService.isExist(students)) {
            students.forEach(student -> {
                System.out.println(student.toString());
                System.out.println("学生" + student.getName() + "的成绩如下：");
                student.getScores().forEach(score ->
                        System.out.println("科目：" + score.getSubject().getName() + ", 成绩：" + score.getScore()));
            });
        } else {
            System.out.println("学生" + name + "不存在");
        }
    }

    public static void queryStudentScoreByTeacherName() {
        System.out.println("请输入老师姓名：");
        String name = Input.getInput();
        List<Teacher> teachers = TeacherSubjectDao.selectByTeacherName(name);
        if (TeacherService.isExist(teachers)) {
            System.out.println("老师" + name + "的所有学生信息及其成绩如下：");
            teachers.forEach(teacher -> teacher.getSubjects()
                    .forEach(subject -> subject.getScores()
                            .forEach(score -> System.out.println(score.getStudent() +
                                    ", 课程" + score.getSubject().getName() +
                                    ", 成绩：" + score.getScore())
                            )));
        } else {
            System.out.println("老师" + name + "不存在");
        }
    }

    public static void queryStudentScoreBySubjectName() {
        System.out.println("请输入课程名称：");
        String name = Input.getInput();
        List<Subject> subjects = SubjectScoreDao.selectBySubjectName(name);
        if (SubjectService.isExist(subjects)) {
            System.out.println(name + "课程的所有学生信息及其成绩为：");
            subjects.forEach(subject ->
                    subject.getScores().forEach(score ->
                            System.out.println(score.getStudent() + ", 成绩：" + score.getScore())
                    ));
        } else {
            System.out.println("课程" + name + "不存在");
        }
    }

    public static void queryAllSubjectInfo() {
        List<Subject> subjects = new SubjectDao().selectAllSubject();
        subjects.forEach(subject -> System.out.println(subject));
    }

    public static void querySubjectByItsName() {
        System.out.println("请输入课程名：");
        String name = Input.getInput();
        List<Subject> subjects = new SubjectDao().selectSubjectByName(name);
        subjects.forEach(subject -> System.out.println(subject));
    }

    public static void querySubjectByTeacherName() {
        System.out.println("请输入老师姓名：");
        String name = Input.getInput();
        List<Teacher> teachers = TeacherSubjectDao.selectByTeacherName(name);
        if (TeacherService.isExist(teachers)) {
            teachers.forEach(teacher -> teacher.getSubjects()
                    .forEach(subject -> System.out.println(subject)));
        } else {
            System.out.println("老师" + name + "不存在");
        }
    }

    public static void queryAllTeacher() {
        List<Teacher> teachers = new TeacherDao().selectAllTeacher();
        teachers.forEach(teacher -> System.out.println(teacher));
    }

    public static void queryTeacherByName() {
        System.out.println("请输入老师姓名：");
        String name = Input.getInput();
        List<Teacher> teachers = new TeacherDao().selectTeacherByName(name);
        if (TeacherService.isExist(teachers)) {
            teachers.forEach(teacher -> System.out.println(teacher));
        } else {
            System.out.println("老师+" + name + "+不存在");
        }
    }
}
