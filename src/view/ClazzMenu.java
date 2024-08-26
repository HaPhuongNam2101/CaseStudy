package view;

import input.Input;
import manager.ClazzManager;
import model.Clazz;

import java.util.List;

public class ClazzMenu {
    private ClazzManager clazzManager = new ClazzManager();

    public void showClazzMenu(){
        int choice;
        do {
            System.out.println("===== Quản lý lớp =====");
            System.out.println("1. Thêm mới lớp ");
            System.out.println("2. Sửa thông tin  lớp ");
            System.out.println("3. Xóa lớp ");
            System.out.println("4. Hiển thị danh sách lớp");
            System.out.println("0. Thoát chương trình ");
            System.out.println("Vui lòng nhập lựa chọn ");
            choice = Input.inputnumber();
            switch (choice){
                case 1:
                    showAddClazzMenu();
                    break;
                case 2:
                    showEditClazzMenu();
                    break;
                case 3:
                    showDeleteClazzMenu();
                    break;
                case 4:
                    showAllClazzMenu();
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn! ");
            }
        } while(choice != 0);
    }
    private void showAddClazzMenu(){
        System.out.println("===== Thêm mới lớp =====");
        System.out.print("Nhập tên: ");
        String name = Input.inputstring();
        System.out.print("Nhập khối: ");
        String unit = Input.inputstring();
        Clazz clazz = new Clazz(name, unit);
        clazzManager.add(clazz);
        System.out.println("Thêm thành công ");
    }
    public void showAllClazzMenu() {
        System.out.println("===== Danh sách lớp =====");
        List<Clazz> classList = clazzManager.getAll();
        for (Clazz clazz : classList) {
            System.out.println(clazz);
        }
    }
    public void showEditClazzMenu() {
        System.out.println("===== Sửa thông tin lớp ===== ");
        System.out.print("Nhập id muốn sửa: ");
        int idEdit = Input.inputnumber();
        System.out.print("Nhập tên: ");
        String name = Input.inputstring();
        System.out.print("Nhập khối: ");
        String unit = Input.inputstring();
        Clazz clazz = new Clazz(idEdit,name, unit);
        clazzManager.update(idEdit, clazz);
        System.out.println("Sửa thành công ");
    }
    public void showDeleteClazzMenu() {
        System.out.println("===== Xóa lớp =====");
        System.out.print("Nhập mã lớp muốn xóa: ");
        int idDelete = Input.inputnumber();
        int index = clazzManager.findIndexById(idDelete);
        if (index != -1) {
            clazzManager.delete(idDelete);
            System.out.println("Xóa lớp thành công ");
        } else {
            System.out.println("Không tìm thấy mã lớp! ");
        }
    }
}
