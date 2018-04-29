package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AdminFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel medName, medIngredients, medManufacturer, quantity, price;
	private JLabel newMedName, newMedIngredients, newMedManufacturer, newQuantity, newPrice;
	private JLabel employeeName, employeePass;
	private JLabel newEmployeeName, newEmployeePass;
	private JTextField medNameText, medIngredientsText, medManufacturerText, quantityText, priceText;
	private JTextField newMedNameText, newMedIngredientsText, newMedManufacturerText, newQuantityText, newPriceText;
	private JTextField employeeNameText, employeePassText;
	private JTextField newEmployeeNameText, newEmployeePassText;
	private JButton addMed, readMed, updateMed, deleteMed;
	private JButton btnImportFromXml, btnExportToXml;
	private JButton addEmployee, readEmployee, updateEmployee, deleteEmployee;
	private JButton pdfReports, csvReports;
	
	private Font font = new Font("", Font.BOLD, 25);
	
	public AdminFrame() {
		this.setTitle("Admin");
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		// panel
		panel = new JPanel();
		panel.setLayout(null);
		
		// ********************************* LABELS ****************************
		
		// medication labels
		medName = new JLabel("medication name");
		medName.setFont(font);
		medName.setBounds(20, 20, 300, 30);
		
		medIngredients = new JLabel("medication ingredients");
		medIngredients.setFont(font);
		medIngredients.setBounds(20, 60, 300, 30);
		
		medManufacturer = new JLabel("medication manufacturer");
		medManufacturer.setFont(font);
		medManufacturer.setBounds(20, 100, 300, 30);
		
		quantity = new JLabel("medication quantity");
		quantity.setFont(font);
		quantity.setBounds(20, 140, 300, 30);
		
		price = new JLabel("medication price");
		price.setFont(font);
		price.setBounds(20, 180, 300, 30);
		
		// new medication labels
		newMedName = new JLabel("new name");
		newMedName.setFont(font);
		newMedName.setBounds(20, 220, 300, 30);
		
		newMedIngredients = new JLabel("new ingredients");
		newMedIngredients.setFont(font);
		newMedIngredients.setBounds(20, 260, 300, 30);
		
		newMedManufacturer = new JLabel("new manufacturer");
		newMedManufacturer.setFont(font);
		newMedManufacturer.setBounds(20, 300, 300, 30);
		
		newQuantity = new JLabel("new quantity");
		newQuantity.setFont(font);
		newQuantity.setBounds(20, 340, 300, 30);
		
		newPrice = new JLabel("new price");
		newPrice.setFont(font);
		newPrice.setBounds(20, 380, 300, 30);
		
		// employee labels
		employeeName = new JLabel("employee name");
		employeeName.setFont(font);
		employeeName.setBounds(20, 500, 300, 30);
		
		employeePass = new JLabel("employee password");
		employeePass.setFont(font);
		employeePass.setBounds(20, 550, 300, 30);
		
		// new employee labels
		newEmployeeName = new JLabel("new name");
		newEmployeeName.setFont(font);
		newEmployeeName.setBounds(20, 600, 300, 30);
		
		newEmployeePass = new JLabel("new password");
		newEmployeePass.setFont(font);
		newEmployeePass.setBounds(20, 650, 300, 30);
		
		// *************************** TEXT FIELDS ********************************
		
		// medication text fields
		medNameText = new JTextField();
		medNameText.setFont(font);
		medNameText.setBounds(350, 20, 300, 30);
		
		medIngredientsText = new JTextField();
		medIngredientsText.setFont(font);
		medIngredientsText.setBounds(350, 60, 300, 30);
		
		medManufacturerText = new JTextField();
		medManufacturerText.setFont(font);
		medManufacturerText.setBounds(350, 100, 300, 30);
		
		quantityText = new JTextField();
		quantityText.setFont(font);
		quantityText.setBounds(350, 140, 300, 30);
		
		priceText = new JTextField();
		priceText.setFont(font);
		priceText.setBounds(350, 180, 300, 30);
		
		// new medication text fields
		newMedNameText = new JTextField();
		newMedNameText.setFont(font);
		newMedNameText.setBounds(350, 220, 300, 30);
		
		newMedIngredientsText = new JTextField();
		newMedIngredientsText.setFont(font);
		newMedIngredientsText.setBounds(350, 260, 300, 30);
		
		newMedManufacturerText = new JTextField();
		newMedManufacturerText.setFont(font);
		newMedManufacturerText.setBounds(350, 300, 300, 30);
		
		newQuantityText = new JTextField();
		newQuantityText.setFont(font);
		newQuantityText.setBounds(350, 340, 300, 30);
		
		newPriceText = new JTextField();
		newPriceText.setFont(font);
		newPriceText.setBounds(350, 380, 300, 30);
		
		// employee text fields
		employeeNameText = new JTextField();
		employeeNameText.setFont(font);
		employeeNameText.setBounds(350, 500, 300, 30);
		
		employeePassText = new JTextField();
		employeePassText.setFont(font);
		employeePassText.setBounds(350, 550, 300, 30);
		
		// new employee text fields
		newEmployeeNameText = new JTextField();
		newEmployeeNameText.setFont(font);
		newEmployeeNameText.setBounds(350, 600, 300, 30);
		
		newEmployeePassText = new JTextField();
		newEmployeePassText.setFont(font);
		newEmployeePassText.setBounds(350, 650, 300, 30);
		
		
		// ********************************* buttons ****************************
		
		// medication buttons
		addMed = new JButton("add medication");
		addMed.setFont(font);
		addMed.setBounds(700, 40, 270, 30);
		
		readMed = new JButton("view medication");
		readMed.setFont(font);
		readMed.setBounds(700, 100, 270, 30);
		
		updateMed = new JButton("update medication");
		updateMed.setFont(font);
		updateMed.setBounds(700, 160, 270, 30);
		
		deleteMed = new JButton("delete medication");
		deleteMed.setFont(font);
		deleteMed.setBounds(700, 220, 270, 30);
		
		// employee buttons
		addEmployee = new JButton("add employee");
		addEmployee.setFont(font);
		addEmployee.setBounds(700, 450, 270, 30);
		
		readEmployee = new JButton("view employee");
		readEmployee.setFont(font);
		readEmployee.setBounds(700, 500, 270, 30);
		
		updateEmployee = new JButton("update employee");
		updateEmployee.setFont(font);
		updateEmployee.setBounds(700, 550, 270, 30);
		
		deleteEmployee = new JButton("delete employee");
		deleteEmployee.setFont(font);
		deleteEmployee.setBounds(700, 600, 270, 30);
		
		// reports buttons
		pdfReports = new JButton(".pdf reports");
		pdfReports.setFont(font);
		pdfReports.setBounds(700, 650, 270, 30);
		
		csvReports = new JButton(".csv reports");
		csvReports.setFont(font);
		csvReports.setBounds(700, 700, 270, 30);
		
		// ************************ labels *************************
		panel.add(medName);
		panel.add(medIngredients);
		panel.add(medManufacturer);
		panel.add(quantity);
		panel.add(price);
		
		panel.add(newMedName);
		panel.add(newMedIngredients);
		panel.add(newMedManufacturer);
		panel.add(newQuantity);
		panel.add(newPrice);
		
		panel.add(employeeName);
		panel.add(employeePass);
		
		panel.add(newEmployeeName);
		panel.add(newEmployeePass);
		
		// ************************ text fields ********************
		panel.add(medNameText);
		panel.add(medIngredientsText);
		panel.add(medManufacturerText);
		panel.add(quantityText);
		panel.add(priceText);
		
		panel.add(newMedNameText);
		panel.add(newMedIngredientsText);
		panel.add(newMedManufacturerText);
		panel.add(newQuantityText);
		panel.add(newPriceText);
		
		panel.add(employeeNameText);
		panel.add(employeePassText);
		
		panel.add(newEmployeeNameText);
		panel.add(newEmployeePassText);
		
		// ************************ buttons ************************
		panel.add(addMed);
		panel.add(readMed);
		panel.add(updateMed);
		panel.add(deleteMed);
		
		panel.add(addEmployee);
		panel.add(readEmployee);
		panel.add(updateEmployee);
		panel.add(deleteEmployee);
		
		panel.add(pdfReports);
		panel.add(csvReports);
		
		getContentPane().add(panel);
		
		// ************* import & export XML file
		btnImportFromXml = new JButton("import from xml");
		btnImportFromXml.setFont(new Font("Dialog", Font.BOLD, 25));
		btnImportFromXml.setBounds(700, 300, 270, 30);
		panel.add(btnImportFromXml);
		
		btnExportToXml = new JButton("export to xml");
		btnExportToXml.setFont(new Font("Dialog", Font.BOLD, 25));
		btnExportToXml.setBounds(700, 350, 270, 30);
		panel.add(btnExportToXml);
	}
	
	// medication events
	public void addMedEvent(ActionListener listener) {
		addMed.addActionListener(listener);
	}

	public void readMedEvent(ActionListener listener) {
		readMed.addActionListener(listener);
	}

	public void updateMedEvent(ActionListener listener) {
		updateMed.addActionListener(listener);
	}

	public void deleteMedEvent(ActionListener listener) {
		deleteMed.addActionListener(listener);
	}
	
	// xml events
	public void importFromXML(ActionListener listener) {
		btnImportFromXml.addActionListener(listener);
	}
	
	public void exportToXml(ActionListener listener) {
		btnExportToXml.addActionListener(listener);
	}
	
	// employee events	
	public void addEmployeeEvent(ActionListener listener) {
		addEmployee.addActionListener(listener);
	}
	
	public void readEmployeeEvent(ActionListener listener) {
		readEmployee.addActionListener(listener);
	}
	
	public void updateEmployeeEvent(ActionListener listener) {
		updateEmployee.addActionListener(listener);
	}
	
	public void deleteEmployeeEvent(ActionListener listener) {
		deleteEmployee.addActionListener(listener);
	}

	// reports events
	public void pdfReportsEvent(ActionListener listener) {
		pdfReports.addActionListener(listener);
	}
	
	public void csvReportsEvent(ActionListener listener) {
		csvReports.addActionListener(listener);
	}
	
	public String getMedNameText() {
		return medNameText.getText();
	}
	
	public String getMedIngredientsText() {
		return medIngredientsText.getText();
	}
	
	public String getMedManufacturerText() {
		return medManufacturerText.getText();
	}
	
	public int getQuantityText() {
		return Integer.parseInt(quantityText.getText());
	}
	
	public int getPriceText() {
		return Integer.parseInt(priceText.getText());
	}
	
	public String getNewMedNameText() {
		return newMedNameText.getText();
	}
	
	public String getNewMedIngredientsText() {
		return newMedIngredientsText.getText();
	}
	
	public String getNewMedManufacturerText() {
		return newMedManufacturerText.getText();
	}
	
	public int getNewQuantityText() {
		return Integer.parseInt(newQuantityText.getText());
	}
	
	public int getNewPriceText() {
		return Integer.parseInt(newPriceText.getText());
	}
	
	public String getEmployeeNameText() {
		return employeeNameText.getText();
	}
	
	public String getEmployeePassText() {
		return employeePassText.getText();
	}
	
	public String getNewEmployeeNameText() {
		return newEmployeeNameText.getText();
	}
	
	public String getNewEmployeePassText() {
		return newEmployeePassText.getText();
	}
}
