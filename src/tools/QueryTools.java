package tools;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class QueryTools {

    public static void queryAllStudentsInfo() {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.selectAllStudentInfo();
        students.forEach(student -> System.out.println(student.toString()));
    }

    public static void queryStudentAndScoreByName() {
        System.out.println("请输入要查询的学生姓名");
        String name = Input.getInput();
    }
}
