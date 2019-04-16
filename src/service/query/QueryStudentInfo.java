package service.query;

import dao.Select;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public class QueryStudentInfo {
    public static void query(String choice) throws SQLException {
        switch (choice) {
            case "1.1.1":
                queryAllStudentInfo();
                break;
        }
    }

    public static void queryAllStudentInfo() throws SQLException {
        Select select = new Select();
        List<Student> students = select.selectAllStudentsInfo();
        students.forEach(student -> System.out.println(student.toString()));
    }
}
