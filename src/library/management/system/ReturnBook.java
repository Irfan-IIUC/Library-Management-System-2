package library.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class ReturnBook extends JFrame implements ActionListener {

    private JPanel p1, p2;
    private JTextField t0, t1, t2, t3, t4, t5, t6;
    private JButton b1, b2, b3;
    private JDateChooser dc;

    ReturnBook() {

        super("Return Book");

        JLabel lblNewLabel = new JLabel("Book_id");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(52, 52, 87, 24);
        add(lblNewLabel);

        JLabel lblStudentid = new JLabel("Student_id");
        lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStudentid.setBounds(270, 52, 87, 24);
        add(lblStudentid);

        JLabel lblBook = new JLabel("Book");
        lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBook.setBounds(52, 98, 71, 24);
        add(lblBook);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(303, 98, 71, 24);
        add(lblName);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourse.setBounds(52, 143, 87, 24);
        add(lblCourse);

        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBranch.setBounds(303, 144, 68, 24);
        add(lblBranch);

        JLabel lblDateOfIssue = new JLabel("Date of Issue");
        lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDateOfIssue.setBounds(52, 188, 105, 29);
        add(lblDateOfIssue);

        JLabel lblDateOfReturn = new JLabel("Date of Return");
        lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDateOfReturn.setBounds(52, 234, 118, 29);
        add(lblDateOfReturn);

        t0 = new JTextField();
        t0.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t0.setBounds(128, 56, 100, 20);
        add(t0);
        t0.setColumns(10);

        t1 = new JTextField();
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(369, 56, 100, 20);
        add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        t2.setBounds(128, 102, 162, 20);
        add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        t3.setColumns(10);
        t3.setBounds(369, 102, 179, 20);
        add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        t4.setColumns(10);
        t4.setBounds(128, 147, 162, 20);
        add(t4);

        t5 = new JTextField();
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        t5.setEditable(false);
        t5.setColumns(10);
        t5.setBounds(369, 147, 179, 20);
        add(t5);

        t6 = new JTextField();
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        t6.setEditable(false);
        t6.setColumns(10);
        t6.setBounds(167, 194, 123, 20);
        add(t6);

        b1 = new JButton("Search");
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.addActionListener(this);
        b1.setBounds(475, 52, 70, 29);
        add(b1);

        b2 = new JButton("Return");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(369, 190, 120, 29);
        add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBounds(369, 234, 120, 29);
        add(b3);

        dc = new JDateChooser();
        dc.setBounds(167, 239, 163, 20);
        add(dc);

        p1 = new JPanel();
        p1.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0), 2, true), "Return-Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
        p1.setBounds(25, 20, 550, 269);
        add(p1);

        setLayout(null);
        setSize(610, 345);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {

                conn con = new conn();
                String sql = "select * from issueBook where book_id = ? and student_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t0.getText());
                st.setString(2, t1.getText());

                ResultSet rs = st.executeQuery();

                while (rs.next()) {

                    t2.setText(rs.getString("bname"));
                    t3.setText(rs.getString("sname"));
                    t4.setText(rs.getString("course"));
                    t5.setText(rs.getString("branch"));
                    t6.setText(rs.getString("dateOfIssue"));
                }

                st.close();
                con.c.close();

            } catch (Exception e) {

                e.printStackTrace();
                
            }

        } else if (ae.getSource() == b2) {

            try{
                
                conn con = new conn();
                String sql = "insert into returnBook(book_id, student_id, bname, sname, course, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, t0.getText());
                st.setString(2, t1.getText());
                st.setString(3, t2.getText());
                st.setString(4, t3.getText());
                st.setString(5, t4.getText());
                st.setString(6, t5.getText());
                st.setString(7, t6.getText());
                st.setString(8, ((JTextField) dc.getDateEditor().getUiComponent()).getText());
                
                int a = st.executeUpdate();
                
                if(a>0){
                    
                    JOptionPane.showMessageDialog(null, "Processing...");
                    delete();
                    
                } else{
                    
                    JOptionPane.showMessageDialog(null, "Error !");
                    
                }
                
                st.close();
                con.c.close();
                
            } catch(Exception e){
                
                e.printStackTrace();
                
            }
            
        } else if (ae.getSource() == b3) {

            this.setVisible(false);
            new Home().setVisible(true);

        }
    }
    
    public void delete(){
        
        try{
            
            conn con = new conn();
            String sql = "delete from issueBook where book_id = ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            
            st.setString(1, t0.getText());
            
            int a = st.executeUpdate();
            
            if(a == 1){
                
                JOptionPane.showMessageDialog(null, "Book Returned Successfuly");
                
            } else{
                
                 JOptionPane.showMessageDialog(null, "Error !");
                 
            }
            
            st.close();
            con.c.close();
            
        } catch(Exception e){
            
            e.printStackTrace();
            
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new ReturnBook().setVisible(true);
    }
}
