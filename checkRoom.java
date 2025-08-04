import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class checkRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    checkRoom(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

    //     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/employees.png"));
    //     Image img1=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    //    ImageIcon image1=new ImageIcon(img1);
    //    JLabel label2 =new JLabel(image1);
    //    label2.setBounds(600,200,200,200);
    //    label2.setOpaque(true);
    //    label2.setBackground(Color.GRAY);
    //    panel.add(label2);


       table= new JTable();
       table.setBounds(10,40,850,400);
       table.setBackground(new Color(3,45,48));
       table.setForeground(Color.WHITE);
       panel.add(table);

       try {
        connection con=new connection();
        String room_info="select * from room";
        ResultSet resultSet=con.statement.executeQuery(room_info);
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
       } catch (Exception e) {
           e.printStackTrace();
       }

       back = new JButton("BACK");
       back.setBounds(200,500,120,30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setFont(new Font("Tahoma",Font.BOLD,15));
       back.addActionListener(this);
       panel.add(back);

       JLabel room = new JLabel("Room no.");
       room.setBounds(12,15,80,19);
       room.setForeground(Color.WHITE);
       room.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(room);
       
       JLabel availability = new JLabel("Availability");
       availability.setBounds(180,15,80,19);
       availability.setForeground(Color.WHITE);
       availability.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(availability);

       JLabel clean = new JLabel("Clean Status");
       clean.setBounds(350,15,150,19);
       clean.setForeground(Color.WHITE);
       clean.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(clean);

       JLabel price = new JLabel("Price");
       price.setBounds(520,15,80,19);
       price.setForeground(Color.WHITE);
       price.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(price);

       JLabel bed = new JLabel("Bed Type");
       bed.setBounds(695,15,80,19);
       bed.setForeground(Color.WHITE);
       bed.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(bed);
        
       setUndecorated(true);
        setLayout(null);
        setLocation(300,80);
        setSize(900,600);
       //getContentPane().setBackground(new Color(27,16,53));
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new checkRoom();
    }
   
}
