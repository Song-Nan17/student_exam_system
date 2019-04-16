import service.query.Query;
import service.Sign;
import tools.Input;
import tools.Print;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (Sign.signIn()) {
            Print.printMenu();
            String choice = Input.getInput();
            switch (choice.substring(0, 1)) {
                case "1":
                    Query.query(choice);
                    break;
                case "5":
                    break;
            }
        }
    }
}
