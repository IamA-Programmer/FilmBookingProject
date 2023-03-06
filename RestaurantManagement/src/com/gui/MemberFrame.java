package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

import com.dbutil.DBConnection;
import com.model.Members;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDdmmyyyy;
	PreparedStatement ps;
	Connection con;
	Statement s;
	ResultSet rs;
	String query;
	private int Sequentialid=1000;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame frame = new MemberFrame();
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
	public MemberFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MemberFrame.class.getResource("/icons/team.png")));
		setTitle("Members");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), null, null, new Color(255, 255, 255)), new CompoundBorder(new CompoundBorder(), null)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MemberFrame.class.getResource("/icons/group.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(73, 8, 399, 371);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(569, 24, 140, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(538, 62, 213, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMER NAME\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(569, 114, 140, 32);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(538, 157, 213, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("JOIN DATE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(569, 221, 140, 27);
		contentPane.add(lblNewLabel_3);
		

		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				con=DBConnection.getConnection();
				query="select max(customer_id) from members";
				Members member=new Members();
				
				try {
					s=con.createStatement();
					rs=s.executeQuery(query);
					
					rs.next();
					if(rs.getString(1) == null) {
						JOptionPane.showMessageDialog(null,"Please Fill the Given Fields","Oops an Error Occured",JOptionPane.ERROR_MESSAGE);
						member.setCustomerid("C#"+Sequentialid);
						textField.setText(member.getCustomerid());
					}
					else {
						String got=rs.getString(1);
						Sequentialid=Integer.parseInt(got.substring(2, got.length()))+1;
						member.setCustomerid("C#"+Sequentialid);
						textField.setText(member.getCustomerid());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		btnNewButton_4.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_4.setIcon(new ImageIcon(MemberFrame.class.getResource("/icons/user-app.png")));
		btnNewButton_4.setBounds(10, 390, 130, 43);
		contentPane.add(btnNewButton_4);
		
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(MemberFrame.class.getResource("/icons/diskette(1).png")));
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				Members member=new Members();
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Customer ID could not be empty","Oops an error occured",JOptionPane.ERROR_MESSAGE, null);
				}
				else if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Customer Name could not be empty","Oops an error occured",JOptionPane.ERROR_MESSAGE, null);
				}
				else if(txtDdmmyyyy.getText().equals("")) {
					
				JOptionPane.showMessageDialog(null,"Join Date Field not be empty","Oops an error occured", JOptionPane.ERROR_MESSAGE, null);		
					}
					
				else {
					con=DBConnection.getConnection();
						
						member.setCustomerid(textField.getText());
						member.setCustomername(textField_1.getText());
							
							 String date=txtDdmmyyyy.getText()+" "+Calendar.HOUR+":"+Calendar.MINUTE+":"+Calendar.SECOND;
								
								java.sql.Timestamp st=java.sql.Timestamp.valueOf(date);
							
							member.setTimestamp(st);
						}
					
				  query="insert into members (customer_id,customer_name,join_date) values(?,?,?)";
				  
				  try {
					ps=con.prepareStatement(query);
					
					ps.setString(1, member.getCustomerid());
					ps.setString(2, member.getCustomername());
					ps.setTimestamp(3, member.getTimestamp());
					
					int updated=ps.executeUpdate();
					
					if(updated != 0) {
						JOptionPane.showMessageDialog(null,"Saved Successfully", "Success",JOptionPane.INFORMATION_MESSAGE, null);
					}
					else {
						JOptionPane.showMessageDialog(null,"Insertion failed try again","Oops an error occured",JOptionPane.ERROR_MESSAGE, null);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
				}
				
			}
		);
		btnNewButton.setBounds(191, 390, 130, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REMOVE");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				con=DBConnection.getConnection();
				if(!textField.getText().equals("")) {
					int yes=JOptionPane.showConfirmDialog(null, "Make sure u want to delete the customer..","info",JOptionPane.YES_NO_OPTION);
					
					  if(yes==0) {
						  query="delete from members where customer_id=?";
						  try {
								ps=con.prepareStatement(query);
								ps.setString(1,textField.getText());
								
								int deleted=ps.executeUpdate();
								
								if(deleted != 0) {
								 JOptionPane.showMessageDialog(null,"Customer Deleted","Message",JOptionPane.INFORMATION_MESSAGE);
								}
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					  }
				}
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_1.setIcon(new ImageIcon(MemberFrame.class.getResource("/icons/bin.png")));
		btnNewButton_1.setBounds(523, 390, 130, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminActivity admin=new AdminActivity();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_2.setIcon(new ImageIcon(MemberFrame.class.getResource("/icons/cancel.png")));
		btnNewButton_2.setBounds(707, 390, 114, 43);
		contentPane.add(btnNewButton_2);
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setToolTipText("YYYY-MM-DD");
		txtDdmmyyyy.setForeground(Color.BLACK);
		txtDdmmyyyy.setBounds(538, 259, 213, 33);
		contentPane.add(txtDdmmyyyy);
		txtDdmmyyyy.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("VIEW");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewMembers members=new ViewMembers();
				members.setVisible(true);
				dispose();
				
			}
			
		});
		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_3.setIcon(new ImageIcon(MemberFrame.class.getResource("/icons/target.png")));
		btnNewButton_3.setBounds(364, 390, 122, 43);
		contentPane.add(btnNewButton_3);
		
	}
	public String currentStatus() {
		
        Calendar calendar=Calendar.getInstance();
        
        String date=Integer.toString(calendar.get(Calendar.DATE));
        String month=Integer.toString(calendar.get(Calendar.MONTH)+1);
       String year=Integer.toString(calendar.getWeekYear());
       
       String today=year+"-"+month+"-"+date;
       return today;
	}
	public List<Members> getDetailsMember() {
		
		con=DBConnection.getConnection();
		
		List<Members> memberlist=new ArrayList<Members>();
		
		query="select * from members";
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			
			while(rs.next()) {
				Members members=new Members();
				members.setCustomerid(rs.getString(1));
				members.setCustomername(rs.getString(2));
				members.setTimestamp(rs.getTimestamp(3));
				
				memberlist.add(members);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberlist;
	}
	public void getDetailsMemberById(String customerid) {
		con=DBConnection.getConnection();
		Members members=new Members();
		List<Members> memberlist=new ArrayList<Members>();
		
		query="select * from members where customer_id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, customerid);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				members.setCustomerid(rs.getString(1));
				members.setCustomername(rs.getString(2));
				members.setTimestamp(rs.getTimestamp(3));
				
				memberlist.add(members);
			}
				SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
				
				String datejoin=sd.format(memberlist.get(0).getTimestamp());
				
				textField.setText(memberlist.get(0).getCustomerid());
				textField_1.setText(memberlist.get(0).getCustomername());
				txtDdmmyyyy.setText(datejoin);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
