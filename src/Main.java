import input.Input;
import view.ClazzMenu;
import view.MainMenu;
import view.StudentMenu;
import view.UserAccountMenu;

public class Main {
    public static void main(String[] args) {
        UserAccountMenu userAccountMenu = new UserAccountMenu();
        userAccountMenu.displayMenu();
    }
}
