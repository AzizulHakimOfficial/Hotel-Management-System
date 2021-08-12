
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRoom extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JComboBox c1,c2,c3;
    JTextField t1,t2;
    JButton b1,b2;
    AddRoom(){
        l1=new JLabel("ADD ROOM DETAILS");
        l1.setBounds(70,15,300,30);
        l1.setFont(new Font("tahoma",Font.PLAIN,25));
        add(l1);
        
        l2=new JLabel("ROOM NUMBER");
        l2.setBounds(35,70,120,30);
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(190,70,140,30);
        add(t1);
        
        l3=new JLabel("AVAILABLE");
        l3.setBounds(35,120,120,30);
        add(l3);
        
        String str1 []={"Available","Occupied"};
        c1=new JComboBox(str1);
        c1.setBounds(190,120,140,30);
        c1.setBackground(Color.white);
        add(c1);
        
        l4=new JLabel("CLEANING STATUS");
        l4.setBounds(35,170,120,30);
        add(l4);
        
        String str2 []={"Cleaned","Dirty"};
        c2=new JComboBox(str2);
        c2.setBounds(190,170,140,30);
        c2.setBackground(Color.white);
        add(c2);
        
        l5=new JLabel("PRICE");
        l5.setBounds(35,220,120,30);
        add(l5);
        
        t2=new JTextField();
        t2.setBounds(190,220,140,30);
        add(t2);
        
       l6=new JLabel("BED TYPE");
        l6.setBounds(35,270,120,30);
        add(l6);
        
        String str3 []={"Single Bed","Double Bed","VVIP Bed","King Bed"};
        c3=new JComboBox(str3);
        c3.setBounds(190,270,140,30);
        c3.setBackground(Color.white);
        add(c3);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image img2=img1.getImage().getScaledInstance(400, 310, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l7=new JLabel(img3);
        l7.setBounds(360,40,400,310);
        add(l7);                
        
        b1=new JButton("Add Room");
        b1.setBounds(75,340,100,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(215,340,100,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
                
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(290,150,800,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room=t1.getText();
        String available=(String)c1.getSelectedItem();
        String status=(String)c2.getSelectedItem();
        String price=t2.getText();
        String type=(String)c3.getSelectedItem();
        
        conn c=new conn();
        try{
            String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New Room Added");
            this.setVisible(false);
        }catch(Exception e){
        }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRoom();
    }
}
