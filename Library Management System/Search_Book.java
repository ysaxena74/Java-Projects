import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Search_Book extends JInternalFrame {
	private JTextField textField;
	private JTable table;


	void fill()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
		String str="select * from Book";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("Book ID");
		dc.addColumn("Book Name");
		dc.addColumn("Author Name");
		dc.addColumn("Edition");
		dc.addColumn("Printing Year");
		dc.addColumn("Copies");
		dc.addColumn("Status");
		
		while(rs.next())
		{
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
		}
		table.setModel(dc);
		cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	void fill(String s)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
		String str="select * from Book where Book_Name like '"+s+"%'";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("Book ID");
		dc.addColumn("Book Name");
		dc.addColumn("Author Name");
		dc.addColumn("Edition");
		dc.addColumn("Printing Year");
		dc.addColumn("Copies");
		dc.addColumn("Status");
		
		while(rs.next())
		{
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
		}
		table.setModel(dc);
		cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public Search_Book() {
		setBounds(0, 0, 501, 343);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
			getContentPane().setLayout(new BorderLayout(0, 0));
						
			table = new JTable();
			getContentPane().add(table,BorderLayout.CENTER);
			
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					String ss=textField.getText();
					fill(ss);
				}
			});
			getContentPane().add(textField, BorderLayout.NORTH);
			textField.setColumns(10);
			fill();
	}
}
		
