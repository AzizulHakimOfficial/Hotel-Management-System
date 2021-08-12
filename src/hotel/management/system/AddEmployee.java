
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2;
    ButtonGroup bt1;
    AddEmployee(){
        
        l1=new JLabel("NAME");
        l1.setBounds(30,20,80,20);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(140,20,130,20);
        add(t1);
        
        l2=new JLabel("AGE");
        l2.setBounds(30,60,80,20);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(140,60,130,20);
        add(t2);
        
        l3=new JLabel("GENDER");
        l3.setBounds(30,100,80,20);
        add(l3);
        
        bt1=new ButtonGroup();
        
        r1=new JRadioButton("Male");
        r1.setBounds(140,100,60,20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(200,100,70,20);
        r2.setBackground(Color.white);
        add(r2);
        
        bt1.add(r1);
        bt1.add(r2);
        
        l4=new JLabel("JOB");
        l4.setBounds(30,140,80,20);
        add(l4);
        
        String str[]={"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Services","Waiter/Waitress","Manager","Accountant"};
        c1=new JComboBox(str);
        c1.setBounds(140,140,130,20);
        c1.setBackground(Color.white);
        add(c1);
        
        l5=new JLabel("SALARY");
        l5.setBounds(30,180,80,20);
        add(l5);
        
        t3=new JTextField();
        t3.setBounds(140,180,130,20);
        add(t3);
        
        l6=new JLabel("PHONE");
        l6.setBounds(30,220,80,20);
        add(l6);
        
        t4=new JTextField();
        t4.setBounds(140,220,130,20);
        add(t4);
        
        l7=new JLabel("NID");
        l7.setBounds(30,260,80,20);
        add(l7);
        
        t5=new JTextField();
        t5.setBounds(140,260,130,20);
        add(t5);
        
        l8=new JLabel("EMAIL");
        l8.setBounds(30,300,80,20);
        add(l8);
        
        t6=new JTextField();
        t6.setBounds(140,300,130,20);
        add(t6);
        
        l9= new JLabel("ADD EMPLOYEE DETAILS");
        l9.setBounds(320,20,400,50);
        l9.setFont(new Font("tahoma",Font.PLAIN,30));
        l9.setForeground(Color.blue);
        add(l9);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image img1=img.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        l10=new JLabel(img2);
        l10.setBounds(300,50,400,380);
        add(l10);
        
        b1=new JButton("Submit");
        b1.setBounds(70,360,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(195,360,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(325,150,730,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
            String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String nid=t5.getText();
        String email=t6.getText();
        
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        }
        String job=(String)c1.getSelectedItem();
        
        conn c=new conn();
        String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+nid+"','"+email+"')";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New Employee Added");
            this.setVisible(false);
        }catch(Exception e){
        }
       }else if(ae.getSource()==b2){
           this.setVisible(false);
       }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
}
