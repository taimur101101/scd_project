package ui;

import service.LibraryService;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class LibraryGUI {

	private LibraryService service = new LibraryService();
	private JFrame frmLibraryBookSystem;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI window = new LibraryGUI();
					window.frmLibraryBookSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibraryBookSystem = new JFrame();
		frmLibraryBookSystem.setTitle("Library Book System");
		frmLibraryBookSystem.setBounds(100, 100, 450, 300);
		frmLibraryBookSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryBookSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Book Title:");
		lblNewLabel.setBounds(21, 24, 111, 13);
		frmLibraryBookSystem.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 21, 235, 19);
		frmLibraryBookSystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.addBook(title);
				textArea.setText(result);
				textField.setText("");

			}
		});
		btnNewButton.setBackground(new Color(128, 255, 128));
		btnNewButton.setBounds(21, 71, 96, 21);
		frmLibraryBookSystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrow Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.borrowBook(title);
				textArea.setText(result);
				textField.setText("");

			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setBounds(144, 71, 127, 21);
		frmLibraryBookSystem.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Return Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.returnBook(title);
				textArea.setText(result);
				textField.setText("");

			}
		});
		btnNewButton_2.setBackground(new Color(128, 255, 128));
		btnNewButton_2.setBounds(294, 71, 132, 21);
		frmLibraryBookSystem.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.searchBook(title);
				textArea.setText(result);
				textField.setText("");

			}
		});
		btnNewButton_3.setBackground(new Color(128, 255, 128));
		btnNewButton_3.setBounds(21, 115, 127, 21);
		frmLibraryBookSystem.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("List Available Books");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.getAvailableBook();
				textArea.setText(result);
				textField.setText("");

			}
		});
		btnNewButton_4.setBackground(new Color(128, 255, 128));
		btnNewButton_4.setBounds(174, 115, 205, 21);
		frmLibraryBookSystem.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("Output:");
		lblNewLabel_1.setBounds(21, 155, 75, 13);
		frmLibraryBookSystem.getContentPane().add(lblNewLabel_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 162, 240, 60);
		frmLibraryBookSystem.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
			}
		});
		btnNewButton_5.setBackground(new Color(128, 255, 255));
		btnNewButton_5.setBounds(198, 232, 85, 21);
		frmLibraryBookSystem.getContentPane().add(btnNewButton_5);
	}
}
