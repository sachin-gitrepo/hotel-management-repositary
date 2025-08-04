import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class splash extends JFrame {
    splash(){
         ImageIcon image=new ImageIcon("images\\gif858,680.gif");
        //Image i = image.getImage().getScaledInstance(858,680,Image.SCALE_DEFAULT);
        JLabel label=new JLabel(image);
         label.setBounds(0,0,858,680);
    
        add(label);
        
        setTitle("opening screen");
        setLayout(null);
        setSize(858,680);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            new login();
            setVisible(false);
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new splash();
    }
    }



    
