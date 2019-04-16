package service.query;

import dao.Select;
import tools.Input;

import java.sql.SQLException;

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
            case "1.1.4":
                QueryScore.queryBySubject();
                break;
        }
    }

    public static void queryAllStudentInfo() throws SQLException {
        Select select = new Select();
        String sql = "SELECT * FROM student";
        select.selectPerson(sql);
    }

    public static void querySpecifiedStudentInfo() throws SQLException {
        System.out.println("请输入要查询的学生姓名:");
        String name = Input.getInput();
        Select select = new Select();
        String sql = "SELECT * FROM student where name = \"" + name + "\"";
        select.selectPerson(sql);
        QueryScore.queryByStudent(name);
    }
}
