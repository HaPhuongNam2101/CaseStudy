package manager;

import model.Clazz;
import saveData.ReadAndWriteStudent;
import saveData.ReadWriteClazz;

import java.util.ArrayList;
import java.util.List;

public class ClazzManager implements IManager<Clazz> {
    private List<Clazz> clazzList;
    private ReadWriteClazz readWriteClazz = new ReadWriteClazz();
    public ClazzManager() {
        this.clazzList = this.readWriteClazz.ReaderClazz();
    }
    @Override
    public void add(Clazz clazz) {
        clazzList.add(clazz);
        readWriteClazz.WriterClazz(clazzList);
    }

    @Override
    public void update(int id, Clazz clazz) {
        int index = findIndexById(id);
        clazzList.set(index, clazz);
        readWriteClazz.WriterClazz(clazzList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        clazzList.remove(index);
        readWriteClazz.WriterClazz(clazzList);
    }

    @Override
    public List<Clazz> getAll() {
       this.clazzList = this.readWriteClazz.ReaderClazz();
       return this.clazzList;
    }

    @Override
    public int findIndexById(int id) {
       for (int i = 0; i < clazzList.size(); i++) {
           if (clazzList.get(i).getId() == id) {
               return i;
           }
       }
       return -1;
    }
}
