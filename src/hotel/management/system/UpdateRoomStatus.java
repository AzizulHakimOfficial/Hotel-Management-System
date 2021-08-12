
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateRoomStatus extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3;
    
    UpdateRoomStatus(){
        
        l1=new JLabel("Update Room Status");
        l1.setBounds(80,15,270,25);
        l1.setFont(new Font("tahoma",Font.PLAIN,25));
        add(l1);
        
        l2=new JLabel("Customer ID");
        l2.setBounds(15,70,100,25);
        add(l2);
        
        c1 =new Choice();
        try{
            conn c=new conn();
            String str="select * from customer";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            } 
        }catch(Exception e){   
        }
        c1.setBounds(150,70,150,30);
        add(c1);
        
        l3=new JLabel("Room Number");
        l3.setBounds(15,120,100,25);
        add(l3);
        
        t1 =new JTextField();
        t1.setBounds(150,115,150,30);
        add(t1);
        
        l4=new JLabel("Availability");
        l4.setBounds(15,170,100,25);
        add(l4);
        
        t2 =new JTextField();
        t2.setBounds(150,165,150,30);
        add(t2);
        
        l5=new JLabel("Clean Status");
        l5.setBounds(15,220,100,25);
        add(l5);
        
        t3 =new JTextField();
        t3.setBounds(150,215,150,30);
        add(t3);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image img2=img.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l5=new JLabel(img3);
        l5.setBounds(330,30,450,300);
        add(l5);
        
        b1=new JButton("Check");
        b1.setBounds(25,290,80,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Update");
        b2.setBounds(125,290,80,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Back");
        b3.setBounds(225,290,80,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(290,150,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String id=c1.getSelectedItem();
            conn c= new conn();
            try{
                String str="select * from customer where number='"+id+"'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                t1.setText(rs.getString("room"));
                String room=rs.getString("room");
            String str1="select * from room where room_number='"+room+"'";
            ResultSet rs1=c.s.executeQuery(str1);
            while(rs1.next()){
             t2.setText(rs1.getString("available"));
            t3.setText(rs1.getString("status"));
            }
            }
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            String room=t1.getText();
            String available=t2.getText();
            String status=t3.getText();
            try{
                conn c=new conn();
                String str1="update room set available = '"+available+"' , status = '"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Update Room Status");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
            
        }else if(ae.getSource()==b3){
            new Reception().setVisible(true);
                this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateRoomStatus();
    }
}
