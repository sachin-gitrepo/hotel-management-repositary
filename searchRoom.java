import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;


public class searchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JButton add,back;
    JTable table;
    searchRoom(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,740,540);
        panel.setBackground(new ColorUIResource(3,45,48));
        add(panel);

        JLabel searchForRoom=new JLabel("---SEARCH FOR ROOM---");
        searchForRoom.setBounds(250,11,186,31);
        searchForRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        searchForRoom.setForeground(Color.white);
        panel.add(searchForRoom);

        JLabel roombed=new JLabel("Room Bed Type");
        roombed.setBounds(20,73,150,17);
        roombed.setFont(new Font("Tahoma",Font.BOLD,14));
        roombed.setForeground(Color.white);
        panel.add(roombed);

        JLabel room = new JLabel("Room no.");
        room.setBounds(23,162,150,20);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        JLabel availability = new JLabel("Availability");
       availability.setBounds(175,162,150,20);
       availability.setForeground(Color.WHITE);
       availability.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(availability);

       JLabel clean = new JLabel("Clean Status");
       clean.setBounds(306,162,150,20);
       clean.setForeground(Color.WHITE);
       clean.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(clean);

       JLabel price = new JLabel("Price");
       price.setBounds(458,162,150,20);
       price.setForeground(Color.WHITE);
       price.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(price);

       JLabel bed = new JLabel("Bed Type");
       bed.setBounds(580,162,150,20);
       bed.setForeground(Color.WHITE);
       bed.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(bed);
        
       
       
        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,250,25);
        checkBox.setFont(new Font("Tahoma",Font.BOLD,14));
        checkBox.setForeground(Color.white);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single");
        choice.add("Double");
        choice.setBounds(170,70,120,20);
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,250);
        table.setForeground(Color.white);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try {
            connection conn= new connection();
            String query="select * from room";
            ResultSet rs=conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();;
        }


        
        add=new JButton("SEARCH");
        add.setBounds(200,450,120,30);
        add.setFont(new Font("Tahoma",Font.PLAIN,20));
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("BACK");
        back.setBounds(380,450,120,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize(750,550);
        setLocation(500,100);
        setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==add){
        String q="select * from room  where bed_type='"+choice.getSelectedItem()+"'";
        String q1="select * from room  where availability='Available' AND bed_type='"+choice.getSelectedItem()+"'";
        try {
            connection conn= new connection();
            ResultSet rs=conn.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

            if(checkBox.isSelected()){
                ResultSet rs2=conn.statement.executeQuery(q1);
                table.setModel(DbUtils.resultSetToTableModel(rs2));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
       }
       else{
        setVisible(false);
       }
    }
    public static void main(String[] args) {
        new searchRoom();
    }
   
}
