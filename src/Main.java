import dao.UserDao;
import model.User;
import service.UserService;
import tools.Input;
import tools.Print;
import tools.Tools;

public class Main {
    public static void main(String[] args) {
        Print.printSignInHint();
        UserDao userDao = new UserDao();
        User user = userDao.getUser();
        if (UserService.isSuperAdmin(user)) {
            while (true) {
                Print.printMenu();
                String input = Input.getInput();
                if (UserService.logout(input)) {
                    break;
                }
                Tools.readChoice(input);
                Print.printSecondMenu();
                if (UserService.logout(Input.getInput())) {
                    break;
                }
            }
        }
    }
}