import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;

public class employee extends JFrame{
    employee(){

         JPanel panel=new JPanel();
        panel.setBackground(new ColorUIResource(3,45,48));
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        add(panel);

          JTable table =new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new ColorUIResource(4,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
             connection conn=new connection();
            String employee_info = "select * from employee;";
            ResultSet rs=conn.statement.executeQuery(employee_info);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
              e.printStackTrace();
        }

        JButton button=new JButton("Back");
        button.setBounds(300,500,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
            }
            
        });

         JLabel name = new JLabel("Name");
         name.setBounds(41,11,70,19);
       name.setForeground(Color.WHITE);
       name.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(name);
       
       JLabel age = new JLabel("Age");
       age.setBounds(150,11,70,19);
       age.setForeground(Color.WHITE);
       age.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(age);

       JLabel gender = new JLabel("Gender");
       gender.setBounds(273,11,70,19);
       gender.setForeground(Color.WHITE);
       gender.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(gender);

       JLabel job = new JLabel("Job");
       job.setBounds(416,11,70,19);
       job.setForeground(Color.WHITE);
       job.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(job);

       JLabel salary = new JLabel("Salary");
       salary.setBounds(536,11,70,19);
       salary.setForeground(Color.WHITE);
       salary.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(salary);

       JLabel phone = new JLabel("Phone");
       phone.setBounds(656,11,70,19);
       phone.setForeground(Color.WHITE);
       phone.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(phone);

       JLabel gmail = new JLabel("Gmail");
       gmail.setBounds(786,11,70,19);
       gmail.setForeground(Color.WHITE);
       gmail.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(gmail);

       JLabel id = new JLabel("Id");
       id.setBounds(896,11,70,19);
       id.setForeground(Color.WHITE);
       id.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(id);
        
        

       setUndecorated(true);
        setLayout(null);
        setLocation(330, 80);
        setSize(1000,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new employee();
    }
}
