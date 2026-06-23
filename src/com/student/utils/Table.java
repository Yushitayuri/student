package com.student.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//实现用表格显示内容
public class Table {

    JTable table=null;
    JScrollPane scrollPane=null;
    DefaultTableModel model=null;
    public Table(Object[] columns){
        if(model==null){
            table=new JTable();
            model=new DefaultTableModel(){
                //创建匿名类
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
            model.setColumnIdentifiers(columns);
            table.setModel(model);
            table.getTableHeader().setReorderingAllowed(false);
            table.getTableHeader().setResizingAllowed(false);
            scrollPane=new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        }
    }
    public JScrollPane getScrollPane(){
        return scrollPane;
    }
    public DefaultTableModel getModel(){
        return model;
    }
}
