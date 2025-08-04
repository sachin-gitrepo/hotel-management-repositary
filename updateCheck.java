import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Choice;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

public class updateCheck extends JFrame {
    JTextField textFieldname,textFieldnumber,textFieldcheck,textdeposit,textpending;
    JButton update,check,back;
    updateCheck(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new ColorUIResource(160,160,160));
        add(panel);

        ImageIcon imgicon=new ImageIcon(ClassLoader.getSystemResource(""));
        Image img= imgicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(img);
        JLabel imglabel=new JLabel(icon);
        imglabel.setBounds(500,60,300,300);
        panel.add(imglabel);

        JLabel label1=new JLabel("CHECK IN DETAILS");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel id=new JLabel("ID :");
        id.setBounds(25,88,46,17);
        id.setFont(new Font("Tahoma",Font.PLAIN,19));
        id.setForeground(Color.black);
        panel.add(id);


        Choice choice = new Choice();
        choice.setBounds(248,85,140,20);
        panel.add(choice);
   
      try {
            connection conn= new connection();
            String query="select * from customerInfo";
            ResultSet rs=conn.statement.executeQuery(query);
            while(rs.next()){
                choice.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }

        
        JLabel room=new JLabel("Room Number :");
        room.setBounds(25,129,150,25);
        room.setFont(new Font("Tahoma",Font.PLAIN,19));
        room.setForeground(Color.black);
        panel.add(room);
        textFieldnumber=new JTextField();
        textFieldnumber.setBounds(248,129,140,20);
        panel.add(textFieldnumber);


         
        JLabel name=new JLabel("Name :");
        name.setBounds(25,174,97,25);
        name.setFont(new Font("Tahoma",Font.PLAIN,19));
        name.setForeground(Color.black);
        panel.add(name);
        textFieldname=new JTextField();
        textFieldname.setBounds(248,174,140,20);
        panel.add(textFieldname);

        JLabel checkIn=new JLabel("Checked In :");
        checkIn.setBounds(25,216,150,25);
        checkIn.setFont(new Font("Tahoma",Font.PLAIN,19));
        checkIn.setForeground(Color.black);
        panel.add(checkIn);
        textFieldcheck=new JTextField();
        textFieldcheck.setBounds(248,216,140,20);
        textFieldcheck.setFont(new Font("tahoma",Font.PLAIN,10));
        panel.add(textFieldcheck);

        JLabel deposit=new JLabel("Amount paid(Rs) :");
        deposit.setBounds(25,261,190,25);
        deposit.setFont(new Font("Tahoma",Font.PLAIN,19));
        deposit.setForeground(Color.black);
        panel.add(deposit);
        textdeposit=new JTextField();
        textdeposit.setBounds(248,261,140,20);
        panel.add(textdeposit);


        JLabel pending=new JLabel("pending(Rs) :");
        pending.setBounds(25,302,150,25);
        pending.setFont(new Font("Tahoma",Font.PLAIN,19));
        pending.setForeground(Color.black);
        panel.add(pending);
        textpending=new JTextField();
        textpending.setBounds(248,302,140,20);
        panel.add(textpending);


        
        update=new JButton("UPDATE");
        update.setBounds(56,378,110,30);
        update.setFont(new Font("Tahoma",Font.PLAIN,20));
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    String id=choice.getSelectedItem();
                    connection conn= new connection();
                   String room=textFieldnumber.getText();
                   String name=textFieldname.getText();
                   String check=textFieldcheck.getText();
                   String amount=textdeposit.getText();
                   conn.statement.executeUpdate("update customerInfo set room='"+room+"',name='"+name+"',checkInTime='"+check+"',depositAmount='"+amount+"'where number='"+id+"'");
                   JOptionPane.showMessageDialog(null,"updated Successfully");
                   setVisible(false);
                }
                catch(Exception e2){
                      e2.printStackTrace();
                }
            }
            
        });
        panel.add(update);

        back=new JButton("BACK");
        back.setBounds(220,378,110,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
            
        });
        panel.add(back);

        check=new JButton("CHECK");
        check.setBounds(400,378,110,30);
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String query="select * from customerInfo where number='"+id+"'";

                try {
                    connection conn= new connection();
                    ResultSet rs=conn.statement.executeQuery(query);
                    while(rs.next()){
                        textFieldnumber.setText(rs.getString("room"));
                        textFieldname.setText(rs.getString("name"));
                        textFieldcheck.setText(rs.getString("checkInTime"));
                        textdeposit.setText(rs.getString("depositAmount"));
                    }
                    ResultSet rs2=conn.statement.executeQuery("select * from room where room_no='"+textFieldnumber.getText()+"'");
                    while(rs2.next()){
                       String price=rs2.getString("price");
                       int amountpaid=Integer.parseInt(price)-Integer.parseInt(textdeposit.getText());
                       textpending.setText(""+amountpaid);


                    }

                } catch (Exception e1) {
                    e1.printStackTrace();;
                }

            }
            
        });
        panel.add(check);








        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setSize(950,500);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new updateCheck();
    
    }

}
