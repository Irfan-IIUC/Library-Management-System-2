package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class BookDetails extends JFrame implements ActionListener {

    private JTable table;
    private JTextField search;
    private JButton b1, b2;

    BookDetails() {

        super("Book Details");

        b1 = new JButton("Search");
        b1.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        b1.setIcon(i3);
        b1.setFont(new Font("serif", Font.PLAIN, 17));
        b1.setBounds(564, 89, 138, 33);
        add(b1);

        b2 = new JButton("Delete");
        b2.addActionListener(this);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);

        b2.setIcon(i6);
        b2.setFont(new Font("serif", Font.PLAIN, 17));
        b2.setBounds(712, 89, 138, 33);
        add(b2);

        JLabel l1 = new JLabel("Book Details");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("serif", Font.PLAIN, 30));
        l1.setBounds(300, 15, 400, 47);
        add(l1);

        search = new JTextField();
        search.setFont(new Font("serif", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");

        l3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                setVisible(false);
                new Home().setVisible(true);

            }
        });

        l3.setFont(new Font("serif", Font.PLAIN, 17));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);

        l3.setIcon(i9);
        l3.setBounds(97, 89, 72, 33);
        add(l3);

        table = new JTable();

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {

                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });

        table.setFont(new Font("serif", Font.PLAIN, 17));
        table.setBackground(new Color(217, 217, 217));
        table.setForeground(Color.BLUE);
        table.setBounds(0, 155, 890, 450);

        add(table);

        book();

        setLayout(null);
        setSize(890, 475);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try{
                
                conn con = new conn();
                String sql = "select * from book where concat(name, book_id) like ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, "%" + search.getText() + "%");
                ResultSet rs = st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                st.close();
                con.c.close();
                
            } catch(Exception e){
                
                System.out.println(e);
            }
            
        } else if (ae.getSource() == b2) {

            try{
                
                conn con = new conn();
                String sql = "delete from book where name = '"+ search.getText() +"'";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(response == JOptionPane.YES_OPTION){
                    
                    int a = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Book Deleted Successfuly");
                }
                
                st.close();
                con.c.close();
                
            } catch(Exception e){
                
                System.out.println(e);
            }
        }
    }

    public void book() {

        try {

            conn con = new conn();

            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

            st.close();
            rs.close();
            con.c.close();

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new BookDetails().setVisible(true);
    }
}
