package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewAccountant extends JFrame{
    String x[]= {"Name","password","Email","Contact no","Address"};
    
    String y[][]= new String[20][5];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    
    ViewAccountant(){
        super("Customer Information");
        setSize(800,400);
        setLocation(1,1);
        f= new Font("MS UI Gothic",Font.BOLD,15);
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from accountant";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]= rest.getString("name");
                y[i][j++]= rest.getString("password");
                y[i][j++]= rest.getString("email");
                y[i][j++]= rest.getString("contact");
                y[i][j++]= rest.getString("address");
                i++;
                j=0;
            }
            t= new JTable(y,x);
            t.setFont(f);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        add(sp);
    }
    public static void main(String[] args){
        new ViewAccountant().setVisible(true);
    }
    
}
