
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class AddNewCustomer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JButton b1,b2;
    JRadioButton r1,r2;
    JComboBox c1;
    JTextField t1,t2,t3,t4,t5;
    Choice co1;
    ButtonGroup bt1;
    JCheckBox cb1;
    AddNewCustomer(){
        l1=new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(80,15,270,25);
        l1.setFont(new Font("tahoma",Font.PLAIN,25));
        add(l1);
        
        l2=new JLabel("ID");
        l2.setBounds(35,70,170,25);
        add(l2);
        
        String str1[]={"Nid Card","Passport","Driving License"};
        c1=new JComboBox(str1);
        c1.setBounds(240,70,140,25);
        c1.setBackground(Color.white);
        add(c1);
        
        l3=new JLabel("Customer ID");
        l3.setBounds(35,112,170,25);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(240,110,140,25);
        add(t1);
        
        l4=new JLabel("NAME");
        l4.setBounds(35,152,170,25);
        add(l4);
        
        t2=new JTextField();
        t2.setBounds(240,150,140,25);
        add(t2);
        
        l5=new JLabel("GENDER");
        l5.setBounds(35,192,170,25);
        add(l5);
        bt1=new ButtonGroup();
        r1=new JRadioButton("Male");
        r1.setBounds(240,190,60,25);
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(310,190,70,25);
        r2.setBackground(Color.white);
        add(r2);
        
        bt1.add(r1);
        bt1.add(r2);
        
        l6=new JLabel("COUNTRY");
        l6.setBounds(35,232,170,25);
        add(l6);
        
        t3=new JTextField();
        t3.setBounds(240,230,140,25);
        add(t3);
        
        l7=new JLabel("ALLOCATED ROOM NUMBER");
        l7.setBounds(35,272,170,25);
        add(l7);
        
        co1=new Choice();
        try{
            conn c=new conn();
            String str="select * from room where available='Available'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                co1.add(rs.getString("room_number"));
            }
        }catch(Exception e){
        }
        co1.setBounds(240,270,140,25);
        add(co1);
            
            
        l8=new JLabel("CHECKED IN");
        l8.setBounds(35,352,170,25);
        add(l8);
        
        t4=new JTextField();
        t4.setBounds(240,350,140,25);
        add(t4);
        
        l9=new JLabel("DAY");
        l9.setBounds(35,312,170,25);
        add(l9);
        
        t5=new JTextField();
        t5.setBounds(240,310,140,25);
        add(t5);
        
        l11=new JLabel("INCLUDING FACILITIES");
        l11.setBounds(35,392,170,25);
        add(l11);
        
        cb1=new JCheckBox("Food,Gym,Swimming pool");
        cb1.setBounds(230,395,200,20);
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.black);
        add(cb1);
        
        
        b1=new JButton("Add Customer");
        b1.setBounds(110,440,120,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(260,440,120,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fith.jpg"));
        Image img2=img1.getImage().getScaledInstance(300, 470, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l10=new JLabel(img3);
        l10.setBounds(410,10,300,470);
        add(l10);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,140,760,540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String id=(String)c1.getSelectedItem();
            String customerId=t1.getText();
            String name=t2.getText();
            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else if(r2.isSelected()){
                gender="Female";
            }
            String country=t3.getText();
            String room=co1.getSelectedItem();
            String status=t4.getText();
            String day=t5.getText();
            String price=null;

            Date date=new Date();
     
            java.sql.Date checkin_date= new java.sql.Date(date.getTime());
            conn c=new conn();
                
                try{
                    int deposit=0;
                    if(cb1.isSelected()){
                        int food=3000;
                        int gym=2000;
                        int swim=2000;
                        String facility=cb1.getActionCommand();
                String str1="insert into customer (id,number,name,gender,country,room,status,day,checkin_date,facility) values('"+id+"','"+customerId+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+day+"','"+checkin_date+"','"+facility+"')";
                c.s.executeUpdate(str1);
                String str2= "update room set available='Occupied' where room_number='"+room+"'";
                c.s.executeUpdate(str2);
                String str3="select price from room where room_number='"+room+"'";
                ResultSet rs=c.s.executeQuery(str3);
                while(rs.next()){
                    price=rs.getString("price");
                }
                int foodcharge=Integer.parseInt(day)*food;
                int roomcharge=(Integer.parseInt(price)*Integer.parseInt(day));
                int subtotal=roomcharge+foodcharge+swim+gym;
                int servicecharge=(subtotal/100)*5;
                int pending=subtotal+servicecharge;
                  Integer.toString(pending);
                String str4="insert into pendingstatus values('"+customerId+"','"+name+"','"+room+"','"+pending+"','"+deposit+"','"+roomcharge+"','"+foodcharge+"','"+gym+"','"+swim+"','"+servicecharge+"')";
                c.s.executeUpdate(str4);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
                    }else{
                        
                        int food=0;
                        int gym=0;
                        int swim=0;
                        
                String str1="insert into customer (id,number,name,gender,country,room,status,day,checkin_date) values('"+id+"','"+customerId+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+day+"','"+checkin_date+"')";
                c.s.executeUpdate(str1);
                String str2= "update room set available='Occupied' where room_number='"+room+"'";
                c.s.executeUpdate(str2);
                String str3="select price from room where room_number='"+room+"'";
                ResultSet rs=c.s.executeQuery(str3);
                while(rs.next()){
                    price=rs.getString("price");
                }
                int foodcharge=Integer.parseInt(day)*food;
                int roomcharge=(Integer.parseInt(price)*Integer.parseInt(day));
                int subtotal=roomcharge+foodcharge+swim+gym;
                int servicecharge=(subtotal/100)*5;
                int pending=subtotal+servicecharge;
                  Integer.toString(pending);
                String str4="insert into pendingstatus values('"+customerId+"','"+name+"','"+room+"','"+pending+"','"+deposit+"','"+roomcharge+"','"+foodcharge+"','"+gym+"','"+swim+"','"+servicecharge+"')";
                c.s.executeUpdate(str4);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
                    }
                }catch(Exception e){
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new AddNewCustomer();
    }
}
