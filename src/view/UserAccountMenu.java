package view;

import Login.UserAccount;
import input.Input;
import manager.UserAccountManager;
import validate.RegexUser;

public class UserAccountMenu {
    private UserAccountManager userManager = new UserAccountManager();
    private UserAccount loggedInUser;

    public void displayMenu() {
        int choice;
        do {
            System.out.println("===== Trang chủ =====");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Xóa tài khoản");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 0:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 0);
    }
    private void register() {
        System.out.println("===== Đăng Ký =====");
        String username = RegexUser.validateUsername();
        String password = RegexUser.validatePassword();
        UserAccount user = new UserAccount(username, password);
        userManager.registerUser(user);
    }
    private void login() {
        System.out.println("===== Đăng Nhập =====");
        String username = RegexUser.validateUsername();
        String password = RegexUser.validatePassword();
        loggedInUser = userManager.loginUser(username, password);
        if (loggedInUser != null) {
            navigateToMainMenu();
        } else {
            System.out.println("Đăng nhập không thành công. Vui lòng thử lại.");
        }
    }
    private void deleteUser() {
        if (loggedInUser != null) {
            userManager.deleteUser(loggedInUser.getUsername());
            loggedInUser = null;
        } else {
            System.out.println("Bạn chưa đăng nhập!");
        }
    }

    public boolean isUserLoggedIn() {
        return loggedInUser != null;
    }
    private void navigateToMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMainMenu();
    }
}
