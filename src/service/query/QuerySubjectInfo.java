package service.query;

import dao.Select;
import tools.Input;

import java.sql.SQLException;

public class QuerySubjectInfo {
    public static void query(String choice) throws SQLException {
        switch (choice) {
            case "1.2.1":
                queryAllSubjects();
                break;
            case "1.2.2":
                querySpecifiedSubject();
                break;
        }

    }

    public static void queryAllSubjects() throws SQLException {
        String sql = "SELECT s1.id, s1.subject, s2.name AS teacher FROM subject AS s1\n" +
                "LEFT JOIN teacher AS s2 ON s1.teacher = s2.id;";
        Select select = new Select();
        select.selectSubject(sql);
    }

    public static void querySpecifiedSubject() throws SQLException {
        System.out.println("请输入课程名：");
        String subject = Input.getInput();
        String sql = "SELECT s1.id, s1.subject, s2.name AS teacher FROM subject AS s1\n" +
                "LEFT JOIN teacher AS s2 ON s1.teacher = s2.id \n" +
                "WHERE subject = \"" + subject + "\";";
        Select select = new Select();
        select.selectSubject(sql);
    }
}
