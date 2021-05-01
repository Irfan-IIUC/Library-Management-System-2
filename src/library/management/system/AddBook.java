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

public class AddBook extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5, t6;
    private JButton b1, b2;
    JComboBox cb;

    AddBook() {

        super("Add Book");
        
        JLabel l0 = new JLabel("Add Book");
        l0.setForeground(Color.BLUE);
        l0.setFont(new Font("serif", Font.PLAIN, 20));
        l0.setBounds(180, 10, 195, 30);
        add(l0);

        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(73, 84, 90, 22);
        add(l1);

        JLabel l2 = new JLabel("ISBN");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(73, 117, 90, 22);
        add(l2);

        JLabel l3 = new JLabel("Publisher");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(73, 150, 90, 22);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(73, 216, 90, 22);
        add(l4);

        JLabel l5 = new JLabel("Pages");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(73, 249, 90, 22);
        add(l5);

        JLabel l6 = new JLabel("Book_id");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(73, 51, 90, 22);
        add(l6);

        JLabel l7 = new JLabel("Edition");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(73, 183, 90, 22);
        add(l7);

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

        t4 = new JTextField();
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setColumns(10);
        t4.setBounds(169, 153, 198, 20);
        add(t4);

        t5 = new JTextField();
        t5.setFont(new Font("serif", Font.PLAIN, 17));
        t5.setColumns(10);
        t5.setBounds(169, 219, 198, 20);
        add(t5);

        t6 = new JTextField();
        t6.setFont(new Font("serif", Font.PLAIN, 17));
        t6.setColumns(10);
        t6.setBounds(169, 252, 198, 20);
        add(t6);

        cb = new JComboBox();
        cb.setFont(new Font("serif", Font.PLAIN, 17));
        cb.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        cb.setBounds(173, 186, 194, 20);
        add(cb);

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
                String sql = "insert into book(book_id, name, isbn, publisher, edition, price, pages) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t4.getText());
                st.setString(5, (String) cb.getSelectedItem());
                st.setString(6, t5.getText());
                st.setString(7, t6.getText());

                int rs = st.executeUpdate();

                if (rs > 0) {

                    JOptionPane.showMessageDialog(null, "Book Added Successfully");

                } else {

                    JOptionPane.showMessageDialog(null, "Error !");
                }

                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);
                t6.setText(null);

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

        new AddBook().setVisible(true);
    }
}
