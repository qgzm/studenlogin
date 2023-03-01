import java.io.Serializable;

public class Student implements Serializable {//学生类
    private String No;
    private String Name;
    private String Sex;
    private String Age;

    public Student(String no, String name, String sex, String age) {
        No = no;
        Name = name;
        Sex = sex;
        Age = age;
    }

    //alt + insert 快捷键构造函数
    public String getNo() {

        return No;
    }

    public String getName() {

        return Name;
    }

    public String getSex() {

        return Sex;
    }

    public String getAge() {

        return Age;
    }

    public void setNo(String no) {

        No = no;
    }

    public void setName(String name) {

        Name = name;
    }

    public void setSex(String sex) {

        Sex = sex;
    }

    public void setAge(String age) {

        Age = age;
    }
}
