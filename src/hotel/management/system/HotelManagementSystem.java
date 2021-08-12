
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);
        
        JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(10, 420, 1000, 90);
        l2.setFont(new Font("serif",Font.PLAIN,70));
        l2.setForeground(Color.white);
        l1.add(l2);
        
        JButton b1=new JButton("Next");
        b1.setBounds(1100, 450, 150, 40);
        b1.setFont(new Font("serif",Font.PLAIN,27));
        b1.setBackground(Color.yellow);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        l1.add(b1);
        
        
        
        setLayout(null);
        setBounds(0,100,1366,565);
        setVisible(true);
        while(true){
        l2.setVisible(false);
        try{
            Thread.sleep(500);
        }catch(Exception e){
            l2.setVisible(true);
        }
        l2.setVisible(true);
        try{
            Thread.sleep(500);
        }catch(Exception e){
        }
    }
    }
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
