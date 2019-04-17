import service.UserService;
import tools.Input;
import tools.Print;
import tools.Tools;

public class Main {
    public static void main(String[] args) {
        Print.printSignInHint();
        if (UserService.login(Input.formatSigninInput())) {
            while(true) {
                Print.printMenu();
                Tools.readChoice();
            }

        }
    }
}