package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Addstudent extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    
    Addstudent(){
        super("Add Student");
        setLocation(100,100);
        setSize(450,350);
        
        f= new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);
        
        l1 = new JLabel("Add Student");
        l2 = new JLabel("Name");
        l3 = new JLabel("Email");
        l4 = new JLabel("Course");
        l5 = new JLabel("Fee");
        l6 = new JLabel("Paid");
        l7 = new JLabel("Due");
        l8 = new JLabel("Address");
        l9 = new JLabel("City");
        l10 = new JLabel("State");
        l11 = new JLabel("Country");
        l12 = new JLabel("Contact No");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        tf8=new JTextField();
        tf9=new JTextField();
        tf10=new JTextField();
        tf11=new JTextField();
        
        b1= new JButton("Add Student");
        b2= new JButton("Back<<");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);
        
          b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);


        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);
        tf10.setFont(f1);
        tf11.setFont(f1);
        
        b1.setFont(f1);
        b2.setFont(f1);
        
          p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
          p2 = new JPanel();
        p2.setLayout(new GridLayout(12,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        
        p2.add(l7);
        p2.add(tf6);
        p2.add(l8);
        p2.add(tf7);
        p2.add(l9);
        p2.add(tf8);
        p2.add(l10);
        p2.add(tf9);
        p2.add(l11);
        p2.add(tf10);
        p2.add(l12);
        p2.add(tf11);
        p2.add(b1);
        p2.add(b2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        
    }
    
    public void actionPerformed(ActionEvent e){
        String name = tf1.getText();
        String email= tf2.getText();
        String course=tf3.getText();
        float fee = Float.parseFloat(tf4.getText());
        float paid = Float.parseFloat(tf5.getText());
        float due = Float.parseFloat(tf6.getText());
        String address=tf7.getText();
        String city=tf8.getText();
        String state=tf9.getText();
        String country=tf10.getText();
        String con=tf11.getText();
        
        if(e.getSource()==b1){
            try{
                ConnectionClass obj = new ConnectionClass();
                String q= "insert into add_student(name,email,course,fee,paid,due,address,city,state,country,contact) values('"+name+"','"+email+"','"+course+"','"+fee+"','"+paid+"','"+due+"','"+address+"','"+city+"','"+state+"','"+country+"','"+con+"')";
                int aa = obj.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showMessageDialog(null,"your data inserted");
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"please ! fill all details carefully");
                }
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            this.setVisible(false);
            new AccountantSection().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Addstudent().setVisible(true);
    }
}
