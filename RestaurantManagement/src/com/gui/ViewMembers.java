package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.model.Members;

import javax.swing.border.LineBorder;

public class ViewMembers extends JFrame {

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
					ViewMembers frame = new ViewMembers();
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
	public ViewMembers() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMembers.class.getResource("/icons/team.png")));
		setTitle("View Members");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			   filterTable();	
			}
			
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(ViewMembers.class.getResource("/icons/preview.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(187, 24, 121, 34);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				filterTable();
				
			}
			
		});
		textField.setBounds(329, 22, 372, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 84, 811, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 791, 256);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
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
			},
			new String[] {
				"CUSTOMER ID", "CUSTOMER NAME", "JOIN DATE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("GET DETAILS");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if((table.getSelectedColumn() != -1) || (table.getSelectedRow() != -1)) {
					String customerid=(String) table.getValueAt(table.getSelectedRow(), 0);
					 MemberFrame member=new MemberFrame();
					 member.getDetailsMemberById(customerid);
					 member.setVisible(true);
					 setVisible(false);
					 
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select a row to get details","Message", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_1.setIcon(new ImageIcon(ViewMembers.class.getResource("/icons/info.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(187, 400, 169, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MemberFrame member=new MemberFrame();
				member.setVisible(true);
			dispose();
				
			}
			
		});
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_2.setIcon(new ImageIcon(ViewMembers.class.getResource("/icons/cancel.png")));
		btnNewButton_2.setBounds(546, 400, 115, 41);
		contentPane.add(btnNewButton_2);
		showInTable();
	}
	 void showInTable() {
		 
		DefaultTableModel model=new DefaultTableModel();
		model=(DefaultTableModel) table.getModel();
		
		MemberFrame member=new MemberFrame();
		List<Members> memberlist=member.getDetailsMember();
	
		Object[] rowdata=new Object[table.getColumnCount()];
		model.setRowCount(0);
		
		for(int i=0;i < memberlist.size();i++) {
			
			rowdata[0]=memberlist.get(i).getCustomerid();
			rowdata[1]=memberlist.get(i).getCustomername();
			rowdata[2]=memberlist.get(i).getTimestamp();
			
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
