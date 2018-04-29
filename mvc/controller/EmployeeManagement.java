package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.hibernate.transform.Transformers;

import database.Connection;
import model.Medications;
import view.EmployeeFrame;

public class EmployeeManagement {
	
	public EmployeeManagement(EmployeeFrame frame) {
		frame.setVisible(true);
		
		frame.searchEvent(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent event) {
				Connection con = new Connection();
				
				String name = frame.getNameText();
				//String ingredients = frame.getIngredientsText();
				//String manufacturer = frame.getManufacturerText();
				
				@SuppressWarnings({ "deprecation", "unchecked" })
				List<Medications> medications = con.getSession()
												.createNativeQuery("select * from Medications where name = '" + name + "'")
												.setResultTransformer(Transformers.aliasToBean(Medications.class))
												.list();
				
				frame.fillTable(medications);
			}
			
		});
		
		frame.sellEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Connection con = new Connection();
				
				String name = frame.getNameText();
				String ingredients = frame.getIngredientsText();
				String manufacturer = frame.getManufacturerText();
				
				@SuppressWarnings({ "deprecation", "unchecked" })
				List<Medications> medications = con.getSession()
												.createNativeQuery("select * from Medications where name = '" 
																   + name + "' and ingredients = '" 
																   + ingredients + "' and manufacturer = '"
																   + manufacturer + "'")
												.setResultTransformer(Transformers.aliasToBean(Medications.class))
												.list();
						
				con.getSession().createQuery("update Medications set quantity = "
											 + (medications.get(0).getQuantity() - 1) + " where name = '"
											 + medications.get(0).getName() + "' and ingredients = '"
											 + medications.get(0).getIngredients() + "' and manufacturer = '"
											 + medications.get(0).getManufacturer() + "'").executeUpdate();
				con.getTransaction().commit();
			}
			
		});
	}

}
