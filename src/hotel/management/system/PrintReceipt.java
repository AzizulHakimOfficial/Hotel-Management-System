
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class PrintReceipt extends JFrame implements ActionListener{
    JButton b1,b2;
    JLabel l1;
    Choice c1;
    JTextArea area;
    PrintReceipt(){
        l1=new JLabel("Customer ID:");
        l1.setBounds(30,5,100,30);
        add(l1);
        
        c1=new Choice();
        c1.setBounds(130,8,120,30);
        try{
            conn c= new conn();
            String str="select number from customer";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}
        add(c1);

        area=new JTextArea();
        area.setBounds(10,40,365,480);
        area.setLayout(null);
        add(area);
        
        b1=new JButton("Generate Bill");
        b1.setBounds(70,535,110,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Print Bill");
        b2.setBounds(220,535,110,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        setBounds(650,80,400,620);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()==b1){
            String name=null;
            String gender=null;
            String country=null;
            String room=null;
            String day=null;
            String facility=null;
            String checkin_date=null;
            String pendingamount=null;
            String deposit=null;
            String roomcharge=null;
            String foodcharge=null;
            String gymcharge=null;
            String swimcharge=null;
            String servicecharge=null;

            try{
                conn c=new conn();
                ResultSet rs,rs2;
                
                String str="select * from customer where number='"+c1.getSelectedItem()+"'";
                rs=c.s.executeQuery(str);
                while(rs.next()){
                    name=rs.getString("name");
                    gender=rs.getString("gender");
                    country=rs.getString("country");
                    room=rs.getString("room");
                    day=rs.getString("day");
                    facility=rs.getString("facility");
                    checkin_date=rs.getString("checkin_date");
                }
                
                String str1="select * from pendingstatus where number='"+c1.getSelectedItem()+"' and room='"+room+"'";
                rs=c.s.executeQuery(str1);
                while(rs.next()){
                    pendingamount=rs.getString("pendingamount");
                    deposit=rs.getString("deposit");
                    roomcharge=rs.getString("roomcharge");
                    foodcharge=rs.getString("foodcharge");
                    gymcharge=rs.getString("gymcharge");
                    swimcharge=rs.getString("swimcharge");
                    servicecharge=rs.getString("servicecharge");
                    
                }
            }catch(Exception e){}
            java.util.Date date=new java.util.Date();
            java.sql.Date checkout_dat= new java.sql.Date(date.getTime());
            
             area.append("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
             +"\t                Hotel The Infinity\n"
             +"* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
             +"\t              Customer Information\n"
             +"-------------------------------------------------------------------------------------------\n"
             +"   Customer ID\t\t: "+c1.getSelectedItem()+"\n"
             +"   Customer Name\t: "+name+"\n"
             +"   Gender\t\t: "+gender+"\n"
             +"   Country\t\t: "+country+"\n"
             +"   Room\t\t: "+room+"\n"
             +"   Day\t\t: "+day+"\n"
             +"   Facility\t\t: "+facility+"\n"
             +"   Check-in Date\t\t: "+checkin_date+"\n"
             +"   Check-out Date\t: "+checkout_dat+"\n"
             +"* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
             +"\t\tCharges\n"
             +"-------------------------------------------------------------------------------------------\n"
             +"   Room Charge for "+day+" days \t=  "+roomcharge+"\n"
             +"   Food Charge for "+day+" days \t=  "+foodcharge+"\n"
             +"   Gym Charge\t\t=  "+gymcharge+"\n"
             +"   Swimming Pool Charge \t=  "+swimcharge+"\n");
            int subtotal=Integer.parseInt(roomcharge)+Integer.parseInt(foodcharge)+Integer.parseInt(gymcharge)+Integer.parseInt(swimcharge);
             area.append("   Sub-Total \t\t=  "+Integer.toString(subtotal)+"\n"
             +"   Service Charge 5%(Including VAT) =  "+servicecharge+"\n");
            int grandtotal=subtotal+Integer.parseInt(servicecharge);
             area.append("   Grand Total \t\t=  "+Integer.toString(grandtotal)+"\n"
             +"   Payment \t\t=  "+deposit+"\n"
             +"   Due \t\t=  "+pendingamount+"\n"
             +"* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
             +"\tThank You for Visiting Our Hotel The Infinity\n"
             +"* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        }else if(ae.getSource()==b2){
           try{
                area.print();
                JOptionPane.showMessageDialog(null,"Receipt Print Successfully");
                this.setVisible(false);
           }catch(Exception e){}
        }
    }
    public static void main(String[] args) {
        new PrintReceipt();
    }
}
