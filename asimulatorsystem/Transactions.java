package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;

public class Transactions extends JFrame implements ActionListener 
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Transactions(String pin)
    { 
        super("TRANSACTION");
        this.pin = pin;
        
        l1 = new JLabel("----Please Select Your Transaction-----");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 24));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CASH WITHDRAWAL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(200,100,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b4.setBounds(40,360,300,60);
        add(b4);
        
        b5.setBounds(40,470,300,60);
        add(b5);
        
        b6.setBounds(440,360,300,60);
        add(b6);
        
        b7.setBounds(440,470,300,60);
        add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,800);
        setLocation(500,90);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        { 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource()==b2)
        { 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if(ae.getSource()==b4)
        { 
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()==b5)
        { 
            setVisible(false);
            new Pin(pin).setVisible(true);
        }
        else if(ae.getSource()==b6)
        { 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource()==b7)
        { 
            System.exit(0);
        }
        
    }
    public static void main(String[] args)
    {
        new Transactions("").setVisible(true);
    }
}




  
