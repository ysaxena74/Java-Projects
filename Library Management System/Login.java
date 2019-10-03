import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JDesktopPane desktopPane;
	String ss="",pass="";
	int i=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.GREEN);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setBounds(150, 28, 184, 14);
		contentPane.add(lblLibraryManagementSystem);
		
		JLabel lblNewLabel = new JLabel("Login ID");
		lblNewLabel.setBounds(68, 102, 82, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(68, 151, 82, 24);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(261, 104, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				ss=ss+"*";
				pass=pass+textField_1.getText().charAt(i);
				i++;
				textField_1.setText(ss);
			
			}
		});
		
		textField_1.setBounds(261, 153, 116, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
			if(textField.getText().equals("MyLibraryWork") && pass.equals("rishavrocks"))
			{
				JOptionPane.showMessageDialog(null,"Loading...Please Wait");
				JOptionPane.showMessageDialog(null,"Logged in Successfully");
				MDIHome mdi=new MDIHome();
				mdi.setVisible(true);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Authentication Failure.");
			}
			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnLogin.setBounds(176, 227, 89, 23);
		contentPane.add(btnLogin);
	}
}
