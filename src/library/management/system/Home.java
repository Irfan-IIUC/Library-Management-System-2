package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

public class Home extends JFrame implements ActionListener {

    private JButton b1, b2, b3, b4, b5, b6;

    Home() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLUE, Color.BLUE));
        menuBar.setBounds(4, 10, 765, 30);
        add(menuBar);

        JMenu mnRecord = new JMenu("Record");
        mnRecord.setFont(new Font("serif", Font.PLAIN, 17));

        JMenuItem bookdetails = new JMenuItem("Book Details");
        bookdetails.addActionListener(this);
        mnRecord.add(bookdetails);

        JMenuItem studentdetails = new JMenuItem("Student Details");
        studentdetails.addActionListener(this);
        mnRecord.add(studentdetails);

        JMenu mnHelp = new JMenu("Help");
        mnHelp.setFont(new Font("serif", Font.PLAIN, 17));

        JMenuItem mntmReadme = new JMenuItem("Read Me");
        mntmReadme.addActionListener(this);
        mnHelp.add(mntmReadme);

        JMenuItem mntmAboutUs = new JMenuItem("About Us");
        mntmAboutUs.addActionListener(this);
        mnHelp.add(mntmAboutUs);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("serif", Font.PLAIN, 17));

        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);

        menuBar.add(mnRecord);
        menuBar.add(mnHelp);
        menuBar.add(mnExit);

        JLabel l1 = new JLabel("Library Management System");
        l1.setFont(new Font("serif", Font.PLAIN, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(230, 30, 701, 80);
        add(l1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(60, 100, 159, 152);
        add(l2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/third.png"));
        Image i5 = i4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(320, 120, 134, 128);
        add(l3);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fourth.png"));
        Image i8 = i7.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(530, 100, 225, 152);
        add(l4);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fifth.png"));
        Image i11 = i10.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l5 = new JLabel(i12);
        l5.setBounds(60, 300, 159, 163);
        add(l5);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/sixth.png"));
        Image i14 = i13.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l6 = new JLabel(i15);
        l6.setBounds(320, 300, 139, 152);
        add(l6);

        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/seventh.png"));
        Image i17 = i16.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i18 = new ImageIcon(i17);
        JLabel l7 = new JLabel(i18);
        l7.setBounds(562, 300, 157, 152);
        add(l7);

        b1 = new JButton("Add Books");
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.addActionListener(this);
        b1.setBounds(70, 260, 130, 35);
        add(b1);

        b2 = new JButton("Statistics");
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.addActionListener(this);
        b2.setBounds(320, 260, 130, 35);
        add(b2);

        b3 = new JButton("Add Student");
        b3.setFont(new Font("serif", Font.PLAIN, 17));
        b3.addActionListener(this);
        b3.setBounds(575, 260, 130, 35);
        add(b3);

        b4 = new JButton("Issue Book");
        b4.setFont(new Font("serif", Font.PLAIN, 17));
        b4.addActionListener(this);
        b4.setBounds(76, 465, 130, 35);
        add(b4);

        b5 = new JButton("Return Book");
        b5.setFont(new Font("serif", Font.PLAIN, 17));
        b5.addActionListener(this);
        b5.setBounds(320, 465, 130, 35);
        add(b5);

        b6 = new JButton("About Us");
        b6.setFont(new Font("serif", Font.PLAIN, 17));
        b6.addActionListener(this);
        b6.setBounds(575, 465, 130, 35);
        add(b6);

        setLayout(null);
        setSize(780, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Home");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String msg = ae.getActionCommand();

        if (msg.equals("Logout")) {

            this.setVisible(false);
            new Login_user().setVisible(true);

        } else if (msg.equals("Exit")) {

            System.exit(ABORT);

        } else if (msg.equals("Read Me")) {

            this.setVisible(false);
            new ReadMe().setVisible(true);

        } else if (msg.equals("About Us")) {

            this.setVisible(false);
            new AboutUs().setVisible(true);

        } else if (msg.equals("Book Details")) {

            this.setVisible(false);
            new BookDetails().setVisible(true);

        } else if (msg.equals("Student Details")) {

            this.setVisible(false);
            new StudentDetails().setVisible(true);

        } else if (ae.getSource() == b1) {

            this.setVisible(false);
            new AddBook().setVisible(true);

        } else if (ae.getSource() == b2) {

            this.setVisible(false);
            new Statistics().setVisible(true);

        } else if (ae.getSource() == b3) {

            this.setVisible(false);
            new AddStudent().setVisible(true);

        } else if (ae.getSource() == b4) {

            this.setVisible(false);
            new IssueBook().setVisible(true);

        } else if (ae.getSource() == b5) {

            this.setVisible(false);
            new ReturnBook().setVisible(true);

        } else if (ae.getSource() == b6) {

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new Home().setVisible(true);
    }
}
