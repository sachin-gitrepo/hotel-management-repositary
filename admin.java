import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class admin extends JFrame implements ActionListener {
    JButton add_Employee,add_Drivers,add_Room,logOut,back;
    public admin(){
        JPanel panel=new JPanel();
       panel.setLayout(null);
       panel.setBounds(480,5,880,820);
       panel.setBackground(Color.BLACK);
       add(panel);

        add_Employee = new JButton("ADD EMPLOYEES");
        add_Employee.setBounds(250,150,200,30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Employee.addActionListener(this);
        add(add_Employee);
        
        
        add_Room = new JButton("ADD ROOM");
        add_Room.setBounds(250,300,200,30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Drivers = new JButton("ADD DRIVERS");
        add_Drivers.setBounds(250,450,200,30);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);

        logOut = new JButton("LOGOUT");
        logOut.setBounds(10,650,95,30);
        logOut.setBackground(Color.BLACK);
        logOut.setForeground(Color.WHITE);
        logOut.setFont(new Font("Tahoma",Font.BOLD,15));
        logOut.addActionListener(this);
        add(logOut);

        back = new JButton("BACK");
        back.setBounds(110,650,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);
    
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/employees.png"));
          Image img1=i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
         ImageIcon image1=new ImageIcon(img1);
         JLabel label2 =new JLabel(image1);
         label2.setBounds(70,100,120,120);
         label2.setOpaque(true);
         label2.setBackground(Color.GRAY);
         add(label2);

         ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("images/room2.png"));
          Image img2=i2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
         ImageIcon image2=new ImageIcon(img2);
         JLabel label3 =new JLabel(image2);
         label3.setBounds(70,260,120,120);
         label3.setOpaque(true);
         label3.setBackground(Color.GRAY);
         add(label3);

         ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("images/driver.png"));
          Image img3=i3.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
         ImageIcon image3=new ImageIcon(img3);
         JLabel label4 =new JLabel(image3);
         label4.setBounds(70,420,120,120);
         label4.setOpaque(true);
         label4.setBackground(Color.BLACK);
         add(label4);


         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/Daco_5978950.png"));
         Image img4=i4.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon image4=new ImageIcon(img4);
        JLabel label5 =new JLabel(image4);
        label5.setBounds(200,80,500,500);
        label5.setOpaque(true);
        label5.setBackground(Color.BLACK);
        panel.add(label5);

         
       
         setLayout(null);
         setSize(1375,900);
        // getContentPane().setBackground(new Color(3,45,48));
        getContentPane().setBackground(new Color(27,16,53));
         setVisible(true);
         
    }
     @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==add_Employee){
            new addemployee();
            

         }else if(e.getSource()==add_Drivers){
             new adddriver();
            
         }else if(e.getSource()==add_Room){
                new addroom();
         }else if(e.getSource()==logOut){
            System.exit(400);
         }else if(e.getSource()==back){
            new dashboard();
            this.setVisible(false);
         }
    }
    public static void main(String[] args) {
        new admin();
    }
}
