package library.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ReadMe extends JFrame {

    ReadMe() {

        super("Read Me");

        JLabel l1 = new JLabel("Library");
        l1.setFont(new Font("serif", Font.PLAIN, 35));
        l1.setForeground(Color.BLUE);
        l1.setBounds(160, 40, 150, 55);
        add(l1);

        JLabel l2 = new JLabel("Management System");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("serif", Font.PLAIN, 35));
        l2.setBounds(70, 90, 405, 40);
        add(l2);

        JLabel l3 = new JLabel("v5.1");
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("serif", Font.PLAIN, 25));
        l3.setBounds(185, 140, 100, 21);
        add(l3);

        JLabel l4 = new JLabel("Developed By : Quazi Hasnat Irfan");
        l4.setFont(new Font("serif", Font.PLAIN, 25));
        l4.setBounds(70, 190, 600, 35);
        add(l4);
        
        JTextArea ta = new JTextArea("Library management system project which aim in develop a computerized \n"
                                   + "system to maintain all the daily working of  library.This system helps both \n"
                                   + "student and library manager to keep constant track of athe book available\n"
                                   + "in the library. It allow your both the admin and e student to search for the \n"
                                   + "desired book.");
        
        ta.setFont(new Font("serif", Font.PLAIN | Font.ITALIC, 20));
        ta.setBackground(Color.LIGHT_GRAY);
        ta.setBounds(70, 250, 605, 140);
        add(ta);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setSize(750, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new ReadMe().setVisible(true);
    }
}
