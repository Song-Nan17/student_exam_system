package service;

import dao.Select;
import model.Account;
import tools.Input;
import tools.Print;

import java.sql.SQLException;

public class Sign {
    public static boolean signIn() throws SQLException {
        Print.printSignInHint();
        String[] inputs = Input.getInput().split(":");
        Account inputAccount = new Account(inputs[0], inputs[1]);
        Account root = Select.selectAdministrator("SELECT * FROM administrator");
        return inputAccount.equals(root);
    }
}
