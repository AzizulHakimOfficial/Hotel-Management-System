
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t1;
    JPasswordField f1;
    JLabel l1,l2,l3;
    Login(){
        l1=new JLabel("Username");
        l1.setBounds(20, 20, 100, 40);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(150,25,150,30);
        add(t1);
        
        l2=new JLabel("Password");
        l2.setBounds(20, 70, 100, 50);
        add(l2);
        
        f1=new JPasswordField();
        f1.setBounds(150,80,150,30);
        add(f1);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image img2=img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l3=new JLabel(img3);
        l3.setBounds(350,50,200,200);
        add(l3);
        
       b1=new JButton("Login");
        b1.setBounds(20,160,120,40);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(180,160,120,40);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(400,150,600,340);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
           String username=t1.getText();
           String password=f1.getText();
           conn c=new conn();
           String str ="select * from login where username = '"+username+"' and password = '"+password+"'";
           try{
               ResultSet rs=c.s.executeQuery(str);
               if(rs.next()){
                   new Dashboard().setVisible(true);
                   this.setVisible(false);
               }else{
            JOptionPane.showMessageDialog(null, "Invalid Username And Password!");
            this.setVisible(false);
        }
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
