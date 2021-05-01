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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Forgot extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;

    Forgot() {

        super("Forgot Password");

        JLabel l0 = new JLabel("Forgot Password ?");
        l0.setForeground(Color.BLUE);
        l0.setFont(new Font("serif", Font.PLAIN, 25));
        l0.setBounds(215, 25, 195, 30);
        add(l0);
        
        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(109, 83, 87, 29);
        add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(109, 122, 75, 21);
        add(l2);

        JLabel l3 = new JLabel("Security Question");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(109, 154, 160, 27);
        add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(109, 192, 104, 21);
        add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(109, 224, 104, 21);
        add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(277, 88, 139, 20);
        add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(277, 123, 139, 20);
        add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setBounds(277, 158, 235, 20);
        add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setBounds(277, 193, 139, 20);
        add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("serif", Font.PLAIN, 17));
        t5.setBounds(277, 225, 139, 20);
        add(t5);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(426, 85, 85, 25);
        add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(426, 190, 85, 25);
        add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(233, 270, 101, 29);
        add(b3);

        setLayout(null);
        setSize(630, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                conn con = new conn();
                String sql = "select * from account where username = ?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("sec_q"));
                }

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            try {

                conn con = new conn();
                String sql = "select * from account where sec_ans = ?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    t5.setText(rs.getString("password"));
                }

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b3) {

            this.setVisible(false);
            new Login_user().setVisible(true);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new Forgot().setVisible(true);
    }
}
