package saveData;

import Login.UserAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteUserAccount {
    private File file = new File("database/userAccount.csv");

    public void writeData(List<UserAccount> users) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder data = new StringBuilder();
            for (UserAccount user : users) {
                data.append(user.getUsername()).append(",").append(user.getPassword()).append("\n");
            }
            bufferedWriter.write(data.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<UserAccount> readData() {
        List<UserAccount> users = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại, tạo mới file.");
            return users;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length == 2) {
                    String username = data[0];
                    String password = data[1];
                    UserAccount user = new UserAccount(username, password);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return users;
    }
}
