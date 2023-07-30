package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener{
    
        JLabel l1,l2;
	JButton b1, b2,b3;
	JPanel p1,p2;
	JPasswordField pf;
	JTextField tf;
	Font f,f1;
    
    AdminSection(){
        super("Admin Section");
        setLocation(100,100);
        setSize(400,270);
        
        l1 = new  JLabel("Admin Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);
        
        b1 = new JButton("Add Accountant");
        b2 = new JButton("View Accountant");
        b3 = new JButton("Logout Admin");
        
        b1.addActionListener(this);
         b2.addActionListener(this);
          b3.addActionListener(this);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("FeeReportManagement/icon/focus.png"));
        Image img2 = img.getImage().getScaledInstance(100,100 ,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        l2 = new JLabel(img3);
        
         f = new Font("Arial", Font.BOLD,20);
         f1 = new Font("Arial", Font.BOLD,15);
         
         l1.setFont(f);
         b1.setFont(f1);
         b2.setFont(f1);
         b3.setFont(f1);
         
         p1 = new JPanel();
         p1.setLayout(new GridLayout(4,1,10,10));
         p1.add(l1);
         p1.add(b1);
         p1.add(b2);
         p1.add(b3);
         
         p2 = new JPanel();
         p2.setLayout(new GridLayout(1,1,10,10));
         p2.add(l2);
         
         
         setLayout(new BorderLayout(10,10));
         add(p1,"Center");
         add(p2,"East");
    }
    public void actionPerformed(ActionEvent e){
          if(e.getSource()==b1){
              new AddAccountant().setVisible(true);
          }
          if(e.getSource()==b2){
              new ViewAccountant().setVisible(true);
          }
          if(e.getSource()==b3){
              this.setVisible(false);
              new index().setVisible(true);
          }
    }
    public static void main(String[] args){
        new AdminSection().setVisible(true);
    }
}
