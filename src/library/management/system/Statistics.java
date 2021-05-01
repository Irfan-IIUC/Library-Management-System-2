package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

public class Statistics extends JFrame {

    private JPanel p1, p2;
    private JTable t0, t1;

    Statistics() {

        super("Statistics");

        p1 = new JPanel();
        p1.setBorder(new TitledBorder(new LineBorder(Color.RED, 2, true), "Issue-Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        p1.setBounds(26, 36, 737, 240);
        add(p1);
        
        JScrollPane sp = new JScrollPane();
	sp.setBounds(40, 60, 708, 217);
	add(sp);

        t0 = new JTable();
        t0.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        sp.setViewportView(t0);

        JLabel l1 = new JLabel("Back");

        l1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {

                setVisible(false);
                new Home().setVisible(true);

            }
        });

        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
        l1.setBounds(690, 13, 96, 27);
        add(l1);

        p2 = new JPanel();
        p2.setBorder(new TitledBorder(new LineBorder(Color.RED, 2, true), "Return-Book-Details",
                TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLUE));
        p2.setBounds(22, 299, 741, 240);
        add(p2);
        
        JScrollPane sp1 = new JScrollPane();
	sp1.setBounds(40, 326, 708, 217);
	add(sp1);

        t1 = new JTable();
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        sp1.setViewportView(t1);

        issueBook();
        returnBook();

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setSize(795, 594);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void issueBook() {

        try {

            conn con = new conn();
            String sql = "select * from issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            t0.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    public void returnBook() {

        try {

            conn con = new conn();
            String sql = "select * from returnBook";
            PreparedStatement st = con.c.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new Statistics().setVisible(true);
    }
}
