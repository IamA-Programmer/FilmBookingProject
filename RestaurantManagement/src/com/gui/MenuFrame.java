package com.gui;
import com.dbutil.DBConnection;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Menu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenuFrame<Product> extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String text;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String query;
	ResultSet rs;
	Statement s;
	Connection con;
	PreparedStatement ps;
	private static int sequential_id=1000;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("rawtypes")
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuFrame.class.getResource("/icons/dinner.png")));
		setForeground(Color.BLACK);
		setTitle("Menu Frame");
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuFrame.class.getResource("/icons/menu(1).png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 67, 420, 288);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT ID");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(561, 78, 123, 25);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(513, 114, 219, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT NAME");
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(561, 165, 123, 25);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(513, 201, 219, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PRICE");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(561, 248, 123, 25);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(513, 284, 219, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Menu menuframe=new Menu();
				query="select max(product_id) from menu";
				
				con=DBConnection.getConnection();
				
				try {
					s=con.createStatement();
					rs=s.executeQuery(query);
					rs.next();
					
						if(rs.getString(1)==null){
							menuframe.setProductid("P#"+sequential_id);
							textField.setText(menuframe.getProductid());
						}
						else {
							text=rs.getString(1);
							sequential_id=Integer.parseInt(text.substring(2, rs.getString(1).length()))+1;
							menuframe.setProductid("P#"+sequential_id);
							textField.setText(menuframe.getProductid());
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(MenuFrame.class.getResource("/icons/user-app.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton.setBounds(39, 396, 98, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menuframe=new Menu();
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Product ID could not be Empty","Oops an Error Occured!!",JOptionPane.ERROR_MESSAGE, null);
				}
				else if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Product Name could not be Empty","Oops an Error Occured!!",JOptionPane.ERROR_MESSAGE, null);
				}
				else if(textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Price could not be Empty","Oops an Error Occured!!",JOptionPane.ERROR_MESSAGE, null);
				}
				else {
					con=DBConnection.getConnection();
					menuframe.setProductid(textField.getText());
					menuframe.setProductname(textField_1.getText());
					menuframe.setPrice(Double.parseDouble(textField_2.getText()));
					
					try {
						query="insert into menu (product_id,product_name,price) values(?,?,?)";
						ps=con.prepareStatement(query);
						
							ps.setString(1,menuframe.getProductid());
							ps.setString(2,menuframe.getProductname());
							ps.setDouble(3,menuframe.getPrice());
						
					int update=ps.executeUpdate();
					
					if(update!=0) {
						JOptionPane.showMessageDialog(null,"Menu added!!","Success", JOptionPane.INFORMATION_MESSAGE, null);
						textField.requestFocus();
					}
					else {
						JOptionPane.showMessageDialog(null,"Insertion Failed","Oops an Error Occured..", JOptionPane.ERROR_MESSAGE, null);
						textField.requestFocus();
					}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
		});
		btnNewButton_1.setIcon(new ImageIcon(MenuFrame.class.getResource("/icons/diskette(1).png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_1.setBounds(191, 396, 98, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewMenu viewmenu=new ViewMenu();
				viewmenu.setVisible(true);
				dispose();
				
			}
			
		});
		btnNewButton_2.setIcon(new ImageIcon(MenuFrame.class.getResource("/icons/target.png")));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_2.setBounds(350, 395, 109, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().equals("")) {
			int confirm= JOptionPane.showConfirmDialog(null,"Make Sure the Product_ID could be deleted or not??","Delete Customer?",JOptionPane.YES_NO_OPTION);
				
			     if(confirm==0) {
			    	 con=DBConnection.getConnection();
			    	 query="delete from menu where product_id=?";
			    	 try {
						ps=con.prepareStatement(query);
						ps.setString(1,textField.getText());
						
						int delete=ps.executeUpdate();
						if(delete!=0) {
							JOptionPane.showMessageDialog(null,"Product_ID Deleted!!","Delete",JOptionPane.INFORMATION_MESSAGE, null);
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
		btnNewButton_3.setIcon(new ImageIcon(MenuFrame.class.getResource("/icons/bin.png")));
		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_3.setBounds(523, 396, 123, 33);
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
		btnNewButton_4.setIcon(new ImageIcon(MenuFrame.class.getResource("/icons/cancel.png")));
		btnNewButton_4.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnNewButton_4.setBounds(695, 396, 102, 33);
		contentPane.add(btnNewButton_4);
	}
	public List<Menu> getProductDetails() {
		
		con=DBConnection.getConnection();
		List<Menu> productlist=new ArrayList<Menu>();
		
		query="select * from menu";
		
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			while(rs.next()) {
				Menu menu=new Menu();
				menu.setProductid(rs.getString(1));
				menu.setProductname(rs.getString(2));
				menu.setPrice(rs.getDouble(3));
				
				productlist.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productlist;
	}
	public void getProductDetailsById(String productid) {
		
		con=DBConnection.getConnection();
		List<Menu> productlist=new ArrayList<Menu>();
		
		query="select * from menu where product_id=?";
		 try {
			ps=con.prepareStatement(query);
			ps.setString(1,productid);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Menu menu=new Menu();
				menu.setProductid(rs.getString(1));
				menu.setProductname(rs.getString(2));
				menu.setPrice(rs.getDouble(3));
				
				productlist.add(menu);
			}
				textField.setText(productlist.get(0).getProductid());
				textField_1.setText(productlist.get(0).getProductname());
				textField_2.setText(Double.toString(productlist.get(0).getPrice()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
