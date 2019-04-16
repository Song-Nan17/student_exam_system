package service.query;

import dao.Select;

import java.sql.SQLException;

public class QueryTeacherInfo {
    public static void query(String choice) throws SQLException {
        switch (choice) {
            case "1.3.1":
                queryAllTeachers();
                break;
        }
    }

    public static void queryAllTeachers() throws SQLException {
        String sql = "SELECT * FROM teacher;";
        Select select = new Select();
        select.selectPerson(sql);
    }
}
