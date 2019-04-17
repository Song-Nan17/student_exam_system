package tools;

public class Tools {
    public static void readChoice(String choice) {
        switch (choice.substring(0, 1)) {
            case "1":
                queryOperation(choice);
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
                QueryTools.queyTeacherByName();
                break;
        }
    }
}
