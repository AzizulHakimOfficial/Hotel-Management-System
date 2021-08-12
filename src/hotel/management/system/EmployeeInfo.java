
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    EmployeeInfo(){
        
        l1=new JLabel("Name");
        l1.setBounds(50,10,60,20);
        add(l1);
        
        l2=new JLabel("Age");
        l2.setBounds(160,10,60,20);
        add(l2);
        
        l3=new JLabel("Gender");
        l3.setBounds(250,10,60,20);
        add(l3);
        
        l4=new JLabel("Job");
        l4.setBounds(360,10,100,20);
        add(l4);
        
        l5=new JLabel("Salary");
        l5.setBounds(460,10,70,20);
        add(l5);
        
        l6=new JLabel("Phone");
        l6.setBounds(560,10,70,20);
        add(l6);
        
        l7=new JLabel("NID");
        l7.setBounds(660,10,70,20);
        add(l7);
        
        l8=new JLabel("Email");
        l8.setBounds(760,10,100,20);
        add(l8);
        
        t1=new JTable();
        t1.setBounds(13,40,820,400);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(180,450,120,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(380,450,120,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("print");
        b3.setBounds(580,450,120,35);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(250,150,860,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c= new conn();
            String str="select * from employee";
            ResultSet rs=c.s.executeQuery(str);
           t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3){
           MessageFormat header= new MessageFormat("Report Print");
           MessageFormat footer= new MessageFormat("Page{0,number,integer}");
           try{
               t1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
           }catch(java.awt.print.PrinterException e){
               System.err.format("Cannot Print %s%n",e.getMessage());
           }
        }
    }
    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
