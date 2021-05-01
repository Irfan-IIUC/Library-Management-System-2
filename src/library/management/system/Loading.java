package library.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Loading extends JFrame implements Runnable{

    Thread th;
    JProgressBar pb;

    Loading() {

        super("Loading");
        
        JLabel l1 = new JLabel("Smart Library v5.1");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Trebuchet MS", Font.PLAIN, 35));
        l1.setBounds(135, 46, 500, 35);
        add(l1);

        pb = new JProgressBar();
        pb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pb.setStringPainted(true);
        pb.setBounds(130, 135, 300, 25);
        add(pb);

        JLabel l2 = new JLabel("Please Wait ....");
        l2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        l2.setForeground(new Color(160, 82, 45));
        l2.setBounds(220, 170, 150, 20);
        add(l2);
        
        th = new Thread((Runnable) this);
        
        setUploading();

        setLayout(null);
        setSize(560, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public void setUploading(){
        
        this.setVisible(false);
        th.start();
    }
    
    public void run(){
        
        try{
            
            for(int i=0; i<=100; i++){
                
                int m = pb.getMaximum();
                int v = pb.getValue();
                
                if(v < m){
                    
                    pb.setValue(pb.getValue() + 1);
                    
                } else{
                    
                    this.setVisible(false);
                    new Home().setVisible(true);
                    th.stop();
                }
                
                Thread.sleep(50);
            }
            
        } catch(Exception e){
            
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        
        new Loading().setVisible(true);
    }
}
