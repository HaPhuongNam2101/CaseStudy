package saveData;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStudent {
    private File file = new File("database/student.csv");

    public void WriteStudent(List<Student> studentList) {
        try {
            String data = "";
            for (Student student : studentList) {
                data += student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getScore() + "," + student.getGender() + "," + student.getConduct() + "," + student.getClazzId() + "\n";

            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Student> ReadStudent() {
        List<Student> studentList = new ArrayList<Student>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double score = Double.parseDouble(data[3]);
                String gender = data[4];
                String conduct = data[5];
                int classId = Integer.parseInt(data[6]);
                Student student = new Student(id, name, age, gender, score, conduct, classId);
                studentList.add(student);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return studentList;
    }
}
