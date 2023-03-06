package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class AdminActivity extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActivity frame = new AdminActivity();
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
	public AdminActivity() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminActivity.class.getResource("/icons/settings-gears.png")));
		setForeground(Color.BLACK);
		setType(Type.POPUP);
		setTitle("Admin Activity");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847,505 );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239, 239, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CUSTOMER");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerFrame customer=new CustomerFrame();
				customer.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminActivity.class.getResource("/icons/customer-loyalty.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(79, 87, 154, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SALES");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SalesFrame sales=new SalesFrame();
				sales.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminActivity.class.getResource("/icons/increase.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_1.setBounds(79, 235, 154, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MEMBERS");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MemberFrame member=new MemberFrame();
				member.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_2.setIcon(new ImageIcon(AdminActivity.class.getResource("/icons/team.png")));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_2.setBounds(598, 87, 154, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("MENU");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				MenuFrame menu=new MenuFrame();
				menu.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_3.setIcon(new ImageIcon(AdminActivity.class.getResource("/icons/menu.png")));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_3.setBounds(598, 235, 154, 46);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame login=new LoginFrame();
				login.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_4.setIcon(new ImageIcon(AdminActivity.class.getResource("/icons/power.png")));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_4.setBounds(339, 392, 168, 51);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AdminActivity.class.getResource("/icons/communication.png")));
		lblNewLabel.setBounds(268, 87, 306, 276);
		contentPane.add(lblNewLabel);
		
		
	}
}
