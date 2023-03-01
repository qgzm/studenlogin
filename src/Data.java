import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {//包含学生的数据
    public static List<Student> stus = new ArrayList<>();

    public static List<String> FindStuNo() {//返回学生学号集合
        ArrayList<String> Nos = new ArrayList<>();
        for (Student stu : stus) {
            Nos.add(stu.getNo());
        }
        return Nos;
    }

    public static Student FindStu(String no) {//返回学生
        for (Student stu : stus) {
            if (stu.getNo() == no) return stu;
        }
        return null;
    }

    public static boolean delStu(String no) {//返回学生
        for (Student stu : stus) {
            if (stu.getNo() == no) {
                stus.remove(stu);
                return true;
            }
        }
        return false;
    }

    public static boolean updateStu(String no, String name, String sex, String age) {//返回学生
        for (Student stu : stus) {
            if (stu.getNo() == no) {
                stu.setName(name);
                stu.setSex(sex);
                stu.setAge(age);
                return true;
            }
        }
        return false;
    }

    public static boolean insertStu(String no, String name, String sex, String age) {
        stus.add(new Student(no, name, sex, age));
        return false;
    }

    public static void writeStus(String file) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stus);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readStus(String file) {
        FileInputStream fileinputStream = null;
        ObjectInputStream objectinputStream = null;
        try {
            fileinputStream = new FileInputStream(file);
            objectinputStream = new ObjectInputStream(fileinputStream);
            Object o = objectinputStream.readObject();
            if (o instanceof List) {
                stus = (List<Student>) o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
