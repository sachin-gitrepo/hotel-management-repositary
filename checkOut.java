import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class checkOut extends JFrame{
    JButton checkout,check,back;
    checkOut(){

        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,805,405);
        panel1.setBackground(new Color(0,0,0));
        panel1.setLayout(null);
        add(panel1);

         JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,795,395);
        panel.setBackground(new Color(247,182,141));
        panel1.add(panel);

         JLabel label1=new JLabel("check-Out");
        label1.setBounds(100,20,200,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images\\goodbye.gif"));
        Image img1=i1.getImage().getScaledInstance(340,425,Image.SCALE_DEFAULT);
       ImageIcon image1=new ImageIcon(img1);
       JLabel label2 =new JLabel(image1);
       label2.setBounds(480,-10,340,425);
       label2.setBackground(Color.GRAY);
       panel.add(label2);

        JLabel customerId=new JLabel("Customer-Id :");
        customerId.setBounds(30,80,200,25);
        customerId.setFont(new Font("Tahoma",Font.BOLD,20));
        customerId.setForeground(Color.BLACK);
        panel.add(customerId);

        Choice customer=new Choice();
        customer.setBounds(240,80,150,25);
        panel.add(customer);

        JLabel roomNo=new JLabel("Room Number :");
        roomNo.setBounds(30,130,200,30);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,20));
        roomNo.setForeground(Color.BLACK);
        panel.add(roomNo);

        JLabel labelroomNo=new JLabel();
        labelroomNo.setBounds(240,130,100,30);
        labelroomNo.setFont(new Font("Tahoma",Font.BOLD,20));
        labelroomNo.setForeground(Color.BLACK);
        panel.add(labelroomNo);

        JLabel checkIntime=new JLabel("Check-In Time :");
        checkIntime.setBounds(30,180,200,30);
        checkIntime.setFont(new Font("Tahoma",Font.BOLD,20));
        checkIntime.setForeground(Color.BLACK);
        panel.add(checkIntime);

        JLabel labelcheckIntime=new JLabel();
        labelcheckIntime.setBounds(240,180,250,30);
        labelcheckIntime.setFont(new Font("Tahoma",Font.BOLD,15));
        labelcheckIntime.setForeground(Color.BLACK);
        panel.add(labelcheckIntime);

        JLabel checkOuttime=new JLabel("Check-Out Time :");
        checkOuttime.setBounds(30,230,200,30);
        checkOuttime.setFont(new Font("Tahoma",Font.BOLD,20));
        checkOuttime.setForeground(Color.BLACK);
        panel.add(checkOuttime);

        Date date=new Date();

        JLabel labelcheckOuttime=new JLabel(""+date);
        labelcheckOuttime.setBounds(240,230,250,30);
        labelcheckOuttime.setFont(new Font("Tahoma",Font.BOLD,15));
        labelcheckOuttime.setForeground(Color.BLACK);
        panel.add(labelcheckOuttime);

        try {
            connection conn = new connection();
            ResultSet rs=conn.statement.executeQuery("select * from customerInfo");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
         } catch (Exception e) {
            e.printStackTrace();
         }

         checkout=new JButton("CHECK-OUT");
         checkout.setBounds(30,300,120,30);
         checkout.setFont(new Font("Tahoma",Font.PLAIN,13));
         checkout.setForeground(Color.white);
         checkout.setBackground(Color.BLACK);
         checkout.addActionListener(new ActionListener(){
 
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 try {
                     connection conn = new connection();
                    
                    conn.statement.executeUpdate("delete from customerInfo where number='"+customer.getSelectedItem()+"'");
                    conn.statement.executeUpdate("update room set availability='Available' where room_no='"+labelroomNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"checked out Successfully");
                    setVisible(false);
                 }
                 catch(Exception e2){
                       e2.printStackTrace();
                 }
             }
             
         });
         panel.add(checkout);
 
         back=new JButton("BACK");
         back.setBounds(170,300,110,30);
         back.setFont(new Font("Tahoma",Font.PLAIN,20));
         back.setForeground(Color.white);
         back.setBackground(Color.BLACK);
         back.addActionListener(new ActionListener(){
 
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
             }
             
         });
         panel.add(back);
 
         check=new JButton("CHECK");
         check.setBounds(300,300,110,30);
         check.setFont(new Font("Tahoma",Font.PLAIN,20));
         check.setForeground(Color.white);
         check.setBackground(Color.BLACK);
         check.addActionListener(new ActionListener() {
 
             @Override
             public void actionPerformed(ActionEvent e) {
                 String id=customer.getSelectedItem();
                 String query="select * from customerInfo where number='"+id+"'";
 
                 try {
                     connection conn= new connection();
                     ResultSet rs=conn.statement.executeQuery(query);
                     while(rs.next()){
                       
                         labelcheckIntime.setText(rs.getString("checkInTime"));
                         labelroomNo.setText(rs.getString("room"));
                     }
                    
 
                 } catch (Exception e1) {
                     e1.printStackTrace();;
                 }
 
             }
             
         });
         panel.add(check);
 




         setUndecorated(true);
        setLayout(null);
        setSize(805,405);
        setLocation(400,100);
        setVisible(true);

    }
    public static void main(String[] args) {
        new checkOut();
    }

}
