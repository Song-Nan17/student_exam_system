package tools;

import model.Student;
import service.StudentService;

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
}
