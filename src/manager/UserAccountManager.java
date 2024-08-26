package manager;

import Login.UserAccount;
import saveData.ReadAndWriteUserAccount;

import java.util.List;

public class UserAccountManager {
    private List<UserAccount> users;
    private ReadAndWriteUserAccount readAndWriteUser = new ReadAndWriteUserAccount();

    public UserAccountManager() {
        this.users = readAndWriteUser.readData();
    }
    private UserAccount findUserByUsername(String username) {
        for (UserAccount user : users) {
            if (user.getUsername().trim().equalsIgnoreCase(username.trim())) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(UserAccount user) {
        if (findUserByUsername(user.getUsername()) == null) {
            users.add(user);
            readAndWriteUser.writeData(users);
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!");
        }
    }

    public UserAccount loginUser(String username, String password) {
        for (UserAccount user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return user;
            }
        }
        System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        return null;
    }
    public void deleteUser(String username) {
        UserAccount user = findUserByUsername(username);
        if (user != null) {
            users.remove(user);
            readAndWriteUser.writeData(users);
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Tài khoản không tồn tại!");
        }
    }
}

