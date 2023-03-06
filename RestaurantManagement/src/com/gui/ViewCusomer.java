package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.model.Customer;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

public class ViewCusomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCusomer frame = new ViewCusomer();
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
	public ViewCusomer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewCusomer.class.getResource("/icons/target.png")));
		setTitle("ViewCustomer");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				filterTable();
			}
		});
		textField.setBounds(309, 40, 506, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				filterTable();
			}
			
		});
		search.setFocusable(false);
		search.setBackground(Color.WHITE);
		search.setIcon(new ImageIcon(ViewCusomer.class.getResource("/icons/preview.png")));
		search.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		search.setBounds(171, 38, 128, 31);
		contentPane.add(search);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(26, 92, 994, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane.setBounds(10, 11,974,302);
		panel.add(scrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Verdana", Font.BOLD, 11));
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
	 //   panel.add(table);
		table.setBounds(6,15, 816, -251);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Customer ID", "Customer Name", "Gender", "Email ID", "Address", "Mobile Number"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(71);
		table.getColumnModel().getColumn(3).setPreferredWidth(109);
		table.getColumnModel().getColumn(4).setPreferredWidth(126);
		table.getColumnModel().getColumn(5).setPreferredWidth(111);
		
		JButton btnNewButton = new JButton("GET DETAILS");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//table has index out of bound exception
				
				if((table.getSelectedColumn()!=-1) || (table.getSelectedRow()!=-1)) {
					String customerid=(String) table.getValueAt(table.getSelectedRow(), 0);
					
					CustomerFrame customerObj=new CustomerFrame();
					customerObj.getCustomerDetailsById(customerid);
					setVisible(false);
					customerObj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select the row","Info",JOptionPane.INFORMATION_MESSAGE, null);
				}
				
			}
			
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(311, 440, 159, 33);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(ViewCusomer.class.getResource("/icons/info.png")));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerFrame customer=new CustomerFrame();
				customer.setVisible(true);
				dispose();
				
			}
			
		});
		btnNewButton_1.setBounds(611, 440, 114, 33);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(ViewCusomer.class.getResource("/icons/cancel.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		populateTable();
	}
	
	void populateTable() {
		//method is used to populate database records into the swing table
		CustomerFrame customerObj=new CustomerFrame();
		List<Customer> customerdetails=customerObj.getCustomerDetails();
		//for table model
		DefaultTableModel model= new DefaultTableModel();
		model=(DefaultTableModel) table.getModel();
		
		Object rowdatas[]=new Object[table.getColumnCount()];
		
		System.out.println("rowData ="+rowdatas.length);
		model.setRowCount(0);
		
		
		
		//setting the details to the table
		for(int i=0;i<customerdetails.size();i++) {
			
			rowdatas[0]=customerdetails.get(i).getCustomer_ID();
			rowdatas[1]=customerdetails.get(i).getCustomer_name();
			rowdatas[2]=customerdetails.get(i).getGender();
			rowdatas[3]=customerdetails.get(i).getEmail_ID();
			rowdatas[4]=customerdetails.get(i).getAddress();
			rowdatas[5]=customerdetails.get(i).getMobile_number();
			
			model.addRow(rowdatas);
		}
	}
	void filterTable() {
		
		DefaultTableModel model=new DefaultTableModel();
		model=(DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);
		
		String text=textField.getText();
		
		sorter.setRowFilter(RowFilter.regexFilter(text));
	}
}
