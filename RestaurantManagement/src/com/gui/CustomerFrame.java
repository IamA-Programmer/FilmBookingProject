package com.gui;
import com.dbutil.DBConnection;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.model.Customer;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JTextArea;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;


public class CustomerFrame extends JFrame {

	private static final long serialVersionUID=1L;
	private JPanel ContentPane;
	private ButtonGroup buttongroup;
	//private JRadioButton rdbtnNewRadioButton_1,rdbtnNewRadioButton;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem, rdbtnmntmNewRadioItem_1;
	JTextArea address;
	Connection con;
	Statement s;
	PreparedStatement ps;
	ResultSet rs;
	
	//create Model Object 
	Customer customerObj;
	String query;
	private static int sequential_ID=1000;
	int count=0;
	private JTextField textField;
	private JTextArea textArea;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerFrame.class.getResource("/icons/customer.png")));
		setBounds(100, 100, 847, 505);
		setFont(new Font("Arial",Font.ITALIC,18));
		setBackground(SystemColor.BLACK);
		setForeground(UIManager.getColor("Button.focus"));
		setTitle("Customer Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ContentPane=new JPanel();
        ContentPane.setForeground(UIManager.getColor("Button.light"));
        ContentPane.setBackground(new Color(239, 239, 241));
        ContentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(ContentPane);
        ContentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Customer ID : ");
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(373, 33, 105, 20);
        ContentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Customer Name : ");
        lblNewLabel_1.setBackground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setBounds(353, 81, 125, 20);
        ContentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Gender ");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setBounds(411, 118, 67, 20);
        ContentPane.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setToolTipText("Enter the Customer_ID");
        textField.setBounds(478, 35, 226, 20);
        ContentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setToolTipText("Enter the Customer Name");
        textField_1.setBounds(478, 83, 226, 20);
        ContentPane.add(textField_1);
        textField_1.setColumns(10);
        
        rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Male");
        rdbtnmntmNewRadioItem.setSelected(true);
        rdbtnmntmNewRadioItem.setBounds(488, 118, 105, 26);
        ContentPane.add(rdbtnmntmNewRadioItem);
        
        rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Female");
        rdbtnmntmNewRadioItem_1.setBounds(595, 118, 115, 26);
        ContentPane.add(rdbtnmntmNewRadioItem_1);
        
        buttongroup=new ButtonGroup();
        buttongroup.add(rdbtnmntmNewRadioItem);
        buttongroup.add(rdbtnmntmNewRadioItem_1);
         
        JLabel lblNewLabel_5 = new JLabel("Email ID : ");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setBounds(401, 158, 77, 20);
        ContentPane.add(lblNewLabel_5);
        
        textField_2 = new JTextField();
        textField_2.setBounds(480, 160, 224, 20);
        ContentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Address : ");
        lblNewLabel_6.setForeground(Color.BLACK);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(401, 224, 77, 20);
        ContentPane.add(lblNewLabel_6);
        
        textArea = new JTextArea();
        textArea.setToolTipText("Address");
        textArea.setForeground(Color.BLACK);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBounds(478, 224, 226, 131);
        ContentPane.add(textArea);
        
        JLabel lblNewLabel_7 = new JLabel("Mobile NO : ");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_7.setForeground(Color.BLACK);
        lblNewLabel_7.setBackground(Color.WHITE);
        lblNewLabel_7.setBounds(381, 379, 87, 20);
        ContentPane.add(lblNewLabel_7);
        
        textField_3 = new JTextField();
        textField_3.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		char key=e.getKeyChar();
        		int length=textField_3.getText().length();
        		if((key >='0')||(key <='9') && (key == KeyEvent.VK_BACK_SPACE)) {
        			if(length < 10) {
        				textField_3.setEditable(true);
        			}
        			else {
        				textField_3.setEditable(false);
        			}
        		}
        		else {
        			textField_3.setEditable(false);
        		}
        	}
        });
        textField_3.setBounds(478, 381, 224, 20);
        ContentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btnNewButton = new JButton("Add Customer");
        btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			customerObj=new Customer();
			
			try {
				con=DBConnection.getConnection();
				query="select max(customer_id) from customer";
				s=con.createStatement();
				rs=s.executeQuery(query);
				rs.next();
				if(rs.getString(1)==null) {
					System.out.println("No Record");
					JOptionPane.showMessageDialog(null, "Please Fill the Given Fields", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
					customerObj.setCustomer_ID("C#"+sequential_ID);
					textField.setText(customerObj.getCustomer_ID());
				}
				else {
					sequential_ID=Integer.parseInt(rs.getString(1).substring(2, rs.getString(1).length()))+1;
					customerObj.setCustomer_ID("C#"+sequential_ID);
					textField.setText(customerObj.getCustomer_ID());
				}
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
        });
        btnNewButton.setMnemonic('A');
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/user-app.png")));
        btnNewButton.setFocusable(false);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(10, 424, 150, 31);
        ContentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("View Customer");
        btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewCusomer customer=new ViewCusomer();
				customer.setVisible(true);
				dispose();	
			}
        });
        btnNewButton_1.setMnemonic('V');
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/target.png")));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setBounds(353, 424, 150, 31);
        ContentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Save");
        btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				con=DBConnection.getConnection();
				
				customerObj=new Customer();
				
			if(textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Customer_ID could not be empty", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
				textField.requestFocus();
			}
			else if(textField_1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Customer_name could not be empty", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
				textField_1.requestFocus();
			}
			else if(textField_2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Email Field could not be empty", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
				textField_2.requestFocus();
			}
			else if(textArea.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Address Field could not be empty", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
				textArea.requestFocus();
			}
			else if(textField_3.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Mobile Number could not be empty", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
				textField_3.requestFocus();
			}
			else if(textField_3.getText().length()<10) {
				JOptionPane.showMessageDialog(null, "Please Enter a Valid Mobile Number", "Oops an Error Occured!!", JOptionPane.ERROR_MESSAGE);
				textField_3.requestFocus();
			}
			else {
				customerObj.setCustomer_ID(textField.getText());
				customerObj.setCustomer_name(textField_1.getText());
				customerObj.setGender(rdbtnmntmNewRadioItem.isSelected() ? "Male":"Female");
				customerObj.setAddress(textArea.getText());
				customerObj.setEmail_ID(textField_2.getText());
				customerObj.setMobile_number(Long.parseLong(textField_3.getText()));
				
			    query="Insert into customer(customer_id,customer_name,gender,email,Address,mobile_number) values(?,?,?,?,?,?)";
				try {
					ps=con.prepareStatement(query);
					
					ps.setString(1,customerObj.getCustomer_ID());
					ps.setString(2, customerObj.getCustomer_name());
					ps.setString(3, customerObj.getGender());
					ps.setString(4, customerObj.getEmail_ID());
					ps.setString(5, customerObj.getAddress());
					ps.setLong(6, customerObj.getMobile_number());
					
					count=ps.executeUpdate();
					if(count!=0) {
						JOptionPane.showMessageDialog(null, count+" New Customer Added...","Registration Successful!!",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null,"Insertion Failed","Oops an Error Occured!!",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
			}
        });
        btnNewButton_2.setMnemonic('S');
        btnNewButton_2.setBackground(Color.WHITE);
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/diskette(1).png")));
        btnNewButton_2.setBounds(197, 423, 105, 33);
        ContentPane.add(btnNewButton_2);
        
        JButton btnNewButton_4 = new JButton("Delete");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!textField.getText().equals("")) {
        			int Confirm=JOptionPane.showConfirmDialog(null,"Make Sure Customer Can be Deleted or not...","Delete Customer?",JOptionPane.YES_NO_OPTION);
        		//yes means 0 and no means 1
        			if(Confirm==0) {
        				query="delete from customer where customer_id=?";
        				try {
							ps=con.prepareStatement(query);
							ps.setString(1,textField.getText());
							
							int deleted=ps.executeUpdate();
							if(deleted!=0) {
								JOptionPane.showMessageDialog(null,"Customer Deleted","Delete Customer",JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        	}
        });
        btnNewButton_4.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/bin.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_4.setBounds(553, 423, 115, 33);
        ContentPane.add(btnNewButton_4);
        
        JButton btnClose = new JButton("Close");
        btnClose.setFocusable(false);
        btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminActivity admin=new AdminActivity();
				admin.setVisible(true);
				dispose();
				
			}
        	
        });
        btnClose.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/cancel.png")));
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnClose.setBackground(Color.WHITE);
        btnClose.setBounds(724, 422, 97, 33);
        ContentPane.add(btnClose);
        
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/registration-form(1).png")));
        lblNewLabel_8.setBounds(66, 119, 289, 219);
        ContentPane.add(lblNewLabel_8);
        
        
	}
	public List<Customer> getCustomerDetails(){
    	
    	List<Customer> customerdetails=new ArrayList<Customer>();
    	
    	con=DBConnection.getConnection();
    	
    	query="select * from customer";
    	try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			
			while(rs.next()) {
				Customer customerObj=new Customer();
				
				customerObj.setCustomer_ID(rs.getString("customer_id"));
				customerObj.setCustomer_name(rs.getString("customer_name"));
				customerObj.setGender(rs.getString("gender"));
				customerObj.setEmail_ID(rs.getString("email"));
				customerObj.setAddress(rs.getString("Address"));
				customerObj.setMobile_number(rs.getLong("mobile_number"));
				
				customerdetails.add(customerObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return customerdetails;
    }
	public void getCustomerDetailsById(String customerid) {
		
		List<Customer> customerdetails=new ArrayList<Customer>();
		con=DBConnection.getConnection();
		query="select * from customer where customer_id=?";
	    Customer customerObj=new Customer();
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,customerid);
			rs=ps.executeQuery();
			while(rs.next()) {
				customerObj.setCustomer_ID(rs.getString("customer_id"));
				customerObj.setCustomer_name(rs.getString("customer_name"));
				customerObj.setGender(rs.getString("gender"));
				customerObj.setEmail_ID(rs.getString("email"));
				customerObj.setAddress(rs.getString("Address"));
				customerObj.setMobile_number(rs.getLong("mobile_number"));
				
				customerdetails.add(customerObj);
			}
				//setting in fields of the window
				textField.setText(customerdetails.get(0).getCustomer_ID());
				textField_1.setText(customerdetails.get(0).getCustomer_name());
				String gender=customerdetails.get(0).getGender();
				
				if(gender.equalsIgnoreCase("male")) {
					rdbtnmntmNewRadioItem.setSelected(true);
				}else {
					rdbtnmntmNewRadioItem_1.setSelected(true);
				}
					textField_2.setText(customerdetails.get(0).getEmail_ID());
					textArea.setText(customerdetails.get(0).getAddress());
					textField_3.setText(Long.toString(customerdetails.get(0).getMobile_number()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException ne) {
			ne.printStackTrace();
			ne.getMessage();
		}
	}
}
