import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Issue_Student extends JInternalFrame {
	Date now,now1;
	
	private JButton btnIssue;
	private JLabel lblStudentId;
	private JComboBox comboBox;
	private JLabel lblBookId;
	private JTextField textField;
	
	void issueBook1()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
			String str="update book set copies=copies-1 where bookid=?";
			PreparedStatement st=cn.prepareStatement(str);
			st.setInt(1,Integer.parseInt(comboBox.getSelectedItem().toString()));
			st.executeUpdate();
			cn.close();
			issueBook2();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	void issueBook2()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
			String str="update book set status='Unavailable' where copies=0";
			PreparedStatement st=cn.prepareStatement(str);
			//st.setInt(1,Integer.parseInt(comboBox.getSelectedItem().toString()));
			st.executeUpdate();
			cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	void fill()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
		String str="select bookid from book where Copies>0";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
		DefaultComboBoxModel dc=new DefaultComboBoxModel();
		while(rs.next())
		{
			dc.addElement(rs.getString(1));
		}
		cn.close();
		comboBox.setModel(dc);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public Issue_Student() {
		setBounds(0, 0, 450, 300);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(46, 40, 47, 26);
		getContentPane().add(lblBookId);
		
		comboBox = new JComboBox();
		comboBox.setBounds(214, 43, 110, 20);
		getContentPane().add(comboBox);
		
		lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(46, 116, 61, 26);
		getContentPane().add(lblStudentId);
		
		btnIssue = new JButton("Issue");
		
		
		btnIssue.addActionListener(new ActionListener() {
			public Date addDays(Date d,int days)
			{
				d.setTime(d.getTime()+days*1000*60*60*24);
				return d;
			}
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
					String str="insert into issue(Bid,Sid,Issue_Date,Return_Date) values(?,?,?,?)";				
					PreparedStatement st=cn.prepareStatement(str);
					
					st.setInt(1,Integer.parseInt(comboBox.getSelectedItem().toString()));
					
					st.setString(2,textField.getText());
					
					java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String currentTime=sdf.format(new Date());
					st.setString(3, currentTime);
					now=new Date();
					now1=new Date();
					now1=addDays(now1,15);
					DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					String ret_date=dateFormat.format(now1);
					st.setString(4, ret_date);
					
					st.executeUpdate();
					cn.close();
					textField.setText("");
					issueBook1();
					issueBook2();
					fill();
					JOptionPane.showMessageDialog(null, "Book has been issued successfully!");
					}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				}
			});
		btnIssue.setBounds(163, 212, 89, 23);
		getContentPane().add(btnIssue);
		
		textField = new JTextField();
		textField.setBounds(214, 119, 110, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		fill();
		
	}
}
