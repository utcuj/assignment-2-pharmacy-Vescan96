package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import database.Connection;
import model.Admin;
import model.Employee;
import view.AdminFrame;
import view.EmployeeFrame;
import view.Login;

public class UIManagement {

	public UIManagement(Login frame, Connection connection) {
		frame.setVisible(true);
		
		frame.validateUsernameEvent(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent event) {
				if( Character.isDigit(event.getKeyChar()) || Character.isWhitespace(event.getKeyChar()) )
					frame.SetValidationText("Invalid username!");
								
				if( event.getKeyChar() == KeyEvent.VK_ENTER)
					frame.SetValidationText("");
			}

			@Override
			public void keyReleased(KeyEvent arg0) {				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {				
			}
			
		});
		
		frame.registerEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				boolean pass = true;
				
				if(frame.getAdmin().isSelected() && frame.getEmployee().isSelected()) {
					JOptionPane.showMessageDialog(null, "Choose just 1 option!", "Error", JOptionPane.ERROR_MESSAGE);
					pass = false;
				}
				
				if(frame.getAdmin().isSelected() && pass) 
					JOptionPane.showMessageDialog(null, "Already exist an administrator!", "", JOptionPane.INFORMATION_MESSAGE);
					
				if(frame.getEmployee().isSelected() && pass) {
					String username = frame.getUsernameText();
					String password = frame.getPassText();
					
					connection.getSession().save(new Employee(username, password));
					connection.getTransaction().commit();
				}
			}
			
		});
		
		frame.loginEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				boolean pass = true;
				
				if(frame.getAdmin().isSelected() && frame.getEmployee().isSelected()) {
					JOptionPane.showMessageDialog(null, "Choose just 1 option!", "Error", JOptionPane.ERROR_MESSAGE);
					pass = false;
				}
				
				if(frame.getAdmin().isSelected() && pass) {
					String username = frame.getUsernameText();
					String password = frame.getPassText();
					
					Admin admin = (Admin)connection.getSession().load(Admin.class, username);
					
					if(!admin.getPassword().equals(password))
						JOptionPane.showMessageDialog(null, "wrong password", "Error", JOptionPane.ERROR_MESSAGE);
					else
						new AdminManagement(new AdminFrame());
					
				}
				
				if(frame.getEmployee().isSelected() && pass) {
					String username = frame.getUsernameText();
					String password = frame.getPassText();
					
					List<Employee> employee = connection.getSession().createQuery("from Employee", Employee.class).list();
					
					if(employee.stream()
							   .filter(x -> x.getName().equals(username) && x.getPassword().equals(password))
							   .collect(Collectors.toList())
							   .size() == 0)					
						JOptionPane.showMessageDialog(null, "wrong username or password, or user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					else					
						new EmployeeManagement(new EmployeeFrame());
				}
				
			}
			
		});
	}
}
