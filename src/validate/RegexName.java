package validate;

import input.Input;

public class RegexName {
    public static String validateName() {
        String regex = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèéêìíòóôõùúăđĩũơưỲỴÝỶỹ]+(?: [A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèéêìíòóôõùúăđĩũơưỲỴÝỶỹ]+)*$";
        do {
            System.out.print("Nhập tên sinh viên: ");
            String name = Input.inputstring();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Tên sai định dạng! Yêu cầu nhập lại.");
            }
        } while (true);
    }
}
