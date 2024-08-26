package saveData;

import model.Clazz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteClazz {
    private File file = new File("database/clazz.csv");
    public void WriterClazz(List<Clazz> clazzList) {
        try {
            String data = "";
            for (Clazz clazz : clazzList) {
                data += clazz.getId() + "," + clazz.getName() + "," + clazz.getUnit() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Clazz> ReaderClazz() {
        List<Clazz> clazzList = new ArrayList<Clazz>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                Clazz clazz = new Clazz(Integer.parseInt(data[0]),data[1],data[2]);
                clazzList.add(clazz);
            }
        } catch (IOException e){
            System.out.println(e);
        }
        return clazzList;
    }
}
