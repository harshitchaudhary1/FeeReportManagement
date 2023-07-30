package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Accountant extends JFrame implements ActionListener {

    JLabel l1, l2, l3; // Fixed: Declared separate label objects for l1, l2, and l3.
    JButton b1, b2;
    JPanel p1, p2;
    Font f, f1;
    JTextField tf;
    JPasswordField pf;

    Accountant() {
        super("Accountant Page");
        setLocation(100, 200);
        setSize(500, 200);

        l1 = new JLabel("Accountant Login"); // Fixed: Initialized l1.
        l2 = new JLabel("Name"); // Fixed: Initialized l2.
        l3 = new JLabel("Password"); // Fixed: Initialized l3.

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);

        tf = new JTextField();
        pf = new JPasswordField();

        b1 = new JButton("Login");
        b2 = new JButton("Cancel");

        b1.addActionListener(this);
        b2.addActionListener(this);

        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 15);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        b1.setFont(f1);
        b2.setFont(f1);
        tf.setFont(f1);
        pf.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2, 10, 10));
        p2.add(l2);
        p2.add(tf);
        p2.add(l3);
        p2.add(pf);
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(0, 0));

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
    }

   public void actionPerformed(ActionEvent e){
        String n1 =tf.getText();
        String pass =pf.getText();
        if(e.getSource()==b1){
            try{
                ConnectionClass obj = new ConnectionClass();
                String q = "select * from accountant where name='"+n1+"'and password  = '"+pass+"' ";
                ResultSet rest =obj.stm.executeQuery(q);
                if(rest.next()){
                    
                    new AccountantSection().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your ID and Password are Wrong");
                    this.setVisible(false);
                }
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
        }
        if(e.getSource()==b2){
             this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Accountant accountant = new Accountant();
        accountant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountant.setVisible(true);
    }
}
