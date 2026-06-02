package com.student.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


        //实现窗口居中
public class Tools {

    public static void setPos(JFrame jFrame, int width, int height) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int x = (int)screenSize.getWidth()/2 - width/2;
        int y = (int)screenSize.getHeight()/2 - height/2;
        jFrame.setBounds(x,y,width,height);
    }

    //封装弹窗的方法
    public static void shoeMessage(String message) {
        JOptionPane.showMessageDialog(null,message,"提示消息",JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null,"密码不能为空","注册消息",JOptionPane.WARNING_MESSAGE);

    }
    public <T> void addTableData(DefaultTableModel model,T t){

    }



}
