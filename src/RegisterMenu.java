import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterMenu extends Dialog {
    private TextField userNameTxt = new TextField();
    private TextField passwordTxt = new TextField();
    private JTextField prompt = new JTextField("账号密码应为6到20位数字、字母和下划线");

    private JLabel userLabel = new JLabel("用户名");
    private JLabel passwordLabel = new JLabel("密码");


    private JButton addBut = new JButton("添加");
    private JButton cancelBut = new JButton("取消");

    public RegisterMenu(Frame owner, boolean modal) {
        super(owner);
        this.setLayout(null);
        this.setBounds(400, 400, 300, 250);
        this.setTitle("注册界面");
        userLabel.setBounds(50, 100, 80, 20);
        passwordLabel.setBounds(50, 140, 80, 20);

        userNameTxt.setBounds(110, 100, 100, 20);
        passwordTxt.setBounds(110, 140, 100, 20);
        prompt.setBounds(30, 60, 240, 20);
        prompt.setBorder(null);
        prompt.setForeground(Color.red);

        addBut.setBounds(70, 180, 80, 30);
        cancelBut.setBounds(170, 180, 80, 30);

        addBut.addActionListener(new insertAC());
        cancelBut.addActionListener(new insertAC());
        this.addWindowListener(new WA());
        this.add(userNameTxt);
        this.add(passwordTxt);
        this.add(prompt);
        this.add(userLabel);
        this.add(passwordLabel);
        this.add(addBut);
        this.add(cancelBut);

        this.setVisible(true);

    }

    class insertAC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            JButton bt = null;
            String str = null;
            if (o instanceof JButton) {
                bt = (JButton) o;
                str = bt.getLabel();
            }
            if ("添加".equals(str)) {
                boolean insertUser = UserData.insert(userNameTxt.getText(), passwordTxt.getText());
                prompt.getText();
                if (!insertUser) {
                    prompt.setText("账号格式不正确或账号已存在");
                    userNameTxt.getText();
                    userNameTxt.setText("");
                    passwordTxt.getText();
                    passwordTxt.setText("");
                } else {
                    prompt.setText("添加成功");
                    userNameTxt.getText();
                    userNameTxt.setText("");
                    passwordTxt.getText();
                    passwordTxt.setText("");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    //RegisterMenu.this.dispose();
                }


            }
            if ("取消".equals(str)) {
                userNameTxt.getText();
                userNameTxt.setText("");
                passwordTxt.getText();
                passwordTxt.setText("");
            }

        }
    }

    class WA extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            RegisterMenu.this.dispose();
        }
    }
}
