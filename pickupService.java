import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;

public class pickupService extends JFrame {
    JTable table;
    JButton display,back;

    pickupService(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,590);
        panel.setBackground(new ColorUIResource(3,45,48));
        add(panel);

          JLabel pservice=new JLabel("---Pick Up Service---");
          pservice.setBounds(250,21,300,30);
          pservice.setFont(new Font("Tahoma",Font.BOLD,20));
        pservice.setForeground(Color.white);
        panel.add(pservice);
 
        JLabel carType=new JLabel("Type Of Car");
        carType.setBounds(32,97,89,25);
        carType.setFont(new Font("Tahoma",Font.PLAIN,14));
        carType.setForeground(Color.white);
      panel.add(carType);

      Choice choice = new Choice();
      choice.setBounds(123,94,150,25);
      panel.add(choice);
   
      try {
            connection conn= new connection();
            String query="select * from driver";
            ResultSet rs=conn.statement.executeQuery(query);
            while(rs.next()){
                choice.add(rs.getString("carname"));
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }

        table=new JTable();
        table.setBounds(10,190,800,250);
        table.setForeground(Color.white);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try {
            connection conn= new connection();
            String query="select * from driver";
            ResultSet rs=conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();;
        }

        
        
        JLabel name=new JLabel("NAME");
        name.setBounds(25,160,60,25);
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        name.setForeground(Color.white);
         panel.add(name);

         JLabel age=new JLabel("AGE");
         age.setBounds(150,160,60,25);
        age.setFont(new Font("Tahoma",Font.BOLD,15));
        age.setForeground(Color.white);
         panel.add(age);

         JLabel gender=new JLabel("GENDER");
         gender.setBounds(240,160,100,25);
         gender.setFont(new Font("Tahoma",Font.BOLD,15));
         gender.setForeground(Color.white);
          panel.add(gender);

            
        JLabel compony=new JLabel("COMPONY");
        compony.setBounds(360,160,150,25);
        compony.setFont(new Font("Tahoma",Font.BOLD,15));
        compony.setForeground(Color.white);
         panel.add(compony);

          JLabel carname=new JLabel("CAR NAME");
          carname.setBounds(485,160,150,25);
          carname.setFont(new Font("Tahoma",Font.BOLD,15));
          carname.setForeground(Color.white);
           panel.add(carname);

           JLabel available=new JLabel("AVAILABLE");
           available.setBounds(590,160,150,25);
           available.setFont(new Font("Tahoma",Font.BOLD,15));
           available.setForeground(Color.white);
            panel.add(available);

            JLabel location=new JLabel("LOCATION");
            location.setBounds(690,160,150,25);
            location.setFont(new Font("Tahoma",Font.BOLD,15));
            location.setForeground(Color.white);
             panel.add(location);


        display=new JButton("DISPLAY");
        display.setBounds(200,500,120,30);
        display.setFont(new Font("Tahoma",Font.PLAIN,20));
        display.setForeground(Color.white);
        display.setBackground(Color.BLACK);
        panel.add(display);
        display.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from driver where carname='"+choice.getSelectedItem()+"'";
                try {
                    connection conn= new connection();
                    ResultSet rs=conn.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            
        });

        back=new JButton("BACK");
        back.setBounds(450,500,120,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 setVisible(false);
            }
            
        });
        panel.add(back);




        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
         }

         public static void main(String[] args) {
            new pickupService();
         }
}
