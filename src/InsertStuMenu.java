import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertStuMenu extends Dialog{
    private TextField notxt = new TextField();
    private TextField nametxt = new TextField();
    //private TextField sextxt = new TextField();
    private TextField agetxt = new TextField();

    private JLabel nolabel = new JLabel("学号");
    private JLabel namelabel = new JLabel("姓名");
    private JLabel sexlabel = new JLabel("性别");
    private JLabel agelabel = new JLabel("年龄");
    private JLabel nanlabel = new JLabel("男");
    private JLabel nvlabel = new JLabel("女");

    //private JPanel Choose = new JPanel();
    private ButtonGroup Sexoption = new ButtonGroup();
    private JRadioButton option1 = new JRadioButton("男");
    private JRadioButton option2 = new JRadioButton("女");

    private JButton Okbt = new JButton("添加");
    private JButton cancelbt = new JButton("取消");

    private String Sex = "男";

    public InsertStuMenu(Frame owner, boolean modal){
        super(owner,modal);
        this.setLayout(null);
        this.setBounds(400,400,300,250);
        this.setTitle("添加学生界面");
        nolabel.setBounds(50,50,80,20);
        namelabel.setBounds(50,80,80,20);
        agelabel.setBounds(50,140,80,20);
        sexlabel.setBounds(50,110,80,20);
        notxt.setBounds(110,50,100,20);
        nametxt.setBounds(110,80,100,20);
        //sextxt.setBounds(110,110,100,20);
        agetxt.setBounds(110,140,100,20);
        Okbt.setBounds(70,180,80,30);
        cancelbt.setBounds(170,180,80,30);
        Sexoption.add(option1);
        Sexoption.add(option2);
        option1.setBounds(110,110,20,20);
        option2.setBounds(160,110,20,20);
        nanlabel.setBounds(130,110,20,20);
        nvlabel.setBounds(180,110,20,20);

        option1.setSelected(true);
        option1.addActionListener(new ChooseAC());
        option2.addActionListener(new ChooseAC());
        Okbt.addActionListener(new insertAC());
        cancelbt.addActionListener(new insertAC());
        this.addWindowListener(new WA());
        this.add(notxt);
        this.add(nametxt);
        this.add(agetxt);
        //this.add(sextxt);
        this.add(nolabel);
        this.add(namelabel);
        this.add(agelabel);
        this.add(sexlabel);
        this.add(Okbt);
        this.add(cancelbt);
        this.add(option1);
        this.add(option2);
        this.add(nanlabel);
        this.add(nvlabel);

        this.setVisible(true);
    }
    class ChooseAC implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            JRadioButton bt = null;
            String str = null;
            if (o instanceof JRadioButton){
                bt = (JRadioButton) o;
                str = bt.getLabel();
            }
            if ("男".equals(str)){
                Sex = "男";
            }
            if ("女".equals(str)){
                Sex = "女";
            }

        }
    }
    class insertAC implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            JButton bt = null;
            String str = null;
            if (o instanceof JButton){
                bt = (JButton) o;
                str = bt.getLabel();
            }
            if ("添加".equals(str)){
                Data.insertStu(notxt.getText(),nametxt.getText(),Sex,agetxt.getText());
                InsertStuMenu.this.dispose();
            }
            if ("取消".equals(str)){
                notxt.getText();
                notxt.setText("");
                nametxt.getText();
                nametxt.setText("");
                agetxt.getText();
                agetxt.setText("");
                option1.setSelected(false);
                option2.setSelected(false);

            }

        }
    }
    class WA extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            InsertStuMenu.this.dispose();
        }
    }
}
