public class Main {
    public static void main(String[] args) {
        Data.readStus("stus.data");
        UserData.readStus("user.data");
        new LoginMenu();
    }
}
