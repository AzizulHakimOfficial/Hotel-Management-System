
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class RoomDetails extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
        JTable t1;
        JButton b1,b2;
    RoomDetails(){
        
        l2=new JLabel ("Room Number");
        l2.setBounds(18,10,100,20);
        add(l2); 
        
        l3=new JLabel("Availability");
        l3.setBounds(130,10,100,20);
        add(l3);
        
        l4=new JLabel ("Status");
        l4.setBounds(240,10,80,20);
        add(l4);
        
        l5=new JLabel ("Price");
        l5.setBounds(345,10,80,20);
        add(l5);
        
        l6=new JLabel ("Bed Type");
        l6.setBounds(435,10,100,20);
        add(l6);
        
        t1=new JTable();
        t1.setBounds(10,40,500,400);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(110,450,120,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(260,450,120,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image img2=img1.getImage().getScaledInstance(305, 300, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l1=new JLabel(img3);
        l1.setBounds(515,30,355,380);
        add(l1);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(250,150,880,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            conn c=new conn();
            try{

            String str="select * from room";
            ResultSet rs=c.s.executeQuery(str);
           t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
            }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new RoomDetails();
    }
}
