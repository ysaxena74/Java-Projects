import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class AddBook extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton rdbtnUnavailable;
	private JRadioButton rdbtnAvailable;

	public AddBook() {
		setBounds(0, 0, 501, 343);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(75, 48, 56, 14);
		getContentPane().add(lblBookId);
		
		textField = new JTextField();
		textField.setBounds(191, 45, 146, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(75, 86, 71, 14);
		getContentPane().add(lblBookName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 83, 146, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAuthorName = new JLabel("Author Name");
		lblAuthorName.setBounds(75, 124, 79, 14);
		getContentPane().add(lblAuthorName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 121, 146, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(75, 165, 46, 14);
		getContentPane().add(lblEdition);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 162, 146, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPrintingYear = new JLabel("Printing Year");
		lblPrintingYear.setBounds(75, 206, 95, 14);
		getContentPane().add(lblPrintingYear);
		
		textField_4 = new JTextField();
		textField_4.setBounds(191, 203, 146, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCopies = new JLabel("Copies");
		lblCopies.setBounds(75, 245, 46, 14);
		getContentPane().add(lblCopies);
		
		textField_5 = new JTextField();
		textField_5.setBounds(191, 242, 146, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(75, 288, 56, 14);
		getContentPane().add(lblStatus);
		
		rdbtnAvailable = new JRadioButton("Available");
		rdbtnAvailable.setBounds(185, 284, 79, 23);
		getContentPane().add(rdbtnAvailable);
		
		rdbtnUnavailable = new JRadioButton("Unavailable");
		rdbtnUnavailable.setBounds(272, 284, 109, 23);
		getContentPane().add(rdbtnUnavailable);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnAvailable);
		bg.add(rdbtnUnavailable);
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://Localhost/Library?user=root&password=jaishrimataji");
					String str="insert into Book values(?,?,?,?,?,?,?)";
					PreparedStatement st=cn.prepareStatement(str);
					st.setInt(1,Integer.parseInt(textField.getText()));
					st.setString(2,textField_1.getText());
					st.setString(3, textField_2.getText());
					st.setInt(4, Integer.parseInt(textField_3.getText()));
					st.setInt(5, Integer.parseInt(textField_4.getText()));
					st.setInt(6, Integer.parseInt(textField_5.getText()));
					if(rdbtnAvailable.isSelected())
						st.setString(7,"Available");
					else
						st.setString(7,"Unavaliable");
					st.executeUpdate();
					cn.close();
					JOptionPane.showMessageDialog(null,"Data Saved");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		btnNewButton.setBounds(386, 44, 89, 23);
		getContentPane().add(btnNewButton);
		}
}
