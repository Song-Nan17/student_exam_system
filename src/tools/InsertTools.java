package tools;

import model.Student;
import model.Subject;
import service.StudentService;
import service.SubjectService;

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
}
