import service.Sign;
import tools.Print;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (Sign.signIn()) {
            Print.printMenu();
        }
    }
}
