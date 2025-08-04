import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

public class newCustomer extends JFrame implements ActionListener{
    JComboBox<String> combo;
    JTextField textFieldnumber,textFieldname,textFieldcountry,textdeposit;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton add,back;
        newCustomer(){

             JPanel panel=new JPanel();
             panel.setLayout(null);
             panel.setBounds(5,5,840,540);
             panel.setBackground(new ColorUIResource(160,160,160));
             add(panel);

             ImageIcon imgicon=new ImageIcon(ClassLoader.getSystemResource("images\\customer.gif"));
             Image img= imgicon.getImage().getScaledInstance(400,550,Image.SCALE_DEFAULT);
             ImageIcon icon=new ImageIcon(img);
             JLabel imglabel=new JLabel(icon);
             imglabel.setBounds(450,0,400,550);
             panel.add(imglabel);

             JLabel labelname=new JLabel("NEW CUSTOER FORM");
             labelname.setBounds(118,11,260,53);
             labelname.setFont(new Font("Tahoma",Font.BOLD,20));
             labelname.setForeground(Color.BLACK);
             panel.add(labelname);

             JLabel id=new JLabel("Id");
            id.setBounds(35,76,200,14);
             id.setFont(new Font("Tahoma",Font.PLAIN,20));
             id.setForeground(Color.BLACK);
             panel.add(id); 

             combo=new JComboBox<String>(new String[] {"password","aadhar card","voter id","driving licence"});
             combo.setBounds(271,73,150,20);
             combo.setFont(new Font("Tahoma",Font.PLAIN,14));
             combo.setBackground(new Color(160,160,160));
             combo.setForeground(Color.BLACK);
             panel.add(combo); 

             JLabel labelnumber=new JLabel("Number");
             labelnumber.setBounds(35,95,260,53);
             labelnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
             labelnumber.setForeground(Color.BLACK);
             panel.add(labelnumber);
             textFieldnumber=new JTextField();
             textFieldnumber.setBounds(271,111,150,20);
             panel.add(textFieldnumber);
             
             JLabel name=new JLabel("Name");
             name.setBounds(35,151,200,18);
             name.setFont(new Font("Tahoma",Font.PLAIN,20));
             name.setForeground(Color.BLACK);
             panel.add(name);
             textFieldname=new JTextField();
             textFieldname.setBounds(271,151,150,20);
             panel.add(textFieldname);

             JLabel gender=new JLabel("Gender");
             gender.setBounds(35,191,200,19);
             gender.setFont(new Font("Tahoma",Font.PLAIN,20));
             gender.setForeground(Color.BLACK);
             panel.add(gender);
             r1=new JRadioButton("Male");
             r1.setFont(new Font("Tahoma",Font.BOLD,14));
             r1.setForeground(Color.BLACK);
             r1.setBackground(new Color(160,160,160));
             r1.setBounds(271,191,80,12);
             panel.add(r1);
             r2=new JRadioButton("Female");
             r2.setFont(new Font("Tahoma",Font.BOLD,14));
             r2.setForeground(Color.BLACK);
             r2.setBackground(new Color(160,160,160));
             r2.setBounds(350,191,80,12);
             panel.add(r2);


             JLabel country=new JLabel("Country");
             country.setBounds(35,231,200,19);
             country.setFont(new Font("Tahoma",Font.PLAIN,20));
             country.setForeground(Color.BLACK);
             panel.add(country);
             textFieldcountry=new JTextField();
             textFieldcountry.setBounds(271,231,150,20);
             panel.add(textFieldcountry);

             JLabel room=new JLabel("Room Allocated");
             room.setBounds(35,274,200,17);
             room.setFont(new Font("Tahoma",Font.PLAIN,20));
             room.setForeground(Color.BLACK);
             panel.add(room);



             c1=new Choice();
             try {
                connection conn = new connection();
                ResultSet rs=conn.statement.executeQuery("select * from room");
                while(rs.next()){
                    c1.add(rs.getString("room_no"));
                }
             } catch (Exception e) {
                e.printStackTrace();
             }
             c1.setBounds(271,274,150,17);
             c1.setFont(new Font("Tahoma",Font.PLAIN,17));
             c1.setForeground(Color.BLACK);
             c1.setBackground(new Color(160,160,160));
             panel.add(c1);

             JLabel checkIn=new JLabel("Check-In");
             checkIn.setBounds(35,316,200,17);
             checkIn.setFont(new Font("Tahoma",Font.PLAIN,20));
             checkIn.setForeground(Color.BLACK);
             panel.add(checkIn);


             Date date1= new Date();
             
             date=new JLabel(""+date1);
             date.setBounds(271,316,183,17);
             date.setFont(new Font("Tahoma",Font.PLAIN,20));
             date.setForeground(Color.BLACK);
             panel.add(date);

             JLabel deposit=new JLabel("Deposit amount");
             deposit.setBounds(35,359,200,20);
             deposit.setFont(new Font("Tahoma",Font.PLAIN,20));
             deposit.setForeground(Color.BLACK);
             panel.add(deposit);
             textdeposit=new JTextField();
             textdeposit.setBounds(271,359,150,20);
             panel.add(textdeposit);


             add=new JButton("ADD");
             add.setBounds(100,430,120,30);
             add.setFont(new Font("Tahoma",Font.PLAIN,20));
             add.setForeground(Color.white);
             add.setBackground(Color.BLACK);
             add.addActionListener(this);
             panel.add(add);

             back=new JButton("BACK");
             back.setBounds(260,430,120,30);
             back.setFont(new Font("Tahoma",Font.PLAIN,20));
             back.setForeground(Color.white);
             back.setBackground(Color.BLACK);
             back.addActionListener(this);
             panel.add(back);

             setUndecorated(true);
             getContentPane().setBackground(Color.BLACK);
            setLayout(null);
            setSize(850,550);
            setLocation(500,100);
            setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==add){
               connection conn=new connection();
               String radioBtn=null;
               if(r1.isSelected()){
                  radioBtn="Male";
               }else if(r2.isSelected()){
                  radioBtn="Female";
               }
               String id=(String)combo.getSelectedItem();
               String num=textFieldnumber.getText();
               String naam=textFieldname.getText();
               String country=textFieldcountry.getText();
               String choice=c1.getSelectedItem();
               String date2=date.getText();
               String money=textdeposit.getText();

               try {
                  String query="insert into customerInfo values('"+id+"','"+num+"','"+naam+"','"+radioBtn+"','"+country+"','"+choice+"','"+date2+"','"+money+"')";
                  String query2="update room set availability='occupied' where room_no="+choice;
                  conn.statement.executeUpdate(query);
                  System.out.println("hello");
                  conn.statement.executeUpdate(query2);
                  System.out.println("hello world");
                  JOptionPane.showMessageDialog(null,"ADDED SUCCESSFULLY");
                  setVisible(false);
               }
                  catch(Exception e1){
                  e1.printStackTrace();
               }

            }else{
               setVisible(false);
            }
            
        }
        
         public static void main(String[] args) {
            new newCustomer();
         }
}
