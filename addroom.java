import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class addroom extends JFrame implements ActionListener{
    JTextField t1,t3;
    JComboBox t2,t4,t5;
    JButton  b1,b2;
    addroom(){
        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,885,500);
        panel1.setBackground(new Color(0,0,0));
        panel1.setLayout(null);
        add(panel1);

        JPanel panel=new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(160,160,160));
        panel.setLayout(null);
        panel1.add(panel);
      // add(panel);

        JLabel l1= new JLabel("ADD ROOMS");
        l1.setBounds(194,10,160,22);
        l1.setFont(new Font("tahoma",Font.BOLD,22));
        l1.setForeground(Color.BLACK);
        panel.add(l1);
        
        JLabel l2= new JLabel("Room Number");
        l2.setBounds(64,70,152,22);
        l2.setFont(new Font("tahoma",Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        panel.add(l2);

        t1=new JTextField();
        t1.setBounds(200,70,156,22);
        t1.setFont(new Font("tahoma",Font.PLAIN,14));
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.WHITE);
        panel.add(t1);

        JLabel l3= new JLabel("Availability");
        l3.setBounds(64,110,152,22);
        l3.setFont(new Font("tahoma",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        panel.add(l3);

        t2=new JComboBox(new String[] {"Available","Occupied"});
        t2.setBounds(200,110,156,22);
        t2.setFont(new Font("tahoma",Font.PLAIN,14));
        t2.setForeground(Color.BLACK);
        t2.setBackground(Color.WHITE);
        panel.add(t2);
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(64,150,152,22);
        l4.setFont(new Font("tahoma",Font.BOLD,14));
        l4.setForeground(Color.BLACK);
        panel.add(l4);

        t3=new JTextField();
        t3.setBounds(200,150,156,22);
        t3.setFont(new Font("tahoma",Font.PLAIN,14));
        t3.setForeground(Color.BLACK);
        t3.setBackground(Color.WHITE);
        panel.add(t3);

        JLabel l5= new JLabel("Cleaning Status");
        l5.setBounds(64,190,152,22);
        l5.setFont(new Font("tahoma",Font.BOLD,14));
        l5.setForeground(Color.BLACK);
        panel.add(l5);

        t4=new JComboBox(new String[] { "Cleaned","Not Cleaned"});
        t4.setBounds(200,190,156,22);
        t4.setFont(new Font("tahoma",Font.PLAIN,14));
        t4.setForeground(Color.BLACK);
        t4.setBackground(Color.WHITE);
        panel.add(t4);

        JLabel l6= new JLabel("Bed Type");
        l6.setBounds(64,230,152,22);
        l6.setFont(new Font("tahoma",Font.BOLD,14));
        l6.setForeground(Color.BLACK);
        panel.add(l6);

        t5=new JComboBox(new String[] { "Single","Double"});
        t5.setBounds(200,230,156,22);
        t5.setFont(new Font("tahoma",Font.PLAIN,14));
        t5.setForeground(Color.BLACK);
        t5.setBackground(Color.WHITE);
        panel.add(t5);

        b1= new JButton("ADD");
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2= new JButton("BACK");
        b2.setBounds(198,321,111,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("images/room2.png"));
        Image img=i.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(img);
        JLabel lb=new JLabel(icon);
        lb.setBackground(new Color(160,160,160));
        lb.setBounds(500,60,300,300);
        panel.add(lb);

        setUndecorated(true);
        setLayout(null);
        setSize(885,500);
        setLocation(20,200);
        setVisible(true);
     
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1){
        try {
            connection c = new connection();
            String  room =t1.getText();
            String avail=(String)t2.getSelectedItem();
            String status=(String)t4.getSelectedItem();
            String price=t3.getText();
            String bed=(String)t5.getSelectedItem();
            
            if(!room.isEmpty()   && !price.isEmpty() ){
            String query="insert into room values('"+room+"','"+avail+"','"+status+"','"+price+"','"+bed+"')";
            c.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"ROOM ADDED SUCCESSFULLY");
            this.setVisible(false);
            }
            else{
                
            JOptionPane.showMessageDialog(null,"ERROR PLEASE ENTER DATA...");
            }

           
        } catch (Exception E) {
            E.printStackTrace();
        }
       }
       else{
        setVisible(false);
       }
    }
    public static void main(String[] args) {
        new addroom();
    }

  
}
