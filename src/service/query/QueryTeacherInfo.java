package service.query;

import dao.Select;
import tools.Input;

import java.sql.SQLException;

public class QueryTeacherInfo {
    public static void query(String choice) throws SQLException {
        switch (choice) {
            case "1.3.1":
                queryAllTeachers();
                break;
            case "1.3.2":
                querySpecifiedTeacher();
                break;
        }
    }

    public static void queryAllTeachers() throws SQLException {
        String sql = "SELECT * FROM teacher;";
        Select select = new Select();
        select.selectPerson(sql);
    }

    public static void querySpecifiedTeacher() throws SQLException {
        System.out.println("请输入要查询的教师姓名：");
        String teacher = Input.getInput();
        String sql = "SELECT * FROM teacher WHERE name = \"" + teacher + "\";";
        Select select = new Select();
        select.selectPerson(sql);
    }
}
