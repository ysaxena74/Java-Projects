import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class MDIHome extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MDIHome frame = new MDIHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public MDIHome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnBooks = new JMenu("Books");
		menuBar.add(mnBooks);
		
		JMenuItem mntmAddNewBook = new JMenuItem("Add New Book");
		mntmAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBook ad=new AddBook();
				desktopPane.add(ad);
				ad.setVisible(true);
			}
		});
		mnBooks.add(mntmAddNewBook);
		
		JMenuItem mntmSearchBook = new JMenuItem("Search Book");
		mntmSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search_Book sb=new Search_Book();
				desktopPane.add(sb);
				sb.setVisible(true);
			}
		});
		mnBooks.add(mntmSearchBook);
		
		JMenu mnStudent = new JMenu("Student");
		menuBar.add(mnStudent);
		
		JMenuItem mntmIssue = new JMenuItem("Issue");
		mntmIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Issue_Student is=new Issue_Student();
			desktopPane.add(is);
			is.setVisible(true);
			}
		});
		mnStudent.add(mntmIssue);
		
		JMenuItem menuItem = new JMenuItem("Return");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Return_Student rst=new Return_Student();
				desktopPane.add(rst);
				rst.setVisible(true);
			}
		});
		
		mnStudent.add(menuItem);
		
		JMenu mnFaculty = new JMenu("Faculty");
		menuBar.add(mnFaculty);
		
		JMenuItem mntmIssue_1 = new JMenuItem("Issue");
		mnFaculty.add(mntmIssue_1);
		
		JMenuItem mntmReturn = new JMenuItem("Return");
		mnFaculty.add(mntmReturn);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmStudentIssueFile = new JMenuItem("Student Issue File");
		mntmStudentIssueFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			issue_File_Student ifs=new issue_File_Student();
			desktopPane.add(ifs);
			ifs.setVisible(true);
			}
		});
		mnView.add(mntmStudentIssueFile);
		
		JMenuItem mntmFacultyIssueFile = new JMenuItem("Faculty Issue File");
		mnView.add(mntmFacultyIssueFile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			JOptionPane.showMessageDialog(null,"Logged Out Successfully");
			
			}
		});
		contentPane.add(btnLogout, BorderLayout.SOUTH);
	}
}
