package view;

import input.Input;
import manager.ClazzManager;
import manager.StudentManager;
import model.Clazz;
import model.Student;
import validate.RegexName;

import java.util.List;

public class StudentMenu {
    private StudentManager studentManager = new StudentManager();
    private ClazzManager clazzManager = new ClazzManager();

    public void showStudentMenu() {
        int choice;
        do {
            System.out.println("===== Quản lý sinh viên =====");
            System.out.println("1. Thêm mới sinh viên ");
            System.out.println("2. Sửa thông tin sinh viên ");
            System.out.println("3. Xóa sinh viên ");
            System.out.println("4. Hiển thị danh sách sinh viên ");
            System.out.println("5. Tìm kiếm theo khoảng điểm");
            System.out.println("6. Tìm kiếm theo hạnh kiểm");
            System.out.println("7. Tìm kiếm theo lớp");
            System.out.println("8. Tìm sinh viên có điểm cao nhất");
            System.out.println("9. Sắp xếp danh sách sinh viên");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    showAddStudentMenu();
                    break;
                case 2:
                    showEditStudentMenu();
                    break;
                case 3:
                    showDeleteStudentMenu();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    showSearchByScoreMenu();
                    break;
                case 6:
                    showSearchByConductMenu();
                    break;
                case 7:
                    showSearchByClazzMenu();
                    break;
                case 8:
                    showSearchTopStudentMenu();
                    break;
                case 9:
                    showSortStudentsMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn! ");
            }
        } while (choice != 0);
    }
    public void showAddStudentMenu() {
        System.out.println("===== Thêm mới sinh viên ===== ");
        String name = RegexName.validateName();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = Input.inputnumber();
        System.out.print("Nhập giới tính sinh viên: ");
        String gender = Input.inputstring();
        System.out.print("Nhập điểm sinh viên ");
        double score = Input.inputnumber();
        System.out.print("Nhập hạnh kiểm sinh viên: ");
        String conduct = Input.inputstring();
        System.out.print("Nhập mã lớp: ");
        int clazzId = Input.inputnumber();
        Student student = new Student(name, age, gender, score, conduct,clazzId);
        studentManager.add(student);
        System.out.println("Thêm sinh viên thành công ");
    }
    public void showEditStudentMenu() {
        System.out.println("===== Sửa thông tin sinh viên =====");
        System.out.print("Nhập mã sinh viên muốn sửa: ");
        int idEdit = Input.inputnumber();
        int index = studentManager.findIndexById(idEdit);
        if (index == -1) {
            System.out.println("Sinh viên không tồn tại! ");
            return;
        }
        String name = RegexName.validateName();
        System.out.print("Nhập tuổi mới: ");
        int age = Input.inputnumber();
        System.out.print("Nhập giới tính mới: ");
        String gender = Input.inputstring();
        System.out.print("Nhập điểm mới: ");
        double score = Input.inputnumber();
        System.out.print("Nhập hạnh kiểm mới: ");
        String conduct = Input.inputstring();
        System.out.print("Nhập mã lớp mới: ");
        int clazzId = Input.inputnumber();
        Student student = new Student(name, age, gender, score, conduct,clazzId);
        studentManager.update(idEdit, student);
        System.out.println("Sửa thành công ");
    }
    public void showDeleteStudentMenu() {
        System.out.println("===== Xóa sinh viên =====");
        System.out.print("Nhập mã sinh viên muốn xóa: ");
        int idDelete = Input.inputnumber();
        int index = studentManager.findIndexById(idDelete);
        if (index != -1){
            studentManager.delete(idDelete);
            System.out.println("Xóa sinh viên thành công ");
        } else {
            System.out.println("Không tìm thấy mã sinh viên! ");
        }
    }
    public void displayAllStudents(){
        System.out.println("===== Danh sách sinh viên =====");
        List<Student> students = studentManager.getAll();
        for (Student student : students){
            System.out.println(student);
        }
    }
    public void showSearchByScoreMenu(){
        System.out.println("===== Tìm kiếm sinh viên theo khoảng điểm =====");
        System.out.print("Nhập khoảng điểm tối thiểu: ");
        double minScore = Input.inputnumber();
        System.out.print("Nhập khoảng điểm tối đa: ");
        double maxScore = Input.inputnumber();
        List<Student> students = studentManager.searchByScoreRange(minScore,maxScore);
        students.forEach(System.out::println);
    }
    public void showSearchByConductMenu(){
        System.out.println("===== Tìm kiếm sinh viên theo hạnh kiểm =====");
        System.out.print("Nhập hạnh kiểm: ");
        String conduct = Input.inputstring();
        List<Student> students = studentManager.searchByConduct(conduct);
        if (students.isEmpty()){
            System.out.println("Không tìm thây sinh viên với hạnh kiểm này! ");
        } else {
            students.forEach(System.out::println);
        }
    }
    public void showSearchByClazzMenu(){
        System.out.println("===== Tìm kiếm sinh viên theo lớp =====");
        System.out.println("Danh sách các lớp ");
        List<Clazz> clazzList = clazzManager.getAll();
        for (Clazz clazz : clazzList){
            System.out.println("Mã lớp " + clazz.getId() +"Tên lớp: " + clazz.getName());
        }
        System.out.print("Nhập mã lớp: ");
        int idClazz = Input.inputnumber();
        List<Student> students = studentManager.searchByClazz(idClazz);
        students.forEach(System.out::println);
    }
    public void showSearchTopStudentMenu(){
        System.out.println("===== Tìm kiếm sinh viên có điểm cao nhất =====");
        Student topStudent = studentManager.findTopStudent();
        if (topStudent != null){
            System.out.println(topStudent);
        } else {
            System.out.println("Không có sinh viên nào ");
        }
    }
    public void showSortStudentsMenu(){
        System.out.println("===== Sắp xếp danh sách sinh viên =====");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo điểm");
        System.out.println("Nhập lựa chọn: ");
        int sortChoice = Input.inputnumber();
        switch (sortChoice){
            case 1:
                studentManager.sortByName();
                break;
            case 2:
                studentManager.sortByScore();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ! ");
                return;
        }
        displayAllStudents();
    }
}
