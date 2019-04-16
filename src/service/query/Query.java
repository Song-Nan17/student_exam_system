package service.query;

import java.sql.SQLException;

public class Query {
    public static void query(String choice) throws SQLException {
        switch (choice.substring(0, 3)) {
            case "1.1":
                QueryStudentInfo.query(choice);
                break;
            case "1.2":
                QuerySubjectInfo.query(choice);
                break;
        }
    }
}
