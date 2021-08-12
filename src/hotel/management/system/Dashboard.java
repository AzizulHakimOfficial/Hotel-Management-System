
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2,m3;
    JMenuItem i1,i2,i3,i4,i5,i6,i7,i8;
    Dashboard(){
        mb=new JMenuBar();
        add(mb);
        
        m1=new JMenu("Hotel Management");
        m1.setForeground(Color.red);
        mb.add(m1);
        
        m2=new JMenu("Admin");
        m2.setForeground(Color.blue);
        mb.add(m2);
        
        m3=new JMenu("Print Menu");
        m3.setForeground(Color.red);
        mb.add(m3);
        
        i1=new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2=new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3=new JMenuItem("Add Room");
        i3.addActionListener(this);
        m2.add(i3);       
        
        i4=new JMenuItem("Add Driver");
        i4.addActionListener(this);
        m2.add(i4);
        
        i5=new JMenuItem("Previous Customer list");
        i5.addActionListener(this);
        m3.add(i5);
        
        i6=new JMenuItem("Customer Pending Details");
        i6.addActionListener(this);
        m3.add(i6);
        
        i7=new JMenuItem("Income");
        i7.addActionListener(this);
        m3.add(i7);
        i8=new JMenuItem("Generate & Print Receipt");
        i8.addActionListener(this);
        m3.add(i8);
        
        mb.setBounds(0,0,1770,20);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image img2=img1.getImage().getScaledInstance(1650, 705, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel l1=new JLabel(img3);
        l1.setBounds(0, 20, 1650, 705);
        add(l1);
        
        JLabel l2=new JLabel("Welcome to Hotel the Infinity");
        l2.setBounds(345,30,700,60);
        l2.setFont(new Font("Tahoma",Font.BOLD,46));
        l2.setForeground(Color.darkGray);
        l1.add(l2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Room")){
            new AddRoom().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Driver")){
            new AddDriver().setVisible(true);
        }else if(ae.getActionCommand().equals("Previous Customer list")){
            new PreCustomerList().setVisible(true);
        }else if(ae.getActionCommand().equals("Income")){
            new Income().setVisible(true);
        }else if(ae.getActionCommand().equals("Customer Pending Details")){
            new CustomerPendingStatus().setVisible(true);
        }else if(ae.getActionCommand().equals("Generate & Print Receipt")){
           new PrintReceipt().setVisible(true);
        }
          
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}
