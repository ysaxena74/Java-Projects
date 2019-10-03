import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;


public class Return_Student extends JInternalFrame {
	private JTable table;
	private JLabel lblEnrollmentNo;
	private JTextField textField;
	private JLabel lblBookId;
	private JTextField textField_1;
	private JButton btnReturnBook;
	void issueBook2()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
			String str="update book set status='Available' where copies>0";
			PreparedStatement st=cn.prepareStatement(str);
			st.executeUpdate();
			cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	void issueBook()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
			String str="update book set copies=copies+1 where bookid=?";
			PreparedStatement st=cn.prepareStatement(str);
			st.setInt(1,Integer.parseInt(textField_1.getText()));
			st.executeUpdate();
			cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	/*void fill()
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
		st.executeQuery();
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
		String str="select * from issue where Sid like '"+s+"%'";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("Serial No.");
		dc.addColumn("Book ID");
		dc.addColumn("Student Id");
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
	}*/

		public Return_Student() {
		setBounds(0, 0, 450, 300);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		lblEnrollmentNo = new JLabel("Enrollment No.");
		lblEnrollmentNo.setBounds(50, 35, 99, 28);
		getContentPane().add(lblEnrollmentNo);
		
		textField = new JTextField();
		textField.setBounds(190, 39, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(50, 84, 99, 28);
		getContentPane().add(lblBookId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 88, 200, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			String eno,id;
			int flag=0;
			eno=textField.getText();
			id=textField_1.getText();
			int e,i;
			e=Integer.parseInt(textField.getText());
			i=Integer.parseInt(textField_1.getText());
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
			String str="select * from issue";
			PreparedStatement st=cn.prepareStatement(str);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				
				if(rs.getString(2).equals(id) && rs.getString(3).equals(eno))
				{
					java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
					String str1=sdf.format(new Date());
					
					Date currentTime=sdf.parse(str1);
					Date ret_date=sdf.parse(rs.getString(5));
					
					int a=currentTime.compareTo(ret_date);
					issueBook();
					if(a>0)
					{
						JOptionPane.showMessageDialog(null,"Book Has Been Returned With The Fine Of Rs."+a*10);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Book Has Been Returned Successfully");
					}
					
					String str2="delete from issue where Sid="+e+" and Bid="+i;
					PreparedStatement st1=cn.prepareStatement(str2);
					st1.executeUpdate();
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(null,"Book Has Not Been Issued Yet From This Enrollment No.");
			}
			cn.close();
			issueBook2();
			textField.setText("");
			textField_1.setText("");
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			}
		});
		btnReturnBook.setBounds(150, 236, 124, 23);
		getContentPane().add(btnReturnBook);
	}
}
