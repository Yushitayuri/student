package com.student.view;

import com.student.bean.Admin;
import com.student.dao.AdminDao;
import com.student.utils.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//构造方法
    public class LoginView {
        private JFrame frame;
        private final int WIDTH = 500;
        private final int HEIGHT = 280;


        public static String admin="0";//用户

        // 构造方法
        public LoginView() {
            frame = new JFrame();
            initView();  // 调用初始化方法
            frame.setTitle("学生信息管理系统");
            frame.setLayout(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Tools.setPos(frame, WIDTH, HEIGHT);
            frame.setVisible(true);  //
        }

        // 初始化窗口（方法独立写在构造方法外面）
        private void initView() {
            // 创建盘子
            JPanel panel = new JPanel();
            panel.setBounds(0, 0, WIDTH, HEIGHT);
            panel.setLayout(null);
            frame.add(panel);

            // 用标签实现背景
            ImageIcon icon = new ImageIcon("image/1.jpg");
            JLabel label = new JLabel(icon);
            label.setBounds(0, 0, WIDTH, HEIGHT);


            // 设置2个标签    2个输入框    1个标签  1个按钮
            JLabel title = new JLabel("学生信息管理系统");  //
            title.setBounds(0, 0, WIDTH,120);
            title.setFont(new Font("宋体", Font.BOLD, 28));
            title.setForeground(Color.CYAN);
            panel.add(title);

            title.setHorizontalAlignment(JLabel.CENTER);

            //绘制 标签   账号、密码
            JPanel AccountPanel = new JPanel();
            AccountPanel.setBounds(0, 120, WIDTH, 30);
            AccountPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(AccountPanel);
            AccountPanel.setOpaque(false);

            JLabel AccountLabel = new JLabel("账号");
            AccountPanel.add(AccountLabel);
            AccountLabel.setForeground(new Color(255, 228, 181));

            JTextField Account = new JTextField(18);
            AccountPanel.add(Account);
            Account.setFont(new Font("宋体", Font.BOLD, 18));

            JPanel PasswordPanel = new JPanel();
            PasswordPanel.setBounds(0, 150, WIDTH, 30);
            PasswordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(PasswordPanel);
            PasswordPanel.setOpaque(false);

            JLabel PasswordLabel = new JLabel("密码");
            PasswordPanel.add(PasswordLabel);
            PasswordLabel.setForeground(new Color(255, 228, 181));

            JPasswordField Password = new JPasswordField(18);
            PasswordPanel.add(Password);
            Password.setFont(new Font("宋体", Font.BOLD, 18));


            JPanel LoginPanel = new JPanel();
            LoginPanel.setBounds(0, 180, WIDTH, 30);
            LoginPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(LoginPanel);
            LoginPanel.setOpaque(false);

            JButton Login = new JButton("登录");
            LoginPanel.add(Login);
            Login.setBackground(new Color(8, 189, 252));

            JLabel RegisterLabel = new JLabel("注册账户>");
            panel.add(RegisterLabel);
            RegisterLabel.setBounds(10, 210, 100, 40);
            RegisterLabel.setFont(new Font("宋体", Font.PLAIN, 11));
            RegisterLabel.setForeground(new Color(166, 166, 166));


            Login.addActionListener(new  ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //判断账号和密码输入框是否为空
                    String account =Account.getText();
                    String password =new String(Password.getPassword());
                    if(account.equals("")){
                        Tools.shoeMessage("请输入账号！");
                    }else if(password.equals("")){
                        Tools.shoeMessage("请输入密码！");
                    }else {
                        //查询当前账号是否存在、是否在线、是否强制登录
                        Admin admin= AdminDao.isLogin(account,password);
                        if(admin==null){
                            Tools.shoeMessage("账号或密码错误！");
                        }else{
                            LoginView.admin=admin.getAdmin();
                            Tools.shoeMessage("登录成功");
                        }


                    }

                }
            });


            panel.add(label);;
        }
    }

