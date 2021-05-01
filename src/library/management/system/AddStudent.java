package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddStudent extends JFrame implements ActionListener {

    private JTextField t1, t2, t3;
    private JButton b1, b2;
    private JComboBox cb0, cb1, cb2, cb3;

    AddStudent() {

        super("Add Student");

        JLabel l0 = new JLabel("Add Student");
        l0.setForeground(Color.BLUE);
        l0.setFont(new Font("serif", Font.PLAIN, 20));
        l0.setBounds(175, 10, 195, 30);
        add(l0);

        JLabel l6 = new JLabel("Student ID");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(73, 51, 90, 22);
        add(l6);

        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(73, 84, 90, 22);
        add(l1);

        JLabel l2 = new JLabel("Father Name");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(73, 117, 90, 22);
        add(l2);

        JLabel l3 = new JLabel("Course");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(73, 150, 90, 22);
        add(l3);

        JLabel l7 = new JLabel("Department");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(73, 183, 90, 22);
        add(l7);

        JLabel l4 = new JLabel("Year");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(73, 216, 90, 22);
        add(l4);

        JLabel l5 = new JLabel("Semester");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(73, 249, 90, 22);
        add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(169, 54, 198, 20);
        add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setColumns(10);
        t2.setBounds(169, 87, 198, 20);
        add(t2);

        t3 = new JTextField();
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setColumns(10);
        t3.setBounds(169, 120, 198, 20);
        add(t3);

        cb0 = new JComboBox();
        cb0.setModel(new DefaultComboBoxModel(new String[]{"B.Tech", "M.Tech", "MBA", "BBA", "B.Sc", "M.Sc", "B.Com", "M.Com"}));
        cb0.setFont(new Font("serif", Font.PLAIN, 17));
        cb0.setBounds(169, 153, 198, 20);
        add(cb0);

        cb1 = new JComboBox();
        cb1.setModel(new DefaultComboBoxModel(new String[]{"CSE", "EEE", "ETE", "URP", "QSIS", "ME", "MBA", "IPE", "BBA"}));
        cb1.setFont(new Font("serif", Font.PLAIN, 17));
        cb1.setBounds(169, 186, 198, 20);
        add(cb1);

        cb2 = new JComboBox();
        cb2.setModel(new DefaultComboBoxModel(new String[]{"First", "Second", "Third", "Fourth"}));
        cb2.setFont(new Font("serif", Font.PLAIN, 17));
        cb2.setBounds(169, 219, 198, 20);
        add(cb2);

        cb3 = new JComboBox();
        cb3.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
        cb3.setFont(new Font("serif", Font.PLAIN, 17));
        cb3.setBounds(169, 252, 198, 20);
        add(cb3);

        b1 = new JButton("Add");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.addActionListener(this);
        b1.setBounds(73, 300, 100, 30);
        add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.addActionListener(this);
        b2.setBounds(267, 300, 100, 30);
        add(b2);

        random();

        setLayout(null);
        setSize(450, 390);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void random() {

        Random rd = new Random();
        t1.setText("" + rd.nextInt(100000 + 1));
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                conn con = new conn();
                String sql = "insert into student(student_id, name, father, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, (String) cb0.getSelectedItem());
                st.setString(5, (String) cb1.getSelectedItem());
                st.setString(6, (String) cb2.getSelectedItem());
                st.setString(7, (String) cb3.getSelectedItem());

                int rs = st.executeUpdate();

                if (rs > 0) {

                    JOptionPane.showMessageDialog(null, "Student Added Successfully");

                } else {

                    JOptionPane.showMessageDialog(null, "Error !");
                }

                t1.setText(null);
                t2.setText(null);
                t3.setText(null);

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == b2) {

            this.setVisible(false);
            new Home().setVisible(true);

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new AddStudent().setVisible(true);
    }
}
