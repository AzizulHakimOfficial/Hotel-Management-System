
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JRadioButton r1,r2;
    JComboBox c1;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    ButtonGroup bt1;
    AddDriver(){
        l1=new JLabel("ADD DRIVER DETAILS");
        l1.setBounds(70,15,300,25);
        l1.setFont(new Font("tahoma",Font.PLAIN,25));
        add(l1);
        
        l2=new JLabel("NAME");
        l2.setBounds(35,70,120,25);
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(190,70,140,25);
        add(t1);
        
        l3=new JLabel("AGE");
        l3.setBounds(35,112,120,25);
        add(l3);
        
        t2=new JTextField();
        t2.setBounds(190,110,140,25);
        add(t2);
        
        l4=new JLabel("GENDER");
        l4.setBounds(35,152,120,25);
        add(l4);
        bt1=new ButtonGroup();
        
        r1=new JRadioButton("Male");
        r1.setBounds(190,150,60,25);
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(260,150,70,25);
        r2.setBackground(Color.white);
        add(r2);
        bt1.add(r1);
        bt1.add(r2);
        
        l5=new JLabel("CAR COMPANY");
        l5.setBounds(35,192,120,25);
        add(l5);
        
        t3=new JTextField();
        t3.setBounds(190,190,140,25);
        add(t3);
        
        l6=new JLabel("CAR BRAND");
        l6.setBounds(35,232,120,25);
        add(l6);
        
        t4=new JTextField();
        t4.setBounds(190,230,140,25);
        add(t4);
        
        l7=new JLabel("AVAILABLE");
        l7.setBounds(35,272,120,25);
        add(l7);
        
        String str1[]={"Available","Busy"};
        c1=new JComboBox(str1);
        c1.setBounds(190,270,140,25);
        c1.setBackground(Color.white);
        add(c1);
        
        l8=new JLabel("LOCATION");
        l8.setBounds(35,312,120,25);
        add(l8);
        
        t5=new JTextField();
        t5.setBounds(190,310,140,25);
        add(t5);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image img2=img1.getImage().getScaledInstance(400, 295, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l9=new JLabel(img3);
        l9.setBounds(360,55,400,295);
        add(l9);
        
        b1=new JButton("Add Driver");
        b1.setBounds(85,360,100,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(220,360,100,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(280,150,820,480);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name=t1.getText();
            String age=t2.getText();
            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else if(r2.isSelected()){
                gender="Female";
            }
            String company=t3.getText();
            String brand=t4.getText();
            String available=(String)c1.getSelectedItem();
            String location=t5.getText();
        
        conn c=new conn();
        try{
            String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New Driver Added");
            this.setVisible(false);
        }catch(Exception e){
        }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
