package service.query;

import dao.Select;
import model.Student;
import tools.Input;

import java.sql.SQLException;
import java.util.List;

public class QueryStudentInfo {
    public static void query(String choice) throws SQLException {
        switch (choice) {
            case "1.1.1":
                queryAllStudentInfo();
                break;
            case "1.1.2":
                querySpecifiedStudentInfo();
                break;
            case "1.1.3":
                QueryScore.queryByTeacher();
                break;
        }
    }

    public static void queryAllStudentInfo() throws SQLException {
        Select select = new Select();
        String sql = "SELECT * FROM student";
        List<Student> students = select.selectStudentsInfo(sql);
        students.forEach(student -> System.out.println(student.toString()));
    }

    public static void querySpecifiedStudentInfo() throws SQLException {
        System.out.println("请输入要查询的学生姓名:");
        String name = Input.getInput();
        Select select = new Select();
        String sql = "SELECT * FROM student where name = \"" + name + "\"";
        List<Student> students = select.selectStudentsInfo(sql);
        if (students.size() > 0) {
            students.forEach(student -> System.out.println(student.toString()));
            QueryScore.queryByStudent(name);
        }
    }
}
