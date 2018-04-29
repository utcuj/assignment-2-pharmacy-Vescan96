package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import org.hibernate.transform.Transformers;
import database.Connection;
import factory_pattern.FileFactory;
import model.Employee;
import model.ExportToXml;
import model.Medications;
import view.AdminFrame;
import view.MedicationsFrame;
import view.ViewEmployeeFrame;

public class AdminManagement {
	List<Medications> deletedMedications = new ArrayList<Medications>();
	
	public AdminManagement(AdminFrame frame) {
		frame.setVisible(true);
		
		frame.addMedEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String name = frame.getMedNameText();
				String ingredients = frame.getMedIngredientsText();
				String manufacturer = frame.getMedManufacturerText();
				int quantity = frame.getQuantityText();
				int price = frame.getPriceText();
				
				Connection con = new Connection();
				con.getSession().save(new Medications(name, ingredients, manufacturer, quantity, price));
				con.getTransaction().commit();				
			}
			
		});
		
		frame.readMedEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Connection con = new Connection();
				
				@SuppressWarnings({ "unchecked", "deprecation" })
				List<Medications> medications = con.getSession().createNativeQuery("select * from Medications")
												   .setResultTransformer(Transformers.aliasToBean(Medications.class))
												   .list();
				
				MedicationsFrame mf = new MedicationsFrame();
				mf.setTable(medications);
				mf.setVisible(true);				
			}
			
		});

		frame.updateMedEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Connection con = new Connection();
				
				String name = frame.getMedNameText();
				String ingredients = frame.getMedIngredientsText();
				String manufacturer = frame.getMedManufacturerText();
				int quantity = frame.getQuantityText();
				int price = frame.getPriceText();
				
				String newName = frame.getNewMedNameText();
				String newIngredients = frame.getNewMedIngredientsText();
				String newManufacturer = frame.getNewMedManufacturerText();
				int newQuantity = frame.getNewQuantityText();
				int newPrice = frame.getNewPriceText();
				
				con.getSession().createQuery("update Medications set "
											 + "name = '" + newName + "', "
											 + "ingredients = '" + newIngredients + "', "
											 + "manufacturer = '" + newManufacturer + "', "
											 + "quantity = " + newQuantity + ", "
											 + "price = " + newPrice + " where "
											 + "name = '" + name + "' and ingredients = '" + ingredients 
											 + "' and manufacturer = '" + manufacturer
											 + "' and quantity = " + quantity + "and price = " + price)
								.executeUpdate();
				con.getTransaction().commit();
			}
			
		});

		frame.deleteMedEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection con = new Connection();
				
				String name = frame.getMedNameText();
				String ingredients = frame.getMedIngredientsText();
				String manufacturer = frame.getMedManufacturerText();
				int quantity = frame.getQuantityText();
				int price = frame.getPriceText();
								
				con.getSession()
				   .createQuery("delete from Medications where "
							    + "name = '" + name + "' and ingredients = '" + ingredients 
							    + "' and manufacturer = '" + manufacturer
							    + "' and quantity = " + quantity + "and price = " + price)
				   .executeUpdate();
				con.getTransaction().commit();
				
				deletedMedications.add(new Medications(name, ingredients, manufacturer, 1, price));
			}
			
		});
	
		frame.addEmployeeEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection con = new Connection();
				
				String name = frame.getEmployeeNameText();
				String password = frame.getEmployeePassText();
				
				con.getSession().save(new Employee(name, password));
				con.getTransaction().commit();
			}
			
		});
		
		frame.readEmployeeEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Connection con = new Connection();
				
				@SuppressWarnings({ "unchecked", "deprecation" })
				List<Employee> employees = con.getSession().createNativeQuery("select * from Employee")
											  .setResultTransformer(Transformers.aliasToBean(Employee.class))
											  .list();
				
				ViewEmployeeFrame ef = new ViewEmployeeFrame();
				ef.setTable(employees);
				ef.setVisible(true);
			}
			
		});
	
		frame.updateEmployeeEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = new Connection();
				
				String name = frame.getEmployeeNameText();
				String password = frame.getEmployeePassText();
				
				String newName = frame.getNewEmployeeNameText();
				String newPassword = frame.getNewEmployeePassText();
				
				con.getSession()
				   .createQuery("update Employee set name = '" + newName + "', password = '" + newPassword + "' where "
						        + "name  = '" + name + "' and password = '" + password + "'")
				   .executeUpdate();
				con.getTransaction().commit();
			}
			
		});

		frame.deleteEmployeeEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = new Connection();
				
				String name = frame.getEmployeeNameText();
				String password = frame.getEmployeePassText();
				
				con.getSession()
				   .createQuery("delete from Employee where name = '" 
						   		+ name + "' and password = '" + password + "'")
				   .executeUpdate();
				con.getTransaction().commit();
			}
			
		});
	
		frame.pdfReportsEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {			
				new FileFactory().getFile("pdf").generate(deletedMedications);
			}
			
		});
		
		frame.csvReportsEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				new FileFactory().getFile("csv").generate(deletedMedications);
			}
			
		});
	
		frame.exportToXml(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Connection con = new Connection();
				
				@SuppressWarnings({ "deprecation", "unchecked" })
				List<Medications> medications = con.getSession().createNativeQuery("select * from Medications")
						   						   .setResultTransformer(Transformers.aliasToBean(Medications.class))
						   						   .list();
				
				new ExportToXml(medications);
			}
			
		});
	}

}
