
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class PickupService extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;
    JTable t1;
    Choice c1;
    PickupService(){
        
        l1=new JLabel("PICKUP SERVICE");
        l1.setBounds(275,0,250,30);
        l1.setFont(new Font("tahoma",Font.PLAIN,26));
        add(l1);
        
        l2=new JLabel("Car Brand:");
        l2.setBounds(60,45,80,30);
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            String str="select * from driver";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("car_brand"));
            }
        }catch(Exception e){}
        
        c1.setBounds(150,49,120,30);
        c1.setBackground(Color.white);
        c1.setForeground(Color.black);
        add(c1);
        
        l3=new JLabel("Driver Name");
        l3.setBounds(40,95,100,20);
        add(l3); 
        
        l4=new JLabel("Age");
        l4.setBounds(170,95,50,20);
        add(l4);
        
        l5=new JLabel("Gender");
        l5.setBounds(260,95,60,20);
        add(l5);
        
        l6=new JLabel("Car Company");
        l6.setBounds(335,95,80,20);
        add(l6);
        
        l7=new JLabel ("Car Brand");
        l7.setBounds(440,95,100,20);
        add(l7);
        
        l8=new JLabel ("Availability");
        l8.setBounds(540,95,100,20);
        add(l8);
        
        l9=new JLabel ("Location");
        l9.setBounds(640,95,80,20);
        add(l9);
        
        t1=new JTable();
        t1.setBounds(30,125,685,300);
        add(t1);
        
        b1=new JButton("Display");
        b1.setBounds(230,450,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(425,450,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(310,150,760,545);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
            conn c=new conn();
            String str="select * from driver where car_brand='"+c1.getSelectedItem()+"'";
               ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new PickupService();
    }
}
