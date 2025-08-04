import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class reception extends JFrame {
   public reception(){
       JPanel panel=new JPanel();
       panel.setLayout(null);
       panel.setBounds(280,5,1238,820);
       panel.setBackground(new Color(3,45,48));
       add(panel);
       
       JPanel panel1 =new JPanel();
       panel1.setLayout(null);
       panel1.setBounds(5,5,270,820);
       panel1.setBackground(new Color(3,45,48));
       add(panel1);

       ImageIcon i1=new ImageIcon("images\\welcome.gif");
       JLabel lb=new JLabel(i1);
       lb.setBounds(50,-100,800,800);
       panel.add(lb);

    //    ImageIcon i2=new ImageIcon("images\\happystay.gif");
    //    JLabel l2=new JLabel(i2);
    //    l2.setBounds(5,445,250,250);
    //    panel1.add(l2);

       JButton btncnf=new JButton("new customer form");
       btncnf.setBounds(30,10,200,30);
       btncnf.setBackground(Color.BLACK);
       btncnf.setForeground(Color.WHITE);
       panel1.add(btncnf);
       btncnf.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new newCustomer();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btnroom=new JButton("Room");
       btnroom.setBounds(30,50,200,30);
       btnroom.setBackground(Color.BLACK);
       btnroom.setForeground(Color.WHITE);
       panel1.add(btnroom);
       btnroom.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
               new checkRoom();
            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btndept=new JButton("Department");
       btndept.setBounds(30,90,200,30);
       btndept.setBackground(Color.BLACK);
       btndept.setForeground(Color.WHITE);
       panel1.add(btndept);
       btndept.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new department();
            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btninfo=new JButton("All employee information");
       btninfo.setBounds(30,130,200,30);
       btninfo.setBackground(Color.BLACK);
       btninfo.setForeground(Color.WHITE);
       panel1.add(btninfo);
       btninfo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new employee();
            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btninfo2=new JButton("Customer information");
       btninfo2.setBounds(30,170,200,30);
       btninfo2.setBackground(Color.BLACK);
       btninfo2.setForeground(Color.WHITE);
       panel1.add(btninfo2);
       btninfo2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new customerInfo();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });


       JButton btninfo3=new JButton("Manager information");
       btninfo3.setBounds(30,210,200,30);
       btninfo3.setBackground(Color.BLACK);
       btninfo3.setForeground(Color.WHITE);
       panel1.add(btninfo3);
       btninfo3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
               new managerInfo();
            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btnco=new JButton("Check out");
       btnco.setBounds(30,250,200,30);
       btnco.setBackground(Color.BLACK);
       btnco.setForeground(Color.WHITE);
       panel1.add(btnco);
       btnco.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new checkOut();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btnuco=new JButton("Update check in details");
       btnuco.setBounds(30,290,200,30);
       btnuco.setBackground(Color.BLACK);
       btnuco.setForeground(Color.WHITE);
       panel1.add(btnuco);
       btnuco.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new updateCheck();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton btnuroom=new JButton("Update room status");
       btnuroom.setBounds(30,330,200,30);
       btnuroom.setBackground(Color.BLACK);
       btnuroom.setForeground(Color.WHITE);
       panel1.add(btnuroom);
       btnuroom.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new updateRoom();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });
       
       JButton btnpick=new JButton("Pickup serive");
       btnpick.setBounds(30,370,200,30);
       btnpick.setBackground(Color.BLACK);
       btnpick.setForeground(Color.WHITE);
       panel1.add(btnpick);
       btnpick.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new pickupService();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });
        
       JButton btnsrch=new JButton("Search for room");
       btnsrch.setBounds(30,410,200,30);
       btnsrch.setBackground(Color.BLACK);
       btnsrch.setForeground(Color.WHITE);
       panel1.add(btnsrch);
       btnsrch.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                new searchRoom();

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });

       JButton back=new JButton("BACK");
       back.setBounds(30,540,200,30);
       back.setFont(new Font("Tahoma",Font.PLAIN,20));
       back.setForeground(Color.white);
       back.setBackground(Color.DARK_GRAY);
       back.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new dashboard();
               
           }
           
       });
       panel1.add(back);


       JButton logout=new JButton("LOGOUT");
       logout.setBounds(30,500,200,30);
       logout.setFont(new Font("Tahoma",Font.PLAIN,20));
       logout.setBackground(Color.DARK_GRAY);
       logout.setForeground(Color.WHITE);
       panel1.add(logout);
       logout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                System.exit(500);

            }catch(Exception t){
                t.printStackTrace();
            }
        }
       });
        

       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       setSize(1375,900);
       //setSize(1950,1090);
       setVisible(true);
       
    

       
    }
    public static void main(String[] args) {
        new reception();
    }
}

