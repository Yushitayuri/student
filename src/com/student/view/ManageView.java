package com.student.view;

import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.student.utils.DButil;
import com.student.utils.Table;
import com.student.utils.Tools;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ManageView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DButil dButil= new DButil("root","123456","db_student");
					ManageView window = new ManageView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("查看在线账号");
		mntmNewMenuItem_5.setIcon(new ImageIcon("image/I1.gif"));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("查看所有账号");
		mntmNewMenuItem_4.setIcon(new ImageIcon("image/I2.gif"));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("更改学生账号信息");
		mntmNewMenuItem_3.setIcon(new ImageIcon("image/I3.gif"));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("更改当前账号密码");
		mntmNewMenuItem_2.setIcon(new ImageIcon("image/I4.gif"));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("账号");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("注销");
		mntmNewMenuItem_1.setIcon(new ImageIcon("image/I1_1.jpg"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("退出");
		mntmNewMenuItem.setIcon(new ImageIcon("image/I1_2.jpg"));
		mnNewMenu_1.add(mntmNewMenuItem);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/3.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "基础信息管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 110, 776, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(10, 20, 58, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(41, 17, 90, 20);
		panel.add(textField);
		textField.setColumns(10);

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(141, 16, 37, 22);
		panel.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(190, 16, 37, 22);
		panel.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("全部");
		rdbtnNewRadioButton_2.setBounds(229, 16, 70, 22);
		panel.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_2);
		//设置按钮默认值:全部
		rdbtnNewRadioButton_2.setSelected(true);

		JLabel lblNewLabel_1 = new JLabel("年龄");
		lblNewLabel_1.setBounds(305, 20, 30, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(335, 17, 65, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("班级");
		lblNewLabel_2.setBounds(410, 20, 30, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(450, 17, 102, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("学号");
		lblNewLabel_3.setBounds(562, 20, 30, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(602, 17, 153, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("按【学号】搜索");
		lblNewLabel_4.setBounds(10, 45, 168, 14);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(125, 42, 102, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("增加学生");
		btnNewButton.setBounds(255, 41, 102, 22);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String age = textField_1.getText();
				String grade = textField_2.getText();
				String num = textField_3.getText();

				String gender =null;
				if(rdbtnNewRadioButton.isSelected()){
					gender="男";
				}else  if(rdbtnNewRadioButton_1.isSelected()){
					gender="女";
				}

				if (name.equals("")){
					Tools.shoeMessage("请输入姓名");
				}else if (gender==null){
					Tools.shoeMessage("请选择性别");
				} else if (age.equals("")){
					Tools.shoeMessage("请输入年龄");
				}else if (grade.equals("")){
					Tools.shoeMessage("请输入班级");
				}else if (num.equals("")){
					Tools.shoeMessage("请输入学号");
				}else {
					//信息填写完毕
					Student student = new Student(name, gender, age, grade,num);
					int res=new StudentDao().addStudent(student);
					if(res==1){
						Tools.shoeMessage("添加成功");
					}else{
						Tools.shoeMessage("添加失败，请修改信息");
					}
				}
			}
		});





		
		JButton btnNewButton_1 = new JButton("删除学生");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(357, 41, 102, 22);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改学生");
		btnNewButton_2.setBounds(460, 41, 102, 22);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("查找学生");
		btnNewButton_3.setBounds(562, 41, 102, 22);
		panel.add(btnNewButton_3);
		//条件模糊查找    学号查找     查找全部
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String conditionNum = textField_4.getText();//条件学号
					if(conditionNum.equals("")){
						//查询全部
						String name = textField.getText();
						String age = textField_1.getText();
						String grade = textField_2.getText();
						String num = textField_3.getText();

						String gender =null;
						if(rdbtnNewRadioButton.isSelected()){
							gender="男";
						}else  if(rdbtnNewRadioButton_1.isSelected()){
							gender="女";
						}else  if(rdbtnNewRadioButton_2.isSelected()){
							gender="";
						}

						if (name.equals("")&&age.equals("")&&grade.equals("")&&num.equals("")&&gender.equals("")){
							//查询全部
							Tools.shoeMessage("查询全部");
						}else {
							//条件查询
							Tools.shoeMessage("条件查询");
						}
					}else {
						//单独查询
						Tools.shoeMessage("单独查询");
					}
			}
		});
		
		JButton btnNewButton_4 = new JButton("重置数据");
		btnNewButton_4.setBounds(671, 41, 95, 22);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "账号信息显示", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 222, 766, 165);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);













//		panel_1.add(panel_2);

		//添加表格
		Object columns[]={"学号","姓名","性别","班级","年龄"};
		Table table =new Table(columns);
		model= table.getModel();
		JScrollPane scrollPane = table.getScrollPane();
//		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "账号信息显示", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(10, 20, 746, 135);
		panel_1.add(scrollPane);


		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "账号信息显示", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(20, 397, 766, 165);
		frame.getContentPane().add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 20, 746, 135);
		panel_1_1.add(panel_2_1);
	}
}
