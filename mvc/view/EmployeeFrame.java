package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.Medications;

public class EmployeeFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel name, ingredients, manufacturer;
	private JTextField nameText, ingredientsText, manufacturerText;
	private JButton search, sell; 
	
	private Font font = new Font("", Font.BOLD, 25);
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	
	public EmployeeFrame() {
		this.setTitle("Employee");
		this.setSize(900, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		// panel
		panel = new JPanel();
		panel.setLayout(null);
		
		// labels
		name = new JLabel("name");
		name.setFont(font);
		name.setBounds(20, 10, 200, 30);
		
		ingredients = new JLabel("ingredients");
		ingredients.setFont(font);
		ingredients.setBounds(20, 50, 200, 30);
		
		manufacturer = new JLabel("manufacturer");
		manufacturer.setFont(font);
		manufacturer.setBounds(20, 90, 200, 30);
		
		// text fields
		nameText = new JTextField();
		nameText.setFont(font);
		nameText.setBounds(200, 10, 150, 30);
		
		ingredientsText = new JTextField();
		ingredientsText.setFont(font);
		ingredientsText.setBounds(200, 50, 150, 30);
		
		manufacturerText = new JTextField();
		manufacturerText.setFont(font);
		manufacturerText.setBounds(200, 90, 150, 30);
		
		// buttons
		search = new JButton("search");
		search.setFont(font);
		search.setBounds(20, 200, 150, 50);
		
		sell = new JButton("sell");
		sell.setFont(font);
		sell.setBounds(200, 200, 150, 50);
		
		// labels
		panel.add(name);
		panel.add(ingredients);
		panel.add(manufacturer);
		
		// text fields
		panel.add(nameText);
		panel.add(ingredientsText);
		panel.add(manufacturerText);
		
		// buttons
		panel.add(search);
		panel.add(sell);
		
		getContentPane().add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 20, 490, 330);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		model = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"name", "ingredients", "manufacturer", "quantity", "price"
			}
		) {
		
			private static final long serialVersionUID = 1L;
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
		model.removeRow(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(82);
		table.getColumnModel().getColumn(4).setPreferredWidth(83);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);
	}
	
	public void searchEvent(ActionListener listener) {
		search.addActionListener(listener);
	}
	
	public void sellEvent(ActionListener listener) {
		sell.addActionListener(listener);
	}
	
	public String getNameText() {
		return nameText.getText();
	}
	
	public String getIngredientsText() {
		return ingredientsText.getText();
	}
	
	public String getManufacturerText() {
		return manufacturerText.getText();
	}
	
	public void fillTable(List<Medications> medications) {
		
		model.setRowCount(0);
		
		for(Medications med : medications)
		{
			Object[] o = new Object[5];
			o[0] = med.getName();
			o[1] = med.getIngredients();
			o[2] = med.getManufacturer();
			o[3] = med.getQuantity();
			o[4] = med.getPrice();
			
			model.addRow(o);
			
		}
		
	}
}
