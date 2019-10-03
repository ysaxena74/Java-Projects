import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
public class issue_File_Student extends JInternalFrame {
	private JTable table;
	
	void fill()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
		String str="select * from issue";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("Serial No.");
		dc.addColumn("Book ID");
		dc.addColumn("Student ID");
		dc.addColumn("Issue Date");
		dc.addColumn("Return Date");
	
		while(rs.next())
		{
				
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
		}
		table.setModel(dc);
		cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public issue_File_Student() {
		setBounds(0, 0, 450, 300);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.CENTER);
		fill();
	}

}
