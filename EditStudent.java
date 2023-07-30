package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    Choice ch;
    
    EditStudent(){
        super("Student");
        setLocation(100,100);
        setSize(450,650);
        
        f= new Font("Arial",Font.BOLD,20);
        f1= new Font("Arial",Font.BOLD,15);
        
        ch=new Choice();
        try{
            ConnectionClass obj=new ConnectionClass();
            String q ="Select rollno from add_student";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch.add(rest.getString("rollno"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
         l1 = new JLabel("Edit Student");
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
        l13 = new JLabel("Roll No");
        
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
        
        b1=new JButton("Edit Student");
        b2=new JButton("Back<<");
        
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
        l13.setFont(f1);
        
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
        p2.setLayout(new GridLayout(13,2,10,10));
        p2.add(l13);
        p2.add(ch);
        
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
        
        ch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                try{
                    ConnectionClass obj1 = new ConnectionClass();
                    int rn=Integer.parseInt(ch.getSelectedItem());
                String q1= "select * from add_student where rollno='"+rn+"'";
                ResultSet rest1 =obj1.stm.executeQuery(q1);
                while(rest1.next()){
                    tf1.setText(rest1.getString("name"));
                    tf2.setText(rest1.getString("email"));
                    tf3.setText(rest1.getString("course"));
                    tf4.setText(rest1.getString("fee"));
                    tf5.setText(rest1.getString("paid"));
                    tf6.setText(rest1.getString("due"));
                    tf7.setText(rest1.getString("address"));
                    tf8.setText(rest1.getString("city"));
                    tf9.setText(rest1.getString("state"));
                    tf10.setText(rest1.getString("country"));
                    tf11.setText(rest1.getString("contact"));
                    
                }
                }
                catch(Exception eee){
                    eee.printStackTrace();
                }
            }
        }); 
    }
     public void actionPerformed(ActionEvent e){
         
         int roll=Integer.parseInt(ch.getSelectedItem());
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
                ConnectionClass obj2 = new ConnectionClass();
                String q= "update add_student set name='"+name+"' ,email='"+email+"',course='"+course+"',fee='"+fee+"',paid='"+paid+"',due= '"+due+"',address='"+address+"',city='"+city+"',state='"+state+"',country='"+country+"',contact='"+con+"'where rollno='"+roll+"'";
                int aa = obj2.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showMessageDialog(null,"your data successfully updated");
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
         new EditStudent().setVisible(true);
     }
}
