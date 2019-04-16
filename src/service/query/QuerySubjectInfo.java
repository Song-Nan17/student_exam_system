package service.query;

import dao.Select;

import java.sql.SQLException;

public class QuerySubjectInfo {
    public static void query(String choice) throws SQLException {
        switch (choice) {
            case "1.2.1":
                queryAllSubjects();
                break;
        }

    }

    public static void queryAllSubjects() throws SQLException {
        String sql = "SELECT * FROM subject";
        Select select = new Select();
        select.selectSubject(sql);
    }
}
