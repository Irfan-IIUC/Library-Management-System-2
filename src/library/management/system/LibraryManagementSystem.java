package library.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LibraryManagementSystem extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1;

    LibraryManagementSystem() {

        super("Library Management System");

        b1 = new JButton("Next");
        b1.setFont(new Font("serif", Font.PLAIN, 17));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1000, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        b1.setBounds(850, 350, 100, 30);
        l1.setBounds(0, 0, 1000, 450);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);

        setLayout(null);
        setSize(1000, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        new Login_user().setVisible(true);
        this.setVisible(false);
        
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new LibraryManagementSystem().setVisible(true);
    }

}
