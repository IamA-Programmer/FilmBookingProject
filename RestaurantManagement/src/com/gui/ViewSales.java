package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.model.Sales;

import javax.swing.RowFilter;

public class ViewSales extends JFrame {

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
					ViewSales frame = new ViewSales();
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
	public ViewSales() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewSales.class.getResource("/icons/increase.png")));
		setTitle("View Sales");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filterTable();
			}
		});
		btnNewButton.setIcon(new ImageIcon(ViewSales.class.getResource("/icons/preview.png")));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton.setBounds(177, 29, 139, 33);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
			filterTable();
			}

		});
		textField.setBounds(326, 32, 356, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 73, 798, 332);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 778, 310);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"CUSTOMER ID", "ORDER DATE", "PRODUCT ID"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton_1 = new JButton("GET DETAILS");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if((table.getSelectedColumn() != -1) || (table.getSelectedRow() != -1)) {
					String customerid=(String) table.getValueAt(table.getSelectedRow(), 0);
					SalesFrame sales=new SalesFrame();
					sales.getSalesDetailsId(customerid);
					setVisible(false);
					sales.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select row or column from table", "Message", JOptionPane.INFORMATION_MESSAGE, null);
				}
				
			}
			
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(ViewSales.class.getResource("/icons/info.png")));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_1.setBounds(116, 416, 173, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SalesFrame sales=new SalesFrame();
				sales.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_2.setIcon(new ImageIcon(ViewSales.class.getResource("/icons/cancel.png")));
		btnNewButton_2.setBounds(511, 416, 132, 39);
		contentPane.add(btnNewButton_2);
	showInTable();
	}
	public void showInTable() {
		
		 SalesFrame sales=new SalesFrame();
		 List<Sales> saleslist=sales.getSalesDetails();
		 
		 DefaultTableModel model=new DefaultTableModel();
		 model=(DefaultTableModel) table.getModel();
		 
		Object[] rowdata=new Object[table.getColumnCount()];
		model.setRowCount(0);
		
		for(int i=0;i<saleslist.size();i++) {
			
			rowdata[0]=saleslist.get(i).getCustomerID();
			rowdata[1]=saleslist.get(i).getOrderdate();
			rowdata[2]=saleslist.get(i).getProductid();
			
			model.addRow(rowdata);
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
