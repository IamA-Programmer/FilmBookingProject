package com.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;



public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/icons/login.png")));
		setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Login Form");
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239, 239, 241));
		contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/icons/key.png")));
		lblNewLabel.setBounds(56, 103, 333, 278);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(478, 80, 188, 42);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setToolTipText("Username");
		textField.setBounds(417, 133, 303, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(478, 226, 188, 42);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBounds(417, 279, 303, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(106, 43, 236, 49);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFocusable(false);
		btnNewButton.setMnemonic('L');
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if((textField.getText().equals(""))||(passwordField.getText().equals(""))) {
					System.out.print("Clicked Login Button");
					JOptionPane.showMessageDialog(null,"Invalid Username or Password!!","Oops an Error Occured!!",JOptionPane.ERROR_MESSAGE, null);
					textField.requestFocus();
				}
				else {
					AdminActivity adminwindow=new AdminActivity();
					adminwindow.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/icons/login(1).png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(106, 392, 171, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton.setFocusable(false);
		btnNewButton_1.setMnemonic('R');
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				textField.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/icons/synchronize.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(337, 392, 155, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setMnemonic('C');
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/icons/cancel.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(555, 392, 130, 44);
		contentPane.add(btnNewButton_2);
		
	}
}
