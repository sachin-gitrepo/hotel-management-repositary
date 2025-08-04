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

public class updateRoom extends JFrame{
    JTextField textFieldavailable,textFieldnumber,textFieldcleaning;
    JButton update,check,back;
    updateRoom(){
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

        JLabel label1=new JLabel("UPDATE ROOM STATUS");
        label1.setBounds(124,11,300,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel id=new JLabel("ID :");
        id.setBounds(25,88,46,16);
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
        room.setBounds(25,129,150,19);
        room.setFont(new Font("Tahoma",Font.PLAIN,19));
        room.setForeground(Color.black);
        panel.add(room);
        textFieldnumber=new JTextField();
        textFieldnumber.setBounds(248,129,140,20);
        panel.add(textFieldnumber);


         
        JLabel avaiLabel=new JLabel("Availability :");
        avaiLabel.setBounds(25,174,150,25);
        avaiLabel.setFont(new Font("Tahoma",Font.PLAIN,19));
        avaiLabel.setForeground(Color.black);
        panel.add(avaiLabel);
        textFieldavailable=new JTextField();
        textFieldavailable.setBounds(248,174,140,20);
        panel.add(textFieldavailable);

        JLabel cleaning=new JLabel("Cleaning status :");
        cleaning.setBounds(25,216,200,25);
        cleaning.setFont(new Font("Tahoma",Font.PLAIN,19));
        cleaning.setForeground(Color.black);
        panel.add(cleaning);
        textFieldcleaning=new JTextField();
        textFieldcleaning.setBounds(248,216,140,20);
        panel.add(textFieldcleaning);

       


        
        update=new JButton("UPDATE");
        update.setBounds(120,315,110,30);
        update.setFont(new Font("Tahoma",Font.PLAIN,20));
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                   
                    connection conn= new connection();
                    String status=textFieldcleaning.getText();
                   conn.statement.executeUpdate("update room set cleaning_status='"+status+"',availability='"+textFieldavailable.getText()+"' where room_no='"+textFieldnumber.getText()+"'");
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
        back.setBounds(180,355,110,30);
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
        check.setBounds(60,355,110,30);
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
                       
                    }
                    ResultSet rs2=conn.statement.executeQuery("select * from room where room_no='"+textFieldnumber.getText()+"'");
                    while(rs2.next()){
                       textFieldavailable.setText(rs2.getString("availability"));
                       textFieldcleaning.setText(rs2.getString("cleaning_status"));

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
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);
    }


    
    public static void main(String[] args) {
        new updateRoom();
    }

}
