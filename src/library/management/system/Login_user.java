package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login_user extends JFrame implements ActionListener {

    private JTextField t1;
    private JPasswordField p1;
    private JButton b1, b2, b3;

    Login_user() {

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(124, 89, 95, 24);
        add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(124, 124, 95, 24);
        add(l2);

        JLabel l3 = new JLabel("Trouble in login ?");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setForeground(Color.RED);
        l3.setBounds(190, 281, 130, 25);
        add(l3);

        JLabel l4 = new JLabel("Login Form");
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("serif", Font.PLAIN, 25));
        l4.setBounds(185, 25, 130, 30);
        add(l4);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(210, 93, 157, 20);
        add(t1);

        p1 = new JPasswordField();
        p1.setFont(new Font("serif", Font.PLAIN, 17));
        p1.setBounds(210, 128, 157, 20);
        add(p1);

        b1 = new JButton("Login");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(124, 181, 90, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("SignUp");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(275, 181, 90, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Forgot Password");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(170, 231, 150, 30);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setSize(500, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Login");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            boolean status = false;

            try {

                conn con = new conn();
                String sql = "select * from account where username = ? and password = ?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, p1.getText());

                ResultSet rs = st.executeQuery();

                if (rs.next()) {

                    this.setVisible(false);
                    new Loading().setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Login !");
                    
                    t1.setText(null);
                    p1.setText(null);
                }

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {
            
            this.setVisible(false);
            new Signup().setVisible(true);

        } else if (ae.getSource() == b3) {

             this.setVisible(false);
            new Forgot().setVisible(true);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        
        new Login_user().setVisible(true);
    }
}
