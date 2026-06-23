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
import java.util.List;

public class ManageView {

	JFrame frame;
	// ===== 基础信息字段 =====
	private JTextField textField_name;      // 姓名
	private JTextField textField_age;       // 年龄
	private JTextField textField_grade;     // 班级
	private JTextField textField_num;       // 学号
	private JTextField textField_search;    // 搜索框（学号）

	// ===== 新增扩展字段 =====
	private JTextField textField_birthdate; // 出生日期
	private JTextField textField_pa;        // 政治面貌
	private JTextField textField_address;   // 地址
	private JTextField textField_telephone; // 电话
	private JTextField textField_dorm;      // 宿舍

	private JRadioButton rdbtnMale;         // 男
	private JRadioButton rdbtnFemale;       // 女
	private JRadioButton rdbtnAll;          // 全部
	private ButtonGroup buttonGroup;

	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
            public void run() {
				try {
					DButil dButil = new DButil("root", "123456", "db_student");
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
		frame.setTitle("学生信息管理系统");
		frame.setBounds(100, 100, 900, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// ===== 菜单栏 =====
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("账号");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("注销");
		mntmNewMenuItem_1.setIcon(new ImageIcon("image/I1_1.jpg"));
		mnNewMenu_1.add(mntmNewMenuItem_1);

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginView loginView = new LoginView();
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("退出");
		mntmNewMenuItem.setIcon(new ImageIcon("image/I1_2.jpg"));
		mnNewMenu_1.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().setLayout(null);

		// ===== 顶部图片 =====
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/3.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 100);
		frame.getContentPane().add(lblNewLabel);

		// ===== 主操作面板 =====
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "学生信息管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 110, 876, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// ---------- 第一行：姓名 ----------
		JLabel label_name = new JLabel("姓名");
		label_name.setBounds(10, 20, 50, 20);
		panel.add(label_name);

		textField_name = new JTextField();
		textField_name.setBounds(65, 20, 100, 22);
		panel.add(textField_name);
		textField_name.setColumns(10);

		// ---------- 性别（单选按钮） ----------
		rdbtnMale = new JRadioButton("男");
		rdbtnMale.setBounds(180, 20, 50, 22);
		panel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("女");
		rdbtnFemale.setBounds(235, 20, 50, 22);
		panel.add(rdbtnFemale);

		rdbtnAll = new JRadioButton("全部");
		rdbtnAll.setBounds(290, 20, 60, 22);
		panel.add(rdbtnAll);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnAll);
		rdbtnAll.setSelected(true); // 默认选中"全部"

		// ---------- 第一行：年龄 ----------
		JLabel label_age = new JLabel("年龄");
		label_age.setBounds(370, 20, 40, 20);
		panel.add(label_age);

		textField_age = new JTextField();
		textField_age.setBounds(415, 20, 80, 22);
		panel.add(textField_age);
		textField_age.setColumns(10);

		// ---------- 第一行：班级 ----------
		JLabel label_grade = new JLabel("班级");
		label_grade.setBounds(510, 20, 40, 20);
		panel.add(label_grade);

		textField_grade = new JTextField();
		textField_grade.setBounds(555, 20, 120, 22);
		panel.add(textField_grade);
		textField_grade.setColumns(10);

		// ---------- 第一行：学号 ----------
		JLabel label_num = new JLabel("学号");
		label_num.setBounds(690, 20, 40, 20);
		panel.add(label_num);

		textField_num = new JTextField();
		textField_num.setBounds(730, 20, 120, 22);
		panel.add(textField_num);
		textField_num.setColumns(10);

		// ---------- 第二行：出生日期 ----------
		JLabel label_birthdate = new JLabel("出生日期");
		label_birthdate.setBounds(10, 55, 60, 20);
		panel.add(label_birthdate);

		textField_birthdate = new JTextField();
		textField_birthdate.setBounds(75, 55, 120, 22);
		textField_birthdate.setToolTipText("格式: yyyy-MM-dd");
		panel.add(textField_birthdate);
		textField_birthdate.setColumns(10);

		// ---------- 第二行：政治面貌 ----------
		JLabel label_pa = new JLabel("政治面貌");
		label_pa.setBounds(210, 55, 60, 20);
		panel.add(label_pa);

		textField_pa = new JTextField();
		textField_pa.setBounds(275, 55, 100, 22);
		panel.add(textField_pa);
		textField_pa.setColumns(10);

		// ---------- 第二行：电话 ----------
		JLabel label_telephone = new JLabel("电话");
		label_telephone.setBounds(390, 55, 40, 20);
		panel.add(label_telephone);

		textField_telephone = new JTextField();
		textField_telephone.setBounds(435, 55, 130, 22);
		panel.add(textField_telephone);
		textField_telephone.setColumns(10);

		// ---------- 第二行：宿舍 ----------
		JLabel label_dorm = new JLabel("宿舍");
		label_dorm.setBounds(580, 55, 40, 20);
		panel.add(label_dorm);

		textField_dorm = new JTextField();
		textField_dorm.setBounds(625, 55, 80, 22);
		panel.add(textField_dorm);
		textField_dorm.setColumns(10);

		// ---------- 第三行：地址（占一整行） ----------
		JLabel label_address = new JLabel("地址");
		label_address.setBounds(10, 90, 40, 20);
		panel.add(label_address);

		textField_address = new JTextField();
		textField_address.setBounds(55, 90, 650, 22);
		panel.add(textField_address);
		textField_address.setColumns(10);

		// ---------- 第四行：搜索区域 ----------
		JLabel label_search = new JLabel("按【学号】搜索");
		label_search.setBounds(10, 125, 100, 20);
		panel.add(label_search);

		textField_search = new JTextField();
		textField_search.setBounds(115, 125, 120, 22);
		panel.add(textField_search);
		textField_search.setColumns(10);

		// ---------- 按钮区域 ----------
		JButton btnAdd = new JButton("增加学生");
		btnAdd.setBounds(260, 124, 100, 24);
		panel.add(btnAdd);

		JButton btnDelete = new JButton("删除学生");
		btnDelete.setBounds(370, 124, 100, 24);
		panel.add(btnDelete);

		JButton btnUpdate = new JButton("修改学生");
		btnUpdate.setBounds(480, 124, 100, 24);
		panel.add(btnUpdate);

		JButton btnSearch = new JButton("查找学生");
		btnSearch.setBounds(590, 124, 100, 24);
		panel.add(btnSearch);

		JButton btnReset = new JButton("重置数据");
		btnReset.setBounds(700, 124, 100, 24);
		panel.add(btnReset);

		// ===== 表格显示面板 =====
		JPanel panel_table = new JPanel();
		panel_table.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"学生信息列表", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_table.setBounds(10, 370, 876, 430);
		frame.getContentPane().add(panel_table);
		panel_table.setLayout(null);

		// 表格列（10个字段）
		Object[] columns = {"学号", "姓名", "性别", "年龄", "班级", "出生日期", "政治面貌", "电话", "宿舍", "地址"};
		Table table = new Table(columns);
		model = table.getModel();
		JScrollPane scrollPane = table.getScrollPane();
		scrollPane.setBounds(10, 20, 856, 400);
		panel_table.add(scrollPane);

		// ===== 绑定事件 =====
		bindEvents(btnAdd, btnDelete, btnUpdate, btnSearch, btnReset);
	}

	/**
	 * 绑定所有按钮事件
	 */
	private void bindEvents(JButton btnAdd, JButton btnDelete, JButton btnUpdate, JButton btnSearch, JButton btnReset) {

		// ---------- 增加学生 ----------
		btnAdd.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText().trim();
				String age = textField_age.getText().trim();
				String grade = textField_grade.getText().trim();
				String num = textField_num.getText().trim();
				String birthdate = textField_birthdate.getText().trim();
				String pa = textField_pa.getText().trim();
				String address = textField_address.getText().trim();
				String telephone = textField_telephone.getText().trim();
				String dorm = textField_dorm.getText().trim();

				String gender = getSelectedGender();

				// 校验必填字段（学号、姓名、性别、年龄、班级为必填）
				if ("".equals(num)) {
					Tools.shoeMessage("请输入学号");
					return;
				}
				if ("".equals(name)) {
					Tools.shoeMessage("请输入姓名");
					return;
				}
				if (gender == null) {
					Tools.shoeMessage("请选择性别");
					return;
				}
				if ("".equals(age)) {
					Tools.shoeMessage("请输入年龄");
					return;
				}
				if ("".equals(grade)) {
					Tools.shoeMessage("请输入班级");
					return;
				}

				// 构造完整Student对象
				Student student = new Student(num, name, gender, age, grade,
						birthdate.isEmpty() ? null : birthdate,
						pa.isEmpty() ? null : pa,
						address.isEmpty() ? null : address,
						telephone.isEmpty() ? null : telephone,
						dorm.isEmpty() ? null : dorm);

				int res = new StudentDao().addStudent(student);
				if (res == 1) {
					Tools.shoeMessage("添加成功");
					refreshTable();  // 刷新表格
					clearInputFields(); // 清空输入框
				} else {
					Tools.shoeMessage("添加失败，请检查学号是否重复");
				}
			}
		});

		// ---------- 删除学生 ----------
		btnDelete.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				String condition = textField_search.getText().trim();
				if ("".equals(condition)) {
					Tools.shoeMessage("请输入要删除学生的学号");
					return;
				}
				// 确认删除对话框
				int confirm = JOptionPane.showConfirmDialog(frame,
						"确定要删除学号为 " + condition + " 的学生吗？",
						"删除确认", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					int res = new StudentDao().deleteStudent(condition);
					if (res == 1) {
						Tools.shoeMessage("删除成功");
						refreshTable();
						clearInputFields();
					} else {
						Tools.shoeMessage("删除失败，学号不存在");
					}
				}
			}
		});

		// ---------- 修改学生 ----------
		btnUpdate.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText().trim();
				String age = textField_age.getText().trim();
				String grade = textField_grade.getText().trim();
				String num = textField_num.getText().trim();
				String birthdate = textField_birthdate.getText().trim();
				String pa = textField_pa.getText().trim();
				String address = textField_address.getText().trim();
				String telephone = textField_telephone.getText().trim();
				String dorm = textField_dorm.getText().trim();
				String conditionNum = textField_search.getText().trim();

				String gender = getSelectedGender();

				if ("".equals(num)) {
					Tools.shoeMessage("请输入学号");
					return;
				}
				if ("".equals(name)) {
					Tools.shoeMessage("请输入姓名");
					return;
				}
				if (gender == null) {
					Tools.shoeMessage("请选择性别");
					return;
				}
				if ("".equals(age)) {
					Tools.shoeMessage("请输入年龄");
					return;
				}
				if ("".equals(grade)) {
					Tools.shoeMessage("请输入班级");
					return;
				}
				if ("".equals(conditionNum)) {
					Tools.shoeMessage("请输入要更改的【学号】");
					return;
				}

				Student student = new Student(num, name, gender, age, grade,
						birthdate.isEmpty() ? null : birthdate,
						pa.isEmpty() ? null : pa,
						address.isEmpty() ? null : address,
						telephone.isEmpty() ? null : telephone,
						dorm.isEmpty() ? null : dorm);

				int a = new StudentDao().updateStudent(student, conditionNum);
				if (a == 1) {
					Tools.shoeMessage("更改成功");
					refreshTable();
					clearInputFields();
				} else {
					Tools.shoeMessage("更改失败，请检查原学号是否存在");
				}
			}
		});

		// ---------- 查找学生 ----------
		btnSearch.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				String conditionNum = textField_search.getText().trim();

				if (!"".equals(conditionNum)) {
					// 按学号精确查询
					Student student = new StudentDao().getStudentByNum(conditionNum);
					if (student != null) {
						// 回显数据到输入框
						textField_num.setText(student.getNum());
						textField_name.setText(student.getName());
						textField_age.setText(student.getAge());
						textField_grade.setText(student.getGrade());
						textField_birthdate.setText(student.getBirthdate() != null ? student.getBirthdate() : "");
						textField_pa.setText(student.getPa() != null ? student.getPa() : "");
						textField_address.setText(student.getAddress() != null ? student.getAddress() : "");
						textField_telephone.setText(student.getTelephone() != null ? student.getTelephone() : "");
						textField_dorm.setText(student.getDorm() != null ? student.getDorm() : "");

						if (student.getGender() != null && "男".equals(student.getGender())) {
							rdbtnMale.setSelected(true);
						} else if (student.getGender() != null && "女".equals(student.getGender())) {
							rdbtnFemale.setSelected(true);
						} else {
							rdbtnAll.setSelected(true);
						}

						// 表格显示该学生
						try {
							Tools.addTableData(model, student);
						} catch (IllegalAccessException ex) {
							ex.printStackTrace();
						}
					} else {
						Tools.shoeMessage("未找到该学号的学生");
						refreshTable(); // 刷新显示全部
					}
				} else {
					// 条件模糊查询
					String name = textField_name.getText().trim();
					String age = textField_age.getText().trim();
					String grade = textField_grade.getText().trim();
					String num = textField_num.getText().trim();
					String birthdate = textField_birthdate.getText().trim();
					String pa = textField_pa.getText().trim();
					String address = textField_address.getText().trim();
					String telephone = textField_telephone.getText().trim();
					String dorm = textField_dorm.getText().trim();
					String gender = getSelectedGender();

					// 如果所有条件都为空，查询全部
					if (name.isEmpty() && age.isEmpty() && grade.isEmpty() && num.isEmpty() &&
							birthdate.isEmpty() && pa.isEmpty() && address.isEmpty() &&
							telephone.isEmpty() && dorm.isEmpty() &&
							(gender == null || gender.isEmpty())) {
						refreshTable();
					} else {
						// 条件查询
						Student student = new Student(num, name, gender, age, grade,
								birthdate.isEmpty() ? null : birthdate,
								pa.isEmpty() ? null : pa,
								address.isEmpty() ? null : address,
								telephone.isEmpty() ? null : telephone,
								dorm.isEmpty() ? null : dorm);
						try {
							List<Student> list = new StudentDao().getStudentCondition(student);
							Tools.addTableData(model, list);
						} catch (IllegalAccessException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		// ---------- 重置数据 ----------
		btnReset.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				clearInputFields();
				refreshTable();
			}
		});
	}

	/**
	 * 获取选中的性别
	 */
	private String getSelectedGender() {
		if (rdbtnMale.isSelected()) {
			return "男";
		} else if (rdbtnFemale.isSelected()) {
			return "女";
		} else if (rdbtnAll.isSelected()) {
			return "";  // "全部" 表示不限制性别
		}
		return null;
	}

	/**
	 * 刷新表格（显示所有学生）
	 */
	private void refreshTable() {
		try {
			List<Student> list = new StudentDao().getStudentAll();
			Tools.addTableData(model, list);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空所有输入框
	 */
	private void clearInputFields() {
		textField_name.setText("");
		textField_age.setText("");
		textField_grade.setText("");
		textField_num.setText("");
		textField_search.setText("");
		textField_birthdate.setText("");
		textField_pa.setText("");
		textField_address.setText("");
		textField_telephone.setText("");
		textField_dorm.setText("");
		rdbtnAll.setSelected(true);
	}
}