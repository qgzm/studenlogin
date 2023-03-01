import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class IDUMenu extends JFrame {//学生信息主界面类
    private List stulist = new List();//awt中的列表
    //四个学生文本信息
    private TextField numTxt = new TextField();
    private TextField nameTxt = new TextField();
    private TextField sexTxt = new TextField();
    private TextField ageTxt = new TextField();

    private JLabel numLabel = new JLabel("学号");
    private JLabel nameLabel = new JLabel("姓名");
    private JLabel sexLabel = new JLabel("年龄");
    private JLabel ageLabel = new JLabel("性别");

    private JButton insertBut = new JButton("添加");
    private JButton delBut = new JButton("删除");
    private JButton updateBut = new JButton("修改");

    public IDUMenu() {
        this.setLayout(null);
        this.setBounds(300, 300, 500, 300);
        this.setTitle("学生信息主界面");
        stulist.setBounds(50, 50, 100, 200);
        stulist.setBackground(new Color(230, 230, 230));
        java.util.List<String> stunos = Data.FindStuNo();
        for (String s : stunos) {
            stulist.add(s);
        }

        numLabel.setBounds(170, 50, 80, 20);
        nameLabel.setBounds(170, 100, 80, 20);
        ageLabel.setBounds(170, 150, 80, 20);
        sexLabel.setBounds(170, 200, 80, 20);
        numTxt.setBounds(230, 50, 100, 20);
        nameTxt.setBounds(230, 100, 100, 20);
        sexTxt.setBounds(230, 150, 100, 20);
        ageTxt.setBounds(230, 200, 100, 20);
        delBut.setBounds(350, 50, 80, 20);
        insertBut.setBounds(350, 110, 80, 20);
        updateBut.setBounds(350, 170, 80, 20);

        numTxt.setEditable(false);

        stulist.addItemListener(new IL());
        insertBut.addActionListener(new ButtonAC());
        delBut.addActionListener(new ButtonAC());
        updateBut.addActionListener(new ButtonAC());
        this.addWindowListener(new WA());

        this.add(numTxt);
        this.add(nameTxt);
        this.add(ageTxt);
        this.add(sexTxt);
        this.add(numLabel);
        this.add(nameLabel);
        this.add(ageLabel);
        this.add(sexLabel);
        this.add(stulist);
        this.add(insertBut);
        this.add(updateBut);
        this.add(delBut);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    class IL implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String stuno = stulist.getSelectedItem();
                Student stu = Data.FindStu(stuno);
                if (stu == null) return;
                numTxt.setText(stu.getNo());
                nameTxt.setText(stu.getName());
                sexTxt.setText(stu.getSex());
                ageTxt.setText(stu.getAge());

            }
        }
    }

    class ButtonAC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            JButton bt = null;
            String buttonLabel = null;
            String stuNum = stulist.getSelectedItem();
            if (o instanceof JButton) {
                bt = (JButton) o;
                buttonLabel = bt.getText();
            }
            if ("删除".equals(buttonLabel)) {
                Data.delStu(stuNum);
                stulist.remove(stuNum);
                numTxt.getText();
                numTxt.setText("");
                nameTxt.getText();
                nameTxt.setText("");
                ageTxt.getText();
                ageTxt.setText("");
                sexTxt.getText();
                sexTxt.setText("");
            }
            if ("修改".equals(buttonLabel)) {
                Data.updateStu(stuNum, nameTxt.getText(), sexTxt.getText(), ageTxt.getText());
            }
            if ("添加".equals(buttonLabel)) {
                new InsertStuMenu(IDUMenu.this, true);
                stulist.removeAll();
                java.util.List<String> stunos = Data.FindStuNo();
                for (String s : stunos) {
                    stulist.add(s);
                }
            }
        }
    }

    class WA extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            Data.writeStus("stus.data");
            System.exit(0);
        }
    }

}
