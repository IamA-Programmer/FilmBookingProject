package com.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutil.DBConnection;
import com.model.Sales;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

 


public class SalesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtDate;
	private JTextField textField_2;
	String query;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesFrame frame = new SalesFrame();
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
	public SalesFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SalesFrame.class.getResource("/icons/shopping-cart.png")));
		getContentPane().setLayout(null);
		setBackground(Color.darkGray);
		setTitle("Sales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SalesFrame.class.getResource("/icons/sales.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 33, 308, 299);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER ID : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(375, 114, 119, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ORDER DATE");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(395, 165, 99, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT ID : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(383, 220, 111, 19);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setToolTipText("Customer ID");
		textField.setBounds(497, 114, 157, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		MemberFrame member=new MemberFrame();
		txtDate = new JTextField();
		txtDate.setForeground(Color.BLACK);
		txtDate.setBounds(497, 165, 157, 21);
	txtDate.setText(member.currentStatus());
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
	
		textField_2 = new JTextField();
		textField_2.setToolTipText("Product ID");
		textField_2.setBounds(497, 220, 157, 21);
	
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Customer_id could not be empty","Oops an error occured",JOptionPane.ERROR_MESSAGE, null);
				}
				else if(txtDate.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"order date should be Today's date","Oops an error occured",JOptionPane.ERROR_MESSAGE, null);
				}
				else if(textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Product_id could not be empty","Oops an error occured",JOptionPane.ERROR_MESSAGE, null);
				}
				else {
				con=DBConnection.getConnection();
				query="INSERT INTO SALES VALUES(?,?,?)";
				Date date=new Date();
				java.sql.Date day=new java.sql.Date(date.getTime());
				
					try {
							ps=con.prepareStatement(query);
							ps.setString(1, textField.getText());
							ps.setDate(2, day);
							ps.setString(3, textField_2.getText());
							
							int added=ps.executeUpdate();
							
							if(added!=0) {
								JOptionPane.showMessageDialog(null, "Sales Record Added","Message",JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null,"Insertion Failed","Oops an Error Occured!!",JOptionPane.ERROR_MESSAGE);
							}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(SalesFrame.class.getResource("/icons/user-app.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(25, 334, 119, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewSales sales=new ViewSales();
				sales.setVisible(true);
				
				
			}
			
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon(SalesFrame.class.getResource("/icons/target.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(246, 334, 125, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().equals("")) {
					int Confirm=JOptionPane.showConfirmDialog(null,"Make Sure Customer Can be Deleted or not...","Delete Customer?",JOptionPane.YES_NO_OPTION);
					
					if(Confirm == 0) {
						con=DBConnection.getConnection();
						query="delete from sales where customer_id=?";
						
						try {
							ps=con.prepareStatement(query);
							ps.setString(1,textField.getText());
							
							int delete=ps.executeUpdate();
							if(delete != 0) {
								JOptionPane.showMessageDialog(null,"Customer Deleted","Message",JOptionPane.INFORMATION_MESSAGE, null);
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
			}
			
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon(SalesFrame.class.getResource("/icons/bin.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(472, 334, 119, 32);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLOSE");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminActivity admin=new AdminActivity();
				admin.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon(SalesFrame.class.getResource("/icons/cancel.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(694, 334, 111, 32);
		contentPane.add(btnNewButton_4);
	}
	public List<Sales> getSalesDetails() {
		
		con=DBConnection.getConnection();
		Sales sales=new Sales();
		List<Sales> saleslist=new ArrayList<Sales>();
		
		query="select * from sales";
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			
			while(rs.next()) {
				sales.setCustomerID(rs.getString(1));
				sales.setOrderdate(rs.getDate(2));
				sales.setProductid(rs.getString(3));
				
				saleslist.add(sales);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saleslist;
	}
	public void getSalesDetailsId(String customer_id) {
		
		con=DBConnection.getConnection();
		Sales sales=new Sales();
		List<Sales> saleslist=new ArrayList<Sales>();
		
		query="select * from sales where customer_id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, customer_id);
		    rs=ps.executeQuery();
		    
		    while(rs.next()) {
		    	sales.setCustomerID(rs.getString(1));
		    	sales.setOrderdate(rs.getDate(2));
		    	sales.setProductid(rs.getString(3));
		   
		    	saleslist.add(sales);
		    }
		    
		    	textField.setText(saleslist.get(0).getCustomerID());
		    	
		    	textField_2.setText(saleslist.get(0).getProductid());
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
