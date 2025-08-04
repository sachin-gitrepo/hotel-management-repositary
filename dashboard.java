import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class dashboard extends JFrame implements ActionListener{
    JButton rec,adm;
    dashboard(){
        super("HOTEL MANAGEMENT SYSTEM");

        
        

        rec=new JButton("RECEPTION");
        rec.setBounds(200,450,250,35);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setForeground(Color.BLACK);
        rec.setBackground(Color.cyan);
        rec.addActionListener(this);
        add(rec);

        adm=new JButton("ADMIN");
        adm.setBounds(700,450,250,35);
        adm.setFont(new Font("Tahoma",Font.BOLD,15));
        adm.setForeground(Color.BLACK);
        adm.setBackground(Color.cyan);
        adm.addActionListener(this);
        add(adm);

        ImageIcon admin=new ImageIcon("images\\admin2.png");
        // Image admn=admin.getImage().getScaledInstance(1375,900,Image.SCALE_DEFAULT);
        // ImageIcon i2=new ImageIcon(admn);
         JLabel label2 =new JLabel(admin);
         label2.setBounds(700,125,250,300);
        label2.setOpaque(true);
         label2.setBackground(Color.GRAY);
         add(label2);
        
         ImageIcon recep=new ImageIcon("images\\reception.png");
         JLabel label3 =new JLabel(recep);
         label3.setBounds(200,125,250,300);
         label3.setOpaque(true);
         label3.setBackground(Color.GRAY);
         add(label3);

        ImageIcon image=new ImageIcon("images\\best_hotel.gif");
        Image i1=image.getImage().getScaledInstance(1375,900,Image.SCALE_DEFAULT);
        ImageIcon img=new ImageIcon(i1);
        JLabel label =new JLabel(img);
        label.setBounds(0,0,1375,900);
        add(label);
        
        

        setLayout(null);
        setSize(1375,900);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            new reception();
            setVisible(false);
        }else{
            new login2();
        }
        
    }
    public static void main(String[] args) {
        new dashboard();
    }
}