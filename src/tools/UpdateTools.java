package tools;

import dao.StudentDao;
import model.Student;
import service.StudentService;

public class UpdateTools {
    public static void updateStudentById() {
        System.out.println("请输入要修改的学生学号：");
        String id = Input.getInput();
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.selectStudentById(id);
        if (StudentService.isExist(student)) {
            System.out.println("该生信息为：" + student);
            System.out.println("请输入修改后的学生信息(例如：学号：1001，姓名： 小明，年龄： 18，性别： 男)：");
            Student newStudent = Input.generateStudentByInput();
            if (StudentService.isUpdate(newStudent)) {
                System.out.println("学生[" + student.getName() + student.getId() + "]的信息修改成功！");
            } else {
                System.out.println("学生信息修改失败！");
            }
        } else {
            System.out.println("学生[学号：" + id + "]");
        }
    }
}
