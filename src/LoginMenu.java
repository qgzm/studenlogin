import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class LoginMenu extends JFrame {
    //学生系统登陆界面
    private TextField textField1 = new TextField(), textField2 = new TextField();
    private JTextField prompt = new JTextField("初始账号和密码都为123456，可注册新账户");
    private JButton cancelButton = new JButton("取消"), loginButton = new JButton("登录"), registerButton = new JButton("注册");
    private JLabel username = new JLabel("用户名"), password = new JLabel("密码");

    //学生登陆界面
    public LoginMenu() {
        this.setLayout(null);
        //设置登录界面的位置
        this.setBounds(100, 100, 400, 300);
        this.setTitle("学生信息平台登陆界面");
        username.setBounds(60, 100, 80, 20);
        password.setBounds(60, 140, 80, 20);
        loginButton.setBounds(50, 190, 80, 30);
        cancelButton.setBounds(250, 190, 80, 30);
        registerButton.setBounds(150, 190, 80, 30);
        textField1.setBounds(160, 100, 150, 20);
        textField2.setBounds(160, 140, 150, 20);
        prompt.setBounds(60, 60, 240, 20);
        prompt.setBorder(null);
        prompt.setForeground(Color.darkGray);
        this.add(username);
        this.add(password);
        this.add(loginButton);
        this.add(cancelButton);
        this.add(registerButton);
        this.add(textField1);
        this.add(textField2);
        this.add(prompt);
        textField2.setEchoChar('*');
        loginButton.addActionListener(new AC());
        cancelButton.addActionListener(new AC());
        registerButton.addActionListener(new AC());


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    class AC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            JButton bt = null;
            String str = null;
            Vector<User> vector = UserData.getVector();
            if (o instanceof JButton) {
                bt = (JButton) o;
                str = bt.getLabel();
            }
            if ("登录".equals(str)) {
                String username = textField1.getText();
                String passwd = textField2.getText();
                for (User user : vector) {
                    if (user.username.equals(username) && user.getPasswd().equals(passwd)) {
                        new IDUMenu();
                        LoginMenu.this.setVisible(false);
                        UserData.writeStus("user.data");
                    }
                }
                prompt.getText();
                prompt.setText("账号或密码不正确");

            }
            if ("注册".equals(str)) {
                new RegisterMenu(LoginMenu.this, true);
            }
            if ("取消".equals(str)) {
                textField1.getText();
                textField2.getText();
                textField1.setText("");
                textField2.setText("");
            }
        }
    }
}
