package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double score ;
    private String conduct;
    private int clazzId;
    private static int idIncrement = 1;

    public Student( String name, int age, String gender, double score, String conduct,int clazzId) {
        this.id = idIncrement;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.conduct = conduct;
        this.clazzId = clazzId;
        idIncrement++;
    }

    public Student(int id, String name, int age, String gender, double score, String conduct, int clazzId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.conduct = conduct;
        this.clazzId = clazzId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int classId) {
        this.clazzId = classId;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    @Override
    public String toString() {
        return " Sinh viên " + " | Mã sinh viên: " + id + " | Tên sinh viên: " + name + " | Tuổi sinh viên: " + age + " | Điểm sinh viên: " + score + " | Giới tính: " + gender + " | Hạnh kiểm:  " + conduct + " | Mã Lớp: " + clazzId;
    }
}
