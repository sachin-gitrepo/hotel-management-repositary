import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;

public class department extends JFrame{
    department(){
        JPanel panel=new JPanel();
        panel.setBackground(new ColorUIResource(3,45,48));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JTable table =new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new ColorUIResource(4,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            connection conn=new connection();
            String department_info = "select * from department;";
            ResultSet rs=conn.statement.executeQuery(department_info);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton button=new JButton("Back");
        button.setBounds(400,410,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
            }
            
        });

        
        JLabel lb1 =new JLabel("Department");
        lb1.setBounds(145,11,105,20);
        lb1.setForeground(Color.white);
        lb1.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lb1);

        JLabel lb2 =new JLabel("Budget");
        lb2.setBounds(431,11,105,20);
        lb2.setForeground(Color.white);
        lb2.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lb2);
        
        setUndecorated(true);
        setLayout(null);
        setLocation(500, 150);
        setSize(700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new department();
    }
}
