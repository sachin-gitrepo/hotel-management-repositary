import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;

public class customerInfo extends JFrame {
    JTable table;
    customerInfo(){
         JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new ColorUIResource(3,45,48));
        add(panel);

         table=new JTable();
        table.setBounds(10,40,900,450);
        table.setForeground(Color.white);
        table.setBackground(new Color(3,45,48));
        panel.add(table);


          try {
            connection conn= new connection();
            String query="select * from customerInfo";
            ResultSet rs=conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();;
        }

            JLabel id=new JLabel("ID");
            id.setBounds(31,11,46,15);
             id.setFont(new Font("Tahoma",Font.BOLD,15));
             id.setForeground(Color.white);
             panel.add(id); 

             JLabel number=new JLabel("NUMBER");
             number.setBounds(140,11,90,16);
             number.setFont(new Font("Tahoma",Font.BOLD,15));
             number.setForeground(Color.white);
              panel.add(number);

              JLabel name=new JLabel("NAME");
              name.setBounds(250,11,60,16);
              name.setFont(new Font("Tahoma",Font.BOLD,15));
              name.setForeground(Color.white);
               panel.add(name);

               JLabel gender=new JLabel("GENDER");
               gender.setBounds(360,11,100,16);
               gender.setFont(new Font("Tahoma",Font.BOLD,15));
               gender.setForeground(Color.white);
                panel.add(gender);

                JLabel country=new JLabel("COUNTRY");
                country.setBounds(470,11,100,25);
                country.setFont(new Font("Tahoma",Font.BOLD,15));
                country.setForeground(Color.white);
                 panel.add(country); 

                 JLabel room=new JLabel("ROOM");
                 room.setBounds(580,11,100,16);
                 room.setFont(new Font("Tahoma",Font.BOLD,15));
                 room.setForeground(Color.white);
                  panel.add(room); 

                  JLabel check=new JLabel("CHECK IN");
                  check.setBounds(690,11,100,16);
                  check.setFont(new Font("Tahoma",Font.BOLD,15));
                  check.setForeground(Color.white);
                   panel.add(check); 

                   JLabel amount=new JLabel("DEPOSIT");
                   amount.setBounds(800,11,100,25);
                   amount.setFont(new Font("Tahoma",Font.BOLD,15));
                   amount.setForeground(Color.white);
                    panel.add(amount); 

                    JButton back=new JButton("Back");
                    back.setBounds(450,510,120,30);
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
        setSize(900,600);
        setLocation(300,100);
        setVisible(true);

    }
        public static void main(String[] args) {
            new customerInfo();
        }
}
