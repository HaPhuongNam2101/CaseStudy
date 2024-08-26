package view;

import input.Input;

public class MainMenu {
    ClazzMenu clazzMenu = new ClazzMenu();
    StudentMenu studentMenu = new StudentMenu();

    public void showMainMenu(){
        int choice;
        do {
            System.out.println("===== Menu chính =====");
            System.out.println("1. Quản lý lớp");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    clazzMenu.showClazzMenu();
                    break;
                case 2:
                    studentMenu.showStudentMenu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 0);
    }
}
