
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class DepartmentDetails extends JFrame implements ActionListener{
    JLabel l1,l2;
    JButton b1,b2;
    JTable t1;
    DepartmentDetails(){
        
        l1=new JLabel("Department");
        l1.setBounds(180,5,120,30);
        l1.setFont(new Font("tahoma",Font.PLAIN,18));
        add(l1);
        
        l2=new JLabel("Budget (Taka)");
        l2.setBounds(500,5,120,30);
        l2.setFont(new Font("tahoma",Font.PLAIN,18));
        add(l2);
        
        t1=new JTable();
        t1.setBounds(15,40,710,300);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(230,350,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(425,350,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(310,150,760,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            conn c= new conn();
        try{
            String str="select * from department";
            ResultSet rs=c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){}
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new DepartmentDetails();
    }
}
