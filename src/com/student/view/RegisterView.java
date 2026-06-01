package com.student.view;

import com.student.dao.AdminDao;
import com.student.utils.Tools;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterView {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;



	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
	}

	private final int WIDTH = 410;
	private final int HEIGHT = 345;



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("注册界面");

		Tools.setPos(frame,WIDTH,HEIGHT);

		frame.getContentPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("image/2.jpg"));
		lblNewLabel.setBounds(0, 0, 396, 308);
		
		
		JLabel lblNewLabel_1 = new JLabel("学生信息管理系统账号注册");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_1.setBounds(66, 10, 264, 45);
		frame.getContentPane().add(lblNewLabel_1);

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 123, 396, 185);
		frame.getContentPane().add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_2.setBounds(92, 10, 57, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(159, 7, 157, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("账号");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_3.setBounds(92, 40, 57, 14);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 37, 157, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("密码");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_4.setBounds(92, 70, 57, 14);
		panel.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 67, 157, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("确认密码");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_5.setBounds(92, 100, 57, 14);
		panel.add(lblNewLabel_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(159, 97, 157, 20);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton.setBounds(138, 137, 96, 22);
		panel.add(btnNewButton);
		
		
		
		frame.getContentPane().add(lblNewLabel);

		btnNewButton.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击注册事件
				String name = textField.getText();
				String account = textField_1.getText();

				String password =new String(passwordField.getPassword());
				String password_1 = new String(passwordField_1.getPassword());
				if(name.equals("")){
					Tools.shoeMessage("请输入姓名");
				}else if(account.equals("")){
					Tools.shoeMessage("请输入账号");
				}else if(password.equals("")){
					Tools.shoeMessage("请输入密码");
				}else if(password_1.equals("")){
					Tools.shoeMessage("请再次输入密码");
				}else if(!password.equals(password_1)){
						Tools.shoeMessage("两次密码不一致");
				}else{
					int a = AdminDao.register(account,password,name,"0","0");
					if(a==0){
						Tools.shoeMessage("注册失败，请重试！");
					}else if(a==1){
						Tools.shoeMessage("注册成功！");
					}else{
						Tools.shoeMessage("账号冲突");
					}
				}
				}

		});
	}
}
