
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class CustomerPendingStatus extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    JTable t1;
    CustomerPendingStatus(){
        
        l1=new JLabel("Customer ID");
        l1.setBounds(40,05,130,30);
        l1.setFont(new Font("default",Font.BOLD,14));
        add(l1);
        
        l2=new JLabel("Customer Name");
        l2.setBounds(160,05,130,30);
        l2.setFont(new Font("default",Font.BOLD,14));
        add(l2);
        
        l3=new JLabel("Room no");
        l3.setBounds(330,05,130,30);
        l3.setFont(new Font("default",Font.BOLD,14));
        add(l3);
        
        l4=new JLabel("Pending Amount");
        l4.setBounds(440,05,130,30);
        l4.setFont(new Font("default",Font.BOLD,14));
        add(l4);
        
         l4=new JLabel("Deposit Amount");
        l4.setBounds(590,05,130,30);
        l4.setFont(new Font("default",Font.BOLD,14));
        add(l4);
        
        t1=new JTable();
        t1.setBounds(10,50,705,340);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(200,395,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
       b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(450,395,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
       getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(320,150,740,480);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            conn c=new conn();
            try{
                String str1="select number,name,room,pendingamount,deposit from pendingstatus";
                ResultSet rs=c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
      new CustomerPendingStatus();
    }
}
