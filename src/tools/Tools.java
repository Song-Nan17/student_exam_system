package tools;

public class Tools {
    public static void readChoice() {
        String choice = Input.getInput();
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

        }
    }
}