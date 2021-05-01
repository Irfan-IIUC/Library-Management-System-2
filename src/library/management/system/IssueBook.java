package library.management.system;

import com.toedter.calendar.JDateChooser;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class IssueBook extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    private JButton b1, b2, b3, b4;
    JDateChooser dc;
    private JPanel p1, p2;

    IssueBook() {

        super("Issue Book");

        JLabel l1 = new JLabel("Book_id");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(47, 63, 100, 23);
        add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(47, 97, 100, 23);
        add(l2);

        JLabel l3 = new JLabel("ISBN");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(47, 131, 100, 23);
        add(l3);

        JLabel l4 = new JLabel("Publisher");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(47, 165, 100, 23);
        add(l4);

        JLabel l5 = new JLabel("Edition");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(47, 199, 100, 23);
        add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(47, 233, 100, 23);
        add(l6);

        JLabel l7 = new JLabel("Pages");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(47, 267, 100, 23);
        add(l7);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(126, 66, 86, 20);
        add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(126, 100, 208, 20);
        add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setColumns(10);
        t3.setBounds(126, 131, 208, 20);
        add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setColumns(10);
        t4.setBounds(126, 168, 208, 20);
        add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("serif", Font.PLAIN, 17));
        t5.setColumns(10);
        t5.setBounds(126, 202, 208, 20);
        add(t5);

        t6 = new JTextField();
        t6.setEditable(false);
        t6.setFont(new Font("serif", Font.PLAIN, 17));
        t6.setColumns(10);
        t6.setBounds(126, 236, 208, 20);
        add(t6);

        t7 = new JTextField();
        t7.setEditable(false);
        t7.setFont(new Font("serif", Font.PLAIN, 17));
        t7.setColumns(10);
        t7.setBounds(126, 270, 208, 20);
        add(t7);

        p1 = new JPanel();
        p1.setFont(new Font("serif", Font.PLAIN, 17));
        p1.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2, true), "Issue Book", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        p1.setBounds(20, 30, 345, 288);
        p1.setLayout(null);
        add(p1);

        JLabel l8 = new JLabel("Student_id");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(434, 63, 100, 23);
        add(l8);

        JLabel l9 = new JLabel("Name");
        l9.setFont(new Font("serif", Font.PLAIN, 17));
        l9.setBounds(434, 100, 100, 23);
        add(l9);

        JLabel l10 = new JLabel("Father's Name");
        l10.setFont(new Font("serif", Font.PLAIN, 17));
        l10.setBounds(434, 137, 100, 23);
        add(l10);

        JLabel l11 = new JLabel("Course");
        l11.setFont(new Font("serif", Font.PLAIN, 17));
        l11.setBounds(434, 174, 100, 23);
        add(l11);

        JLabel l12 = new JLabel("Branch");
        l12.setFont(new Font("serif", Font.PLAIN, 17));
        l12.setBounds(434, 211, 100, 23);
        add(l12);

        JLabel l13 = new JLabel("Year");
        l13.setFont(new Font("serif", Font.PLAIN, 17));
        l13.setBounds(434, 248, 100, 23);
        add(l13);

        JLabel l14 = new JLabel("Semester");
        l14.setFont(new Font("serif", Font.PLAIN, 17));
        l14.setBounds(434, 285, 100, 23);
        add(l14);

        t8 = new JTextField();
        t8.setFont(new Font("serif", Font.PLAIN, 17));
        t8.setColumns(10);
        t8.setBounds(558, 66, 86, 20);
        add(t8);

        t9 = new JTextField();
        t9.setFont(new Font("serif", Font.PLAIN, 17));
        t9.setEditable(false);
        t9.setColumns(10);
        t9.setBounds(558, 103, 208, 20);
        add(t9);

        t10 = new JTextField();
        t10.setFont(new Font("serif", Font.PLAIN, 17));
        t10.setEditable(false);
        t10.setColumns(10);
        t10.setBounds(558, 140, 208, 20);
        add(t10);

        t11 = new JTextField();
        t11.setFont(new Font("serif", Font.PLAIN, 17));
        t11.setEditable(false);
        t11.setColumns(10);
        t11.setBounds(558, 177, 208, 20);
        add(t11);

        t12 = new JTextField();
        t12.setFont(new Font("serif", Font.PLAIN, 17));
        t12.setEditable(false);
        t12.setColumns(10);
        t12.setBounds(558, 214, 208, 20);
        add(t12);

        t13 = new JTextField();
        t13.setFont(new Font("serif", Font.PLAIN, 17));
        t13.setEditable(false);
        t13.setColumns(10);
        t13.setBounds(558, 251, 208, 20);
        add(t13);

        t14 = new JTextField();
        t14.setFont(new Font("serif", Font.PLAIN, 17));
        t14.setEditable(false);
        t14.setColumns(10);
        t14.setBounds(558, 288, 208, 20);
        add(t14);

        p2 = new JPanel();
        p2.setFont(new Font("serif", Font.PLAIN, 17));
        p2.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2, true), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        p2.setBounds(405, 30, 390, 295);
        p2.setLayout(null);
        add(p2);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(215, 30, 100, 30);
        p1.add(b1);

        b2 = new JButton("Search");
        b2.addActionListener(this);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(262, 30, 100, 30);
        p2.add(b2);

        b3 = new JButton("Issue");
        b3.addActionListener(this);
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.setBounds(405, 350, 100, 30);
        add(b3);

        b4 = new JButton("Back");
        b4.addActionListener(this);
        b4.setFont(new Font("serif", Font.PLAIN, 17));
        b4.setBounds(695, 350, 100, 30);
        add(b4);

        JLabel l15 = new JLabel("Date of Issue");
        l15.setFont(new Font("serif", Font.PLAIN, 17));
        l15.setBounds(25, 350, 118, 26);
        add(l15);

        dc = new JDateChooser();
        dc.setFont(new Font("serif", Font.PLAIN, 17));
        dc.setBounds(130, 355, 208, 20);
        add(dc);

        setLayout(null);
        setSize(825, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                conn con = new conn();
                String sql = "select * from book where book_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("isbn"));
                    t4.setText(rs.getString("publisher"));
                    t5.setText(rs.getString("edition"));
                    t6.setText(rs.getString("price"));
                    t7.setText(rs.getString("pages"));
                }

                st.close();
                con.c.close();

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else if (ae.getSource() == b2) {

            try {

                conn con = new conn();
                String sql = "select * from student where student_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t8.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    t9.setText(rs.getString("name"));
                    t10.setText(rs.getString("father"));
                    t11.setText(rs.getString("course"));
                    t12.setText(rs.getString("branch"));
                    t13.setText(rs.getString("year"));
                    t14.setText(rs.getString("semester"));
                }

                st.close();
                con.c.close();

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else if (ae.getSource() == b3) {

            try {

                conn con = new conn();
                String sq = "insert into issuebook(book_id, student_id, bname, sname, course, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sq);

                st.setString(1, t1.getText());
                st.setString(2, t8.getText());
                st.setString(3, t2.getText());
                st.setString(4, t9.getText());
                st.setString(5, t11.getText());
                st.setString(6, t12.getText());
                st.setString(7, ((JTextField) dc.getDateEditor().getUiComponent()).getText());

                int rs = st.executeUpdate();

                if (rs > 0) {

                    JOptionPane.showMessageDialog(null, "Book Issued Successfuly");

                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    t4.setText(null);
                    t5.setText(null);
                    t6.setText(null);
                    t7.setText(null);
                    t8.setText(null);
                    t9.setText(null);
                    t10.setText(null);
                    t11.setText(null);
                    t12.setText(null);
                    t13.setText(null);
                    t14.setText(null);

                } else {

                    JOptionPane.showMessageDialog(null, "Error !");
                }

                st.close();
                con.c.close();

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b4) {

            this.setVisible(false);
            new Home().setVisible(true);
            
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new IssueBook().setVisible(true);
    }
}
