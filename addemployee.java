import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addemployee extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField nametext,agetext,salarytext,phonetext,idtext,emailtext;
    JRadioButton radioM,radioF;
    JComboBox combo;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    addemployee(){

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

         JLabel name= new JLabel("NAME");
         name.setBounds(60,30,150,27);
         name.setFont(new Font("serif",Font.BOLD,27));
         name.setForeground(Color.BLACK);
        panel.add(name);

        nametext=new JTextField();
        nametext.setBounds(200,30,150,27);
        nametext.setFont(new Font("tahoma",Font.PLAIN,14));
        nametext.setForeground(Color.BLACK);
        nametext.setBackground(Color.WHITE);
        panel.add(nametext);


        JLabel age= new JLabel("AGE");
        age.setBounds(60,80,150,27);
        age.setFont(new Font("serif",Font.BOLD,27));
        age.setForeground(Color.BLACK);
        panel.add(age);

        agetext=new JTextField();
        agetext.setBounds(200,80,150,27);
        agetext.setFont(new Font("tahoma",Font.PLAIN,14));
        agetext.setForeground(Color.BLACK);
        agetext.setBackground(Color.WHITE);
        panel.add(agetext);


        JLabel gender= new JLabel("GENDER");
        gender.setBounds(60,120,150,27);
        gender.setFont(new Font("serif",Font.BOLD,27));
        gender.setForeground(Color.BLACK);
        panel.add(gender);

        radioM=new JRadioButton("MALE");
        radioM.setBounds(200,120,70,27);
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
        radioF.setBounds(280,120,100,27);
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

        JLabel job= new JLabel("JOB");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif",Font.BOLD,27));
        job.setForeground(Color.BLACK);
        panel.add(job);

        
        combo=new JComboBox(new String[] {"Front Desk","HouseKeeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        combo.setBounds(200,170,150,30);
        combo.setFont(new Font("tahoma",Font.PLAIN,14));
        combo.setForeground(Color.BLACK);
        combo.setBackground(Color.WHITE);
        panel.add(combo);
       
        JLabel salary= new JLabel("SALARY");
        salary.setBounds(60,220,150,27);
        salary.setFont(new Font("serif",Font.BOLD,27));
        salary.setForeground(Color.BLACK);
        panel.add(salary);

        salarytext=new JTextField();
        salarytext.setBounds(200,220,150,27);
        salarytext.setFont(new Font("tahoma",Font.PLAIN,14));
        salarytext.setForeground(Color.BLACK);
        salarytext.setBackground(Color.WHITE);
        panel.add(salarytext);

        JLabel phone= new JLabel("PHONE NO");
        phone.setBounds(60,270,150,25);
        phone.setFont(new Font("serif",Font.BOLD,25));
        phone.setForeground(Color.BLACK);
        panel.add(phone);

        phonetext=new JTextField();
        phonetext.setBounds(200,270,150,27);
        phonetext.setFont(new Font("tahoma",Font.PLAIN,14));
        phonetext.setForeground(Color.BLACK);
        phonetext.setBackground(Color.WHITE);
        panel.add(phonetext);
        

        JLabel id= new JLabel("ID no");
        id.setBounds(60,320,150,27);
        id.setFont(new Font("serif",Font.BOLD,27));
        id.setForeground(Color.BLACK);
        panel.add(id);

        idtext=new JTextField();
        idtext.setBounds(200,320,150,27);
        idtext.setFont(new Font("tahoma",Font.PLAIN,14));
        idtext.setForeground(Color.BLACK);
        idtext.setBackground(Color.WHITE);
        panel.add(idtext);

        JLabel email= new JLabel("Email id");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("serif",Font.BOLD,27));
        email.setForeground(Color.BLACK);
        panel.add(email);

        emailtext=new JTextField();
        emailtext.setBounds(200,370,150,27);
        emailtext.setFont(new Font("tahoma",Font.PLAIN,14));
        emailtext.setForeground(Color.BLACK);
        emailtext.setBackground(Color.WHITE);
        panel.add(emailtext);
        


        JLabel heading= new JLabel("ADD EMPLOYEE ");
        heading.setBounds(450,100,500,45);
        heading.setFont(new Font("serif",Font.BOLD,45));
        heading.setForeground(Color.BLACK);
        panel.add(heading);
        
        JLabel heading2= new JLabel("DETAILS");
        heading2.setBounds(550,160,300,45);
        heading2.setFont(new Font("serif",Font.BOLD,45));
        heading2.setForeground(Color.BLACK);
        panel.add(heading2);

         ImageIcon i2=new ImageIcon("images\\happystay.gif");
         JLabel l2=new JLabel(i2);
         l2.setBounds(520,210,250,250);
         panel.add(l2);
        

         b1= new JButton("ADD");
        b1.setBounds(80,420,100,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2= new JButton("BACK");
        b2.setBounds(200,420,100,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setLayout(null);
        setSize(900,500);
        setLocation(60,160);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==b1){
        
            connection c = new connection();
            String  name=nametext.getText();
            String age=agetext.getText();
            String salary=salarytext.getText();
            String phone=phonetext.getText();
            String email=emailtext.getText();
            String id=idtext.getText();
            String job=(String)combo.getSelectedItem();
            String gender="";
            if(radioM.isSelected()){
                gender="male";
            }else if(radioF.isSelected()){
                gender="female";
            }
            try{
                connection con = new connection();
            if(!name.isEmpty()   && !age.isEmpty() && !salary.isEmpty()   && !phone.isEmpty() && !email.isEmpty()   && !id.isEmpty() && !job.isEmpty()   && !gender.isEmpty()){
            String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+id+"')";
            con.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED SUCCESSFULLY");
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
        new addemployee();
    }
   
    
}
