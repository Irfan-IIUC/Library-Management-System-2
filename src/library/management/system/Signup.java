package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Signup extends JFrame implements ActionListener{

    private JTextField t1, t2, t3, t4;
    private JButton b1, b2;
    private JComboBox c1;

    Signup() {

        super("Sign-up");

        JLabel l0 = new JLabel("Create Account");
        l0.setForeground(Color.BLUE);
        l0.setFont(new Font("serif", Font.PLAIN, 25));
        l0.setBounds(195, 25, 170, 30);
        add(l0);
        
        JLabel l1 = new JLabel("Username :");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(99, 86, 92, 26);
        add(l1);

        JLabel l2 = new JLabel("Name :");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(99, 123, 92, 26);
        add(l2);

        JLabel l3 = new JLabel("Password :");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(99, 160, 92, 26);
        add(l3);

        JLabel l4 = new JLabel("Answer :");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(99, 234, 92, 26);
        add(l4);

        JLabel l5 = new JLabel("Security Question :");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(99, 197, 140, 26);
        add(l5);

        c1 = new JComboBox();
        c1.setModel(new DefaultComboBoxModel(new String[]{"Your NickName",
            "Your Lucky Number", "Your child SuperHero", "Your childhood Name"}));

        c1.setFont(new Font("serif", Font.PLAIN, 17));
        c1.setBounds(265, 202, 180, 20);
        add(c1);

        t1 = new JTextField();
        t1.setFont(new Font("serif", Font.PLAIN, 17));
        t1.setBounds(265, 91, 180, 20);
        add(t1);

        t2 = new JTextField();
        t2.setFont(new Font("serif", Font.PLAIN, 17));
        t2.setBounds(265, 128, 180, 20);
        add(t2);

        t3 = new JTextField();
        t3.setFont(new Font("serif", Font.PLAIN, 17));
        t3.setBounds(265, 165, 180, 20);
        add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("serif", Font.PLAIN, 17));
        t4.setBounds(265, 239, 180, 20);
        add(t4);
        
        b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("serif", Font.PLAIN, 17));
	b1.setBounds(140, 289, 100, 30);
        add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("serif", Font.PLAIN, 17));
	b2.setBounds(300, 289, 100, 30);
	add(b2);

        setLayout(null);
        setSize(555, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            try{
                
                conn con = new conn();
                
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
                
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, (String) c1.getSelectedItem());
                st.setString(5, t4.getText());
                
                int i = st.executeUpdate();
                
                if(i>0){
                    
                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                }
                
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if(ae.getSource() == b2){
            
            this.setVisible(false);
            new Login_user().setVisible(true);
            
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new Signup().setVisible(true);
    }
}
