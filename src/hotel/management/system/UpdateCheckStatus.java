
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateCheckStatus extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheckStatus(){
        
        l1=new JLabel("Check-In Details");
        l1.setBounds(80,15,270,25);
        l1.setFont(new Font("tahoma",Font.PLAIN,25));
        add(l1);
        
        l2=new JLabel("Customer ID");
        l2.setBounds(15,70,100,25);
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            String str="select * from customer";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}
        c1.setBounds(150,70,150,30);
        add(c1);

        l3=new JLabel("Room Number");
        l3.setBounds(15,120,100,25);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(150,115,150,30);
        add(t1);
        
        l4=new JLabel("Name");
        l4.setBounds(15,170,100,25);
        add(l4);
        
        t2=new JTextField();
        t2.setBounds(150,165,150,30);
        add(t2);
        
        l5=new JLabel("Check-In");
        l5.setBounds(15,220,100,25);
        add(l5);
        
        t3=new JTextField();
        t3.setBounds(150,215,150,30);
        add(t3);
        
        l6=new JLabel("Amount Paid");
        l6.setBounds(15,270,100,25);
        add(l6);
        
        t4=new JTextField();
        t4.setBounds(150,265,150,30);
        add(t4);
        
        l7=new JLabel("Pending Amount");
        l7.setBounds(15,320,100,25);
        add(l7);
        
        t5=new JTextField();
        t5.setBounds(150,315,150,30);
        add(t5);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image img2=img.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l8=new JLabel(img3);
        l8.setBounds(330,60,450,300);
        add(l8);
        
        b1=new JButton("Check");
        b1.setBounds(25,380,80,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Update");
        b2.setBounds(125,380,80,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Back");
        b3.setBounds(225,380,80,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(290,150,800,480);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String number=c1.getSelectedItem();
            try{
                String room=null;
                int AmountPainding;
                String deposit=null;
                 String price=null;
              conn c=new conn();
            String str1="select * from customer where number = '"+number+"'";
            ResultSet rs1=c.s.executeQuery(str1);
            while(rs1.next()){
                t3.setText(rs1.getString("status"));
                t1.setText(rs1.getString("room"));
                t2.setText(rs1.getString("name"));
                room=rs1.getString("room");
            }
            String str2="select * from pendingstatus where room = '"+room+"' and number= '"+number+"'";
            ResultSet rs2=c.s.executeQuery(str2);
            while(rs2.next()){
                t4.setText(rs2.getString("deposit"));
                t5.setText(rs2.getString("pendingamount"));
            }
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            String id=c1.getSelectedItem();
            String room=t1.getText();
            String name=t2.getText();
            String status=t3.getText();
            String amountPaid=t4.getText();
            String price=null;
            String depo=null;
            int pay,full;
            conn c=new conn();
            try{
                String str5="select * from pendingstatus where room = '"+room+"' and number= '"+id+"'";
            ResultSet rs2=c.s.executeQuery(str5);
            while(rs2.next()){
                price=rs2.getString("pendingamount");
                depo=rs2.getString("deposit");
            }
             if(Integer.parseInt(amountPaid)>=Integer.parseInt(price)){
                 pay=Integer.parseInt(amountPaid)-Integer.parseInt(price);            
                    Integer.toString(pay);
             }else{
                  pay=Integer.parseInt(price)-Integer.parseInt(amountPaid);            
                    Integer.toString(pay);
             }
             full=Integer.parseInt(amountPaid)+Integer.parseInt(depo);
                    String str4="update pendingstatus set room='"+room+"',name='"+name+"',pendingamount='"+pay+"',deposit='"+full+"' where number='"+id+"' and room='"+room+"'";
                    c.s.executeUpdate(str4);
                 String str3="update customer set room='"+room+"',name='"+name+"',status='"+status+"' where number ='"+id+"'";
                 String str6="update checkout set room='"+room+"',name='"+name+"',status='"+status+"' where number ='"+id+"'";
                c.s.executeUpdate(str3);
                c.s.executeUpdate(str6);
                JOptionPane.showMessageDialog(null,"Check-In Details Update successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
            
        }else if(ae.getSource()==b3){
            new Reception().setVisible(true);
                this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateCheckStatus();
    }
}
