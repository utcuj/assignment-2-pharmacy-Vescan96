package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Employee;

public class ViewEmployeeFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	
	@SuppressWarnings("serial")
	public ViewEmployeeFrame() {
		setSize(450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 227);
		panel.add(scrollPane);
		
		table = new JTable();
		
		model = new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"name", "password"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.setModel(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
	}

	public void setTable(List<Employee> employees) {
		
		model.setRowCount(0);
		
		for(Employee emp : employees)
		{
			Object[] o = new Object[2];
			o[0] = emp.getName();
			o[1] = emp.getPassword();
			
			model.addRow(o);
		}
	}
}
