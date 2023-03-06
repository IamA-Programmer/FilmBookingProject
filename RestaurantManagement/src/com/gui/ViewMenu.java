package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.model.Menu;

import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

public class ViewMenu extends JFrame {

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
					ViewMenu frame = new ViewMenu();
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
	public ViewMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMenu.class.getResource("/icons/menu.png")));
		setTitle("View Menu");
		setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(128, 26, 140, 38);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			filterTable();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon(ViewMenu.class.getResource("/icons/preview.png")));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(290, 32, 370, 30);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			filterTable();
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 73, 811, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 791, 280);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"PRODUCT ID", "PRODUCT NAME", "PRICE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		table.getColumnModel().getColumn(1).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("GET DETAILS");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if((table.getSelectedColumn() != -1) || (table.getSelectedRow() !=-1)) {
					String productid=(String) table.getValueAt(table.getSelectedRow(), 0);
					
					@SuppressWarnings("rawtypes")
					MenuFrame menu=new MenuFrame();
					menu.getProductDetailsById(productid);
					menu.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select Row or Column","Information", JOptionPane.INFORMATION_MESSAGE, null);
				}
				
			}
			
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_1.setIcon(new ImageIcon(ViewMenu.class.getResource("/icons/info.png")));
		btnNewButton_1.setBounds(162, 405, 166, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				MenuFrame menu=new MenuFrame();
				menu.setVisible(true);
				setVisible(false);
				
			}
			
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_2.setIcon(new ImageIcon(ViewMenu.class.getResource("/icons/cancel.png")));
		btnNewButton_2.setBounds(539, 405, 140, 38);
		contentPane.add(btnNewButton_2);
		showInTable();
	}
	
	@SuppressWarnings("rawtypes")
	public void showInTable() {
		
		MenuFrame menu=new MenuFrame();
		
		@SuppressWarnings("unchecked")
		List<Menu> menulist=menu.getProductDetails();
		DefaultTableModel model=new DefaultTableModel();
		
		model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		Object[] rowdatas=new Object[table.getColumnCount()];
		
		for(int i=0;i < menulist.size();i++) {
			
			rowdatas[0]=menulist.get(i).getProductid();
			rowdatas[1]=menulist.get(i).getProductname();
			rowdatas[2]=menulist.get(i).getPrice();
			
			model.addRow(rowdatas);
		}
		
	}
	public void filterTable() {
		
        DefaultTableModel model=new DefaultTableModel();
		
		model=(DefaultTableModel) table.getModel();
		
		TableRowSorter<DefaultTableModel> soter=new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(soter);
		
		String text=textField.getText();
		
		soter.setRowFilter(RowFilter.regexFilter(text));
		
		
	}
}
