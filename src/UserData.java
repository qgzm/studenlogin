import java.io.*;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

public class UserData {
    private static Vector<User> vector = new Vector<>();

    public static boolean insert(String username, String passwd) {
        String Regex_user = "^[a-zA-Z0-9_]{6,20}$";
        String Regex_passwd = "^[a-zA-Z0-9_]{6,20}$";   //"^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}$";
        boolean isUser = Pattern.matches(Regex_user, username);
        boolean userPassword = Pattern.matches(Regex_passwd, passwd);
        for (User user : vector) {
            if (user.username.equals(username) && user.getPasswd().equals(passwd)) {
                return false;
            }
        }
        if (isUser && userPassword) {
            vector.add(new User(username, passwd));
            return true;
        }
        return false;
    }

    public static Vector<User> getVector() {
        return vector;
    }

    public static void writeStus(String file) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vector);
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
                vector = (Vector<User>) o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
