package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    
    Withdrawl(String pin)
    {
        super("WITHDRAWAL");
        this.pin = pin;
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("IS RS.10,000");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(220,100,600,35);
        add(l1);
        
        l2.setBounds(330,150,600,35);
        add(l2);
        
        l3.setBounds(300,250,600,24);
        add(l3);
        
        t1.setBounds(250,300,350,40);
        add(t1);
        
        b1.setBounds(250,450,150,60);
        add(b1);
        
        b2.setBounds(450,450,150,60);
        add(b2);
        
        b3.setBounds(350,550,150,60);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setSize(850,850);
        setLocation(500,90);
        setVisible(true);        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {        
            String amount = t1.getText();
            //Date date = new Date();
            if(ae.getSource()==b1)
            {
                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }
                else
                {
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next())
                    {
                       if(rs.getString("mode").equals("Deposit"))
                       {
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else
                       {
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount))
                    {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', 'Current Date', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(ae.getSource()==b2)
            {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            else if(ae.getSource()==b3)
            {
                System.exit(0);
            }
        }
        catch(Exception e)
        {
                e.printStackTrace();
                System.out.println("error: "+e);
        }    
    }
    public static void main(String[] args)
    {
        new Withdrawl("").setVisible(true);
    } 
}





