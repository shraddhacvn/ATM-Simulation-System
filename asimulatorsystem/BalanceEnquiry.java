package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalanceEnquiry(String pin) 
    {
        super("BALANCE ENQUIRY");
        this.pin = pin;
        
        l1 = new JLabel();
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        b1 = new JButton("BACK");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(190, 350, 400, 35);
        add(l1);

        b1.setBounds(390, 633, 150, 35);
        add(b1);
        
        int balance = 0;
        try
        {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) 
            {
                if (rs.getString("mode").equals("Deposit")) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(960, 1080);
        setLocation(500,90);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    public static void main(String[] args) 
    {
        new BalanceEnquiry("").setVisible(true);
    }
}

