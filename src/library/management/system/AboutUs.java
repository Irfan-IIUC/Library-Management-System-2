package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AboutUs extends JFrame {

    AboutUs() {

        super("About Us");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(425, 40, 100, 100);
        add(l1);

        JLabel l3 = new JLabel("Library");
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Trebuchet MS", Font.PLAIN | Font.ITALIC, 34));
        l3.setBounds(160, 40, 150, 55);
        add(l3);

        JLabel l4 = new JLabel("Mangement System");
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Trebuchet MS", Font.PLAIN | Font.ITALIC, 34));
        l4.setBounds(70, 90, 405, 40);
        add(l4);

        JLabel l5 = new JLabel("v5.1");
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        l5.setBounds(185, 140, 100, 21);
        add(l5);

        JLabel l6 = new JLabel("Developed By : Quazi Hasnat Irfan");
        l6.setFont(new Font("serif", Font.PLAIN, 30));
        l6.setBounds(70, 198, 600, 35);
        add(l6);

        JLabel l7 = new JLabel("Studies at International Islamic University Chittagong");
        l7.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        l7.setBounds(70, 260, 600, 34);
        add(l7);

        JLabel l8 = new JLabel("B.Sc. in Computer Science and Engineering");
        l8.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        l8.setBounds(70, 290, 600, 34);
        add(l8);

        JLabel l9 = new JLabel("E-mail : quazi1742@yahoo.com");
        l9.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        l9.setBounds(70, 320, 600, 34);
        add(l9);

        JLabel l10 = new JLabel("**If you want me to make Java Project for you, drop a mail**");
        l10.setFont(new Font("Trebuchet MS", Font.PLAIN | Font.ITALIC, 18));
        l10.setBounds(70, 400, 600, 34);
        add(l10);

        setLayout(null);
        setSize(650, 510);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new AboutUs().setVisible(true);
    }
}
