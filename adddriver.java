import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class adddriver extends JFrame implements ActionListener{
    JTextField nametext,agetext,cComponytext,carNametext,locationtext;
    JRadioButton radioM,radioF;
    JComboBox combo;
    JButton add,back;
    public adddriver(){
        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,900,500);
        panel1.setBackground(new Color(0,0,0));
        panel1.setLayout(null);
        add(panel1);

        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(160,160,160));
        panel.setLayout(null);
        panel1.add(panel);

        JLabel heading= new JLabel("---ADD DRIVERS---");
        heading.setBounds(194,10,300,22);
        heading.setFont(new Font("serif",Font.BOLD,27));
        heading.setForeground(Color.BLACK);
        panel.add(heading);

        JLabel name= new JLabel("NAME");
        name.setBounds(64,70,150,27);
        name.setFont(new Font("serif",Font.BOLD,27));
        name.setForeground(Color.BLACK);
       panel.add(name);

       nametext=new JTextField();
       nametext.setBounds(174,70,156,27);
       nametext.setFont(new Font("tahoma",Font.PLAIN,14));
       nametext.setForeground(Color.BLACK);
       nametext.setBackground(Color.WHITE);
       panel.add(nametext);

       JLabel age= new JLabel("AGE");
       age.setBounds(64,110,150,27);
       age.setFont(new Font("serif",Font.BOLD,27));
       age.setForeground(Color.BLACK);
       panel.add(age);

       agetext=new JTextField();
       agetext.setBounds(174,110,150,27);
       agetext.setFont(new Font("tahoma",Font.PLAIN,14));
       agetext.setForeground(Color.BLACK);
       agetext.setBackground(Color.WHITE);
       panel.add(agetext);

       JLabel gender= new JLabel("GENDER");
        gender.setBounds(64,160,150,27);
        gender.setFont(new Font("serif",Font.BOLD,27));
        gender.setForeground(Color.BLACK);
      
        panel.add(gender);

        radioM=new JRadioButton("MALE");
        radioM.setBounds(190,160,70,27);
        radioM.setFont(new Font("tahoma",Font.PLAIN,14));
        radioM.setForeground(Color.BLACK);
        radioM.setBackground(new Color(160,160,160));
        radioM.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioM.isSelected()){
                    radioF.setSelected(false);
                }
            }
        });
        panel.add(radioM);

        radioF=new JRadioButton("FEMALE");
        radioF.setBounds(270,160,100,27);
        radioF.setFont(new Font("tahoma",Font.PLAIN,14));
        radioF.setForeground(Color.BLACK);
        radioF.setBackground(new Color(160,160,160));
        radioF.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioF.isSelected()){
                    radioM.setSelected(false);
                }
            }
        });
        panel.add(radioF);

        JLabel carName= new JLabel("CAR NAME");
        carName.setBounds(64,210,150,27);
        carName.setFont(new Font("serif",Font.BOLD,18));
        carName.setForeground(Color.BLACK);
        panel.add(carName);
 
        carNametext=new JTextField();
        carNametext.setBounds(174,210,150,27);
        carNametext.setFont(new Font("tahoma",Font.PLAIN,14));
        carNametext.setForeground(Color.BLACK);
        carNametext.setBackground(Color.WHITE);
        panel.add(carNametext);


        JLabel cCompony= new JLabel("CAR");
        cCompony.setBounds(64,260,150,15);
        cCompony.setFont(new Font("serif",Font.BOLD,18));
        cCompony.setForeground(Color.BLACK);
        panel.add(cCompony);
        JLabel cCompony1= new JLabel("COMPONY");
        cCompony1.setBounds(64,280,150,15);
        cCompony1.setFont(new Font("serif",Font.BOLD,18));
        cCompony1.setForeground(Color.BLACK);
        panel.add(cCompony1);
 
 
        cComponytext=new JTextField();
        cComponytext.setBounds(174,270,150,27);
        cComponytext.setFont(new Font("tahoma",Font.PLAIN,14));
        cComponytext.setForeground(Color.BLACK);
        cComponytext.setBackground(Color.WHITE);
        panel.add(cComponytext);
        

        JLabel available= new JLabel("AVAILABLITY");
        available.setBounds(45,320,150,27);
        available.setFont(new Font("serif",Font.BOLD,18));
        available.setForeground(Color.BLACK);
        panel.add(available);

        
        combo=new JComboBox(new String[] {"Available","Not Available"});
        combo.setBounds(174,320,150,30);
        combo.setFont(new Font("tahoma",Font.PLAIN,14));
        combo.setForeground(Color.BLACK);
        combo.setBackground(Color.WHITE);
        panel.add(combo);
        

        JLabel location= new JLabel("LOCATION");
        location.setBounds(64,370,150,27);
        location.setFont(new Font("serif",Font.BOLD,18));
        location.setForeground(Color.BLACK);
        panel.add(location);
 
        locationtext=new JTextField();
        locationtext.setBounds(174,370,150,27);
        locationtext.setFont(new Font("tahoma",Font.PLAIN,14));
        locationtext.setForeground(Color.BLACK);
        locationtext.setBackground(Color.WHITE);
        panel.add(locationtext);

        add= new JButton("ADD");
        add.setBounds(64,410,100,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back= new JButton("BACK");
        back.setBounds(200,410,100,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("images/driver2.jpg"));
        Image img=i.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(img);
        JLabel lb=new JLabel(icon);
        lb.setBackground(new Color(160,160,160));
        lb.setBounds(500,60,300,300);
        panel.add(lb);



        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=nametext.getText();
            String age=agetext.getText();
            String compony=cComponytext.getText();
            String carName=carNametext.getText();
            String available=(String) combo.getSelectedItem();
            String location=locationtext.getText();
            String gender="";
            if(radioM.isSelected()){
                gender="male";
            }else if(radioF.isSelected()){
                gender="female";
            }

            try {
                connection c= new connection();
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+compony+"','"+carName+"','"+available+"','"+location+"')";
                c.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"DRIVER ADDED SUCCESSFULLY");
            this.setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
  
    public static void main(String[] args) {
        new adddriver();
    }

   
    
}
