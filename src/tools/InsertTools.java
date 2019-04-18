package tools;

import model.Score;
import model.Student;
import model.Subject;
import model.Teacher;
import service.ScoreService;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;

public class InsertTools {
    public static void insertStudent() {
        System.out.println("请输入学生信息(例如：学号：1001，姓名： 小明，年龄： 18，性别： 男)：");
        Student student = Input.generateStudentByInput();
        if (StudentService.isInsert(student)) {
            System.out.println("添加学生[" + student.getName() + student.getId() + "]成功！");
        } else {
            System.out.println("添加学生失败！");
        }
    }

    public static void insertSubject() {
        System.out.println("请输入课程信息(例如：课程编号：3，课程名：英语，授课老师编号：4)：");
        Subject subject = Input.generateSubjectByInput();
        if (SubjectService.isInsert(subject)) {
            System.out.println("添加课程[" + subject.getName() + subject.getId() + "]成功！");
        } else {
            System.out.println("添加学生失败！");
        }
    }

    public static void insertTeacher() {
        System.out.println("请输入老师信息(例如：老师编号：5，姓名：强哥，年龄：33，性别：男)：");
        Teacher teacher = Input.generateTeacherByInput();
        if (TeacherService.isInsert(teacher)) {
            System.out.println("添加老师[" + teacher.getName() + teacher.getId() + "]成功！");
        } else {
            System.out.println("添加学生失败！");
        }
    }

    public static void insertScore() {
        System.out.println("请输入学生成绩信息(例如：学号：1，课程编号：3，成绩：88)：");
        Score score = Input.generateScoreByByInput();
        if (ScoreService.isInsert(score)) {
            System.out.println("学生[学号：" + score.getStudent().getId() + "]的学生的成绩添加成功！");
        } else {
            System.out.println("添加成绩失败！");
        }
    }
}
