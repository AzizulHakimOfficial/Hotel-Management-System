
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener{
     JLabel l1,l2,l3,l4,l5;
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3;
    CheckOut(){
        l1=new JLabel("Check Out");
        l1.setBounds(80,15,270,25);
        l1.setFont(new Font("tahoma",Font.PLAIN,25));
        add(l1);
        
        l2=new JLabel("Customer ID");
        l2.setBounds(15,75,100,30);
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
        c1.setBounds(150,78,150,30);
        add(c1);
        
        l3=new JLabel("Room Number");
        l3.setBounds(15,135,100,30);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(150,135,150,30);
        add(t1);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image img2=img.getImage().getScaledInstance(330, 230, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l4=new JLabel(img3);
        l4.setBounds(370,20,330,230);
        add(l4);
        
        ImageIcon img4=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image img5=img4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon img6=new ImageIcon(img5);
        b1 =new JButton(img6);
        b1.setBounds(310,77,25,25);
        b1.addActionListener(this);
        add(b1);
        
         b2=new JButton("CheckOut");
        b2.setBounds(60,200,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Back");
        b3.setBounds(200,200,100,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(320,150,740,310);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            conn c=new conn();
             String id=c1.getSelectedItem();
            try{      
                String room="select * from customer where number='"+id+"'";
                ResultSet rs=c.s.executeQuery(room);
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                }
                
        }catch(Exception e){}
        }else if(ae.getSource()==b2){
            conn c=new conn();
             String number=c1.getSelectedItem();
             String room=t1.getText();
             String pending=null;
             String deposit=null;
             String id=null;
             String name=null;
             String gender=null;
             String country=null;
             String status=null;
             String day=null;
             String checkin_date=null;
             String checkout_date=null;
             String facility=null;
             java.util.Date date=new java.util.Date();
            java.sql.Date checkout_dat= new java.sql.Date(date.getTime());
             try{
                 String cusinfo="select * from customer where number='"+number+"'";
                ResultSet rs1=c.s.executeQuery(cusinfo);
                while(rs1.next()){
                   id=rs1.getString("id");
                   name=rs1.getString("name");
                   gender=rs1.getString("gender");
                   country=rs1.getString("country");
                   status=rs1.getString("status");
                   day=rs1.getString("day");
                   checkin_date=rs1.getString("checkin_date");
                   checkout_date=rs1.getString("checkout_date");
                   facility=rs1.getString("facility");
                   
                }
                 
                 String str6="select * from pendingstatus where number='"+number+"' and room='"+room+"'";
                 ResultSet rs=c.s.executeQuery(str6);
                 while(rs.next()){
                     pending=rs.getString("pendingamount");
                     deposit=rs.getString("deposit");
                 }
                 int check=Integer.parseInt(pending);
                 if(check==0){
                     String str3="insert into checkout(id,number,name,gender,country,room,status,day,checkin_date,checkout_date,facility,deposit) values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+day+"','"+checkin_date+"','"+checkout_date+"','"+facility+"','"+deposit+"')";
                     c.s.executeUpdate(str3);
                 String str4="update checkout set checkout_date='"+checkout_dat+"',status='No' where number='"+number+"'";
                 c.s.executeUpdate(str4);
                 String str1="delete from customer where number='"+number+"' and room='"+room+"'";
                 c.s.executeUpdate(str1);
                 String str2="update room set available='Available' where room_number='"+room+"'";
                c.s.executeUpdate(str2);
                String str5="delete from pendingstatus where number='"+number+"' and room='"+room+"'";
                c.s.executeUpdate(str5);
                JOptionPane.showMessageDialog(null, "CheckOut succesfully");
                 new Reception().setVisible(true);
                this.setVisible(false);
                 }else{
                     JOptionPane.showMessageDialog(null, "Checkout Not Possible.please pay your pending amount first!!");
                 }
             }catch(Exception e){
             }
        }else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new CheckOut();
    }
}
