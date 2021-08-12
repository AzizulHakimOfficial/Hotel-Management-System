
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Income extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTable t1;
    Income(){
        
        l1=new JLabel("Total Visited Customer:");
        l1.setBounds(50,20,200,30);
        l1.setFont(new Font("default",Font.BOLD,16));
        add(l1);
        
        l2=new JLabel("Total Income:");
        l2.setBounds(125,60,200,40);
        l2.setFont(new Font("default",Font.BOLD,16));
        add(l2);
        
        l3=new JLabel();
        l3.setBounds(260,20,200,30);
        l3.setFont(new Font("default",Font.BOLD,16));
        add(l3);
        
        l4=new JLabel();
        l4.setBounds(260,60,200,40);
        l4.setFont(new Font("default",Font.BOLD,16));
        add(l4);
        
        l5=new JLabel("Name");
        l5.setBounds(105,110,200,30);
        l5.setFont(new Font("",Font.BOLD,16));
        add(l5);
        
        l6=new JLabel("Country");
        l6.setBounds(325,110,200,30);
        l6.setFont(new Font("",Font.BOLD,16));
        add(l6);
        
        l7=new JLabel("Deposit");
        l7.setBounds(545,110,200,30);
        l7.setFont(new Font("",Font.BOLD,16));
        add(l7);
        
        t1=new JTable();
        t1.setBounds(10,140,665,260);
        t1.setBackground(Color.lightGray);
        add(t1);
        
        b1=new JButton("Enter");
        b1.setBounds(480,45,80,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("default",Font.PLAIN,15));
        b1.addActionListener(this);
        add(b1);
        
         b2=new JButton("Details");
        b2.setBounds(220,410,80,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("default",Font.PLAIN,15));
        b2.addActionListener(this);
        add(b2);
         b3=new JButton("Back");
        b3.setBounds(420,410,80,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setFont(new Font("default",Font.PLAIN,15));
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.white);
        setBounds(335,150,700,500);
        setLayout(null);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
             conn c=new conn();
            try{
                ResultSet rs;
                String str="select count(number),sum(deposit) from checkout";
                rs=c.s.executeQuery(str);
                while(rs.next()){
                    l3.setText(rs.getString("count(number)"));
                    l4.setText(rs.getString("sum(deposit)"));
                }
            }catch(Exception e){}
        }else if(ae.getSource()==b2){
            conn c1=new conn();
             try{
                ResultSet rs1;
                String str="select name,country,deposit from checkout";
                rs1=c1.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs1));
            }catch(Exception e){}
        }else if(ae.getSource()==b3){
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Income();
    }
}
