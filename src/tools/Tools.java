package tools;

public class Tools {
    public static void readChoice(String choice) {
        switch (choice.substring(0, 1)) {
            case "1":
                queryOperation(choice);
                break;
            case "2":
                insertOperation(choice);
            case "3":
                updateOperation(choice);
                break;
        }
    }

    public static void queryOperation(String choice) {
        switch (choice) {
            case "1.1.1":
                QueryTools.queryAllStudentsInfo();
                break;
            case "1.1.2":
                QueryTools.queryStudentScoreByName();
                break;
            case "1.1.3":
                QueryTools.queryStudentScoreByTeacherName();
                break;
            case "1.1.4":
                QueryTools.queryStudentScoreBySubjectName();
                break;
            case "1.2.1":
                QueryTools.queryAllSubjectInfo();
                break;
            case "1.2.2":
                QueryTools.querySubjectByItsName();
                break;
            case "1.2.3":
                QueryTools.querySubjectByTeacherName();
                break;
            case "1.3.1":
                QueryTools.queryAllTeacher();
                break;
            case "1.3.2":
                QueryTools.queryTeacherByName();
                break;
        }
    }

    public static void insertOperation(String choice) {
        switch (choice) {
            case "2.1":
                InsertTools.insertStudent();
                break;
            case "2.2":
                InsertTools.insertSubject();
                break;
            case "2.3":
                InsertTools.insertTeacher();
                break;
            case "2.4":
                InsertTools.insertScore();
                break;
        }
    }

    public static void updateOperation(String choice) {
        switch (choice) {
            case "3.1":
                UpdateTools.updateStudentById();
                break;
        }
    }
}
