
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JComboBox c1;
    JTable t1;
    JCheckBox cb1;
    SearchRoom(){
        
        l1=new JLabel("SEARCH FOR ROOM");
        l1.setBounds(275,0,250,30);
        l1.setFont(new Font("tahoma",Font.PLAIN,26));
        add(l1);
        
        l2=new JLabel("Room Bed Type:");
        l2.setBounds(30,45,100,30);
        add(l2);
        
        c1=new JComboBox(new String[]{"Single Bed","Double Bed","VVIP Bed","King Bed"});
        c1.setBounds(140,45,120,30);
        c1.setBackground(Color.white);
        c1.setForeground(Color.black);
        add(c1);
        
        cb1=new JCheckBox("Only Display Available Room");
        cb1.setBounds(500,45,190,30);
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.black);
        add(cb1);
        
        l3=new JLabel("Room Number");
        l3.setBounds(60,95,100,20);
        add(l3); 
        
        l4=new JLabel("Availability");
        l4.setBounds(200,95,100,20);
        add(l4);
        
        l5=new JLabel("Status");
        l5.setBounds(360,95,80,20);
        add(l5);
        
        l6=new JLabel("Price");
        l6.setBounds(500,95,80,20);
        add(l6);
        
        l7=new JLabel ("Bed Type");
        l7.setBounds(620,95,100,20);
        add(l7);
        
        t1=new JTable();
        t1.setBounds(30,125,685,300);
        add(t1);
        
        b1=new JButton("Search");
        b1.setBounds(230,450,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(425,450,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(310,150,760,545);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                ResultSet rs;
            conn c=new conn();
            String str="select * from room where bed_type='"+c1.getSelectedItem()+"'";
            String str1="select * from room where bed_type='"+c1.getSelectedItem()+"'and available='Available'";
            if(cb1.isSelected()){
                rs=c.s.executeQuery(str1);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }else{
                rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
