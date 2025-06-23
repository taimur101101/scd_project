package ui;

import service.LibraryService;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryGUI extends JFrame {

	private LibraryService service = new LibraryService();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI frame = new LibraryGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	public LibraryGUI() {
		setForeground(new Color(255, 255, 255));
		setTitle("Basic Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350); 
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Enter Book Title:");
		lblNewLabel.setBounds(28, 32, 124, 21);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(136, 33, 200, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Add Book");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText().trim();
				String result = service.addBook(title);
				textArea.setText(result);
				textField.setText("");
			}
		});
		btnAdd.setBackground(new Color(128, 255, 128));
		btnAdd.setBounds(10, 78, 103, 21);
		contentPane.add(btnAdd);

		JButton btnBorrow = new JButton("Borrow Book");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.borrowBook(title);
				textArea.setText(result);
				textField.setText("");
			}
		});
		btnBorrow.setBackground(new Color(128, 255, 128));
		btnBorrow.setBounds(123, 78, 130, 21);
		contentPane.add(btnBorrow);

		JButton btnReturn = new JButton("Return Book");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText().trim();
				String result = service.returnBook(title);
				textArea.setText(result);
				textField.setText("");
			}
		});
		btnReturn.setBackground(new Color(128, 255, 128));
		btnReturn.setBounds(263, 78, 120, 21);
		contentPane.add(btnReturn);

		JButton btnSearch = new JButton("Search Book");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String result = service.searchBook(title);
				textArea.setText(result);
				textField.setText("");
			}
		});
		btnSearch.setBackground(new Color(128, 255, 128));
		btnSearch.setBounds(10, 120, 140, 21);
		contentPane.add(btnSearch);

		JButton btnList = new JButton("List Available Books");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = service.getAvailableBook();  
				textArea.setText(result);
			}
		});
		btnList.setBackground(new Color(128, 255, 128));
		btnList.setBounds(160, 120, 230, 21);
		contentPane.add(btnList);

		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setBounds(10, 160, 59, 13);
		contentPane.add(lblOutput);

		textArea = new JTextArea();
		textArea.setBounds(66, 180, 390, 80);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(66, 180, 390, 80);
		contentPane.add(scrollPane);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
			}
		});
		btnClear.setBackground(new Color(128, 255, 255));
		btnClear.setBounds(200, 270, 85, 21);
		contentPane.add(btnClear);
	}
}
