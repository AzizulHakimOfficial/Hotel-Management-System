
package hotel.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class PreCustomerList extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2,b3;
    JDateChooser c1,c2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JCheckBox cb1;
    PreCustomerList(){
        
        l11 =new JLabel("CHECK OUT DATE:");
        l11.setBounds(30,2,170,30);
        l11.setFont(new Font("tahoma",Font.BOLD,18));
        add(l11);
        
        l12 =new JLabel("FROM:");
        l12.setBounds(220,10,50,30);
        add(l12);
        
        c1=new JDateChooser();
        c1.setBounds(260,13,120,25);
       add(c1);
        
        l13 =new JLabel("TO:");
        l13.setBounds(418,10,40,30);
        add(l13);
        
        c2=new JDateChooser();
        c2.setBounds(440,13,120,25);
       add(c2);
       
       cb1=new JCheckBox("Only Show list in given Range");
        cb1.setBounds(600,10,190,30);
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.black);
        add(cb1);
       
        l1=new JLabel("ID");
        l1.setBounds(50,70,20,20);
        add(l1);
        
        l2=new JLabel("Number");
        l2.setBounds(100,70,60,20);
        add(l2);
        
        l3=new JLabel("Name");
        l3.setBounds(185,70,50,20);
        add(l3);
        
        l4=new JLabel("Gender");
        l4.setBounds(255,70,70,20);
        add(l4);
        
        l5=new JLabel("Country");
        l5.setBounds(330,70,60,20);
        add(l5);
        
        l6=new JLabel("Room");
        l6.setBounds(410,70,60,20);
        add(l6);
        
        l7=new JLabel("Checked In");
        l7.setBounds(480,70,80,20);
        add(l7);
        
        l8=new JLabel("CheckIn");
        l8.setBounds(555,70,80,20);
        add(l8);
        l9=new JLabel("CheckOut");
        l9.setBounds(620,70,80,20);
        add(l9);
        
        l10=new JLabel("Day");
        l10.setBounds(710,70,40,20);
        add(l10);
        
        l14=new JLabel("Facility");
        l14.setBounds(775,70,80,20);
        add(l14);
        
        l15=new JLabel("Deposit");
        l15.setBounds(845,70,80,20);
        add(l15);
        
        t1=new JTable();
        t1.setBounds(13,95,900,360);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(180,460,120,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(380,460,120,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("print");
        b3.setBounds(580,460,120,35);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(210,140,940,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            ResultSet rs;
           
            
            try{
                 
                conn c= new conn();
                String str="select * from checkout";

                if(cb1.isSelected()){
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String date=sdf.format(c1.getDate());
            String date1=sdf.format(c2.getDate());
            String str1="select * from checkout where checkout_date between '"+date+"' and '"+date1+"'";
                    rs=c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs=c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch(Exception e){
               }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }else if(ae.getSource()==b3){
           MessageFormat header= new MessageFormat("Checked Out Customer Information");
           MessageFormat footer= new MessageFormat("Page{0,number,integer}");
           try{
               t1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
           }catch(java.awt.print.PrinterException e){
               System.err.format("Cannot Print %s%n",e.getMessage());
           }
        }
    }
    public static void main(String[] args) {
        new PreCustomerList();
    }
}
