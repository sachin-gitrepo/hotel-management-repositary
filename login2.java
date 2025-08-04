import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login2 extends JFrame implements ActionListener {
    JTextField textfield;
    JPasswordField passwordfield;
    JButton b1,b2;
    login2(){
    JLabel label1 = new JLabel("username");
    label1.setBounds(40,20,100,30);
    label1.setForeground(Color.WHITE);
    label1.setFont(new Font("tohoma",Font.BOLD,16));
    add(label1);

    JLabel label2 = new JLabel("password");
    label2.setBounds(40,70,100,30);
    label2.setForeground(Color.WHITE);
    label2.setFont(new Font("tohoma",Font.BOLD,16));
    add(label2);

    textfield = new JTextField();
    textfield.setBounds(150,20,150,30);
    textfield.setForeground(Color.WHITE);
    textfield.setFont(new Font("tohoma",Font.BOLD,16));
    textfield.setBackground(new Color(26,104,110));
    add(textfield);
    
    passwordfield=new JPasswordField();
    passwordfield.setBounds(150,70,150,30);
    passwordfield.setBackground(new Color(26,104,110));
    add(passwordfield);

    ImageIcon icon =new ImageIcon(ClassLoader.getSystemResource("images\\hotel_logo.gif"));
    JLabel label=new JLabel(icon);
    label.setBounds(315,5,255,250);
    add(label);

    b1=new JButton("login");
    b1.setBounds(40,140,120,30);
    b1.setFont(new Font("serif",Font.BOLD,15));
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);

    b2=new JButton("Clear");
    b2.setBounds(180,140,120,30);
    b2.setFont(new Font("serif",Font.BOLD,15));
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    add(b2);

     setTitle("login screen");
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        setSize(600,300);
        setLocation(400,270);
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           try {
            connection c=new connection();
            String user=textfield.getText();
            String pass=passwordfield.getText();

            String q= "SELECT * FROM login2 WHERE username='"+user+"' and password='"+pass+"'";
            ResultSet resultset=c.statement.executeQuery(q);

            if(resultset.next()){
                setVisible(false);
                new admin();
            }else{
                JOptionPane.showMessageDialog(null, "INVALID");
            }
            
           } catch (Exception e1) {
             e1.printStackTrace();
           }
        }
        else{

          new dashboard();
          setVisible(false);
        }
    }
    public static void main(String[] args) {
        new login2();
    }
   
}
