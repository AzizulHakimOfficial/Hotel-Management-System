
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    JLabel l1;
    Reception(){
        b1=new JButton("New Customer Form");
        b1.setBounds(30,10,160,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Room Details");
        b2.setBounds(30,50,160,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Department Details");
        b3.setBounds(30,90,160,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        
        b4=new JButton("All Employee Info");
        b4.setBounds(30,130,160,30);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);
        
        b5=new JButton("Customer Info");
        b5.setBounds(30,170,160,30);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        add(b5);
        
        b6=new JButton("Manager Info");
        b6.setBounds(30,210,160,30);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        add(b6);
        b7=new JButton("Check Out");
        b7.setBounds(30,250,160,30);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        add(b7);
        
        b8=new JButton("Update Check Status");
        b8.setBounds(30,290,160,30);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.addActionListener(this);
        add(b8);
        b9=new JButton("Update Room Status");
        b9.setBounds(30,330,160,30);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.addActionListener(this);
        add(b9);
        b10=new JButton("Pick Up Service");
        b10.setBounds(30,370,160,30);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.addActionListener(this);
        add(b10);
        b11=new JButton("Search Room");
        b11.setBounds(30,410,160,30);
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.addActionListener(this);
        add(b11);
        b12=new JButton("Log Out");
        b12.setBounds(30,450,160,30);
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.addActionListener(this);
        add(b12);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        Image img2=img1.getImage().getScaledInstance(500, 470, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l1=new JLabel(img3);
        l1.setBounds(230,10,500,470);
        add(l1);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,150,780,535);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddNewCustomer().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b2){
            new RoomDetails().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3){
            new DepartmentDetails().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b4){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b5){
          new CustomerInfo().setVisible(true);
           this.setVisible(false);
        }else if(ae.getSource()==b6){
            new ManagerInfo().setVisible(true);
             this.setVisible(false);
        }else if(ae.getSource()==b7){
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b8){
            new UpdateCheckStatus().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b9){
            new UpdateRoomStatus().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b10){
            new PickupService().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b11){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b12){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
