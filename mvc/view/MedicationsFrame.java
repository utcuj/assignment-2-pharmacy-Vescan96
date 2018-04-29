package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Medications;

public class MedicationsFrame extends JFrame{

	private DefaultTableModel model;
	@SuppressWarnings("serial")
	
	public MedicationsFrame() {
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(650, 450);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 608, 377);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		model = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"name", "ingredients", "manufacturer", "quantity", "price"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Integer.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.setModel(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setViewportView(table);
	}
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public void setTable(List<Medications> medications) {
		
		model.setRowCount(0);
		
		for(Medications med : medications)
		{
			Object[] o = new Object[6];
			o[0] = med.getName();
			o[1] = med.getIngredients();
			o[2] = med.getManufacturer();
			o[3] = med.getQuantity();
			o[4] = med.getPrice();
			
			model.addRow(o);
		}
		
	}
}
