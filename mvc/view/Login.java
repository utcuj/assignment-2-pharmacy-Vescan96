package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel username, pass, show_validation_here;
	private JTextField usernameText, passText;
	private JCheckBox admin, employee;
	private JButton login, register;
	
	private Font font = new Font("", Font.BOLD, 30);
		
	public Login() {
		this.setTitle("Login");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		// panel
		panel = new JPanel();
		panel.setLayout(null);
		
		// labels
		username = new JLabel("username");
		username.setFont(font);
		username.setBounds(100, 100, 150, 30);
		
		pass = new JLabel("password");
		pass.setFont(font);
		pass.setBounds(100, 200, 150, 30);
		
		show_validation_here = new JLabel("");
		show_validation_here.setFont(font);
		show_validation_here.setBackground(Color.RED);
		show_validation_here.setBounds(100, 130, 300, 30);
		
		// text fields
		usernameText = new JTextField();
		usernameText.setFont(font);
		usernameText.setBounds(300, 100, 200, 30);
		
		passText = new JTextField();
		passText.setFont(font);
		passText.setBounds(300, 200, 200, 30);
		
		// check boxes
		admin = new JCheckBox("Admin");
		admin.setFont(font);
		admin.setBounds(100, 300, 200, 30);
		
		employee = new JCheckBox("Employee");
		employee.setFont(font);
		employee.setBounds(300, 300, 200, 30);
		
		// buttons
		login = new JButton("login");
		login.setFont(font);
		login.setBounds(100, 400, 150, 50);
		
		register = new JButton("register");
		register.setFont(font);
		register.setBounds(300, 400, 150, 50);
		
		// labels
		panel.add(username);
		panel.add(pass);
		panel.add(show_validation_here);
		
		// text fields
		panel.add(usernameText);
		panel.add(passText);

		// check boxes
		panel.add(admin);
		panel.add(employee);
		
		// buttons
		panel.add(login);
		panel.add(register);
		
		this.add(panel);
	}
	
	public void loginEvent(ActionListener listener) {
		login.addActionListener(listener);
	}
	
	public void registerEvent(ActionListener listener) {
		register.addActionListener(listener);
	}
	
	public void validateUsernameEvent(KeyListener listener) {
		usernameText.addKeyListener(listener);
	}
	
	public JTextField getUsernameTextField() {
		return usernameText;
	}
	
	public JCheckBox getAdmin() {
		return admin;
	}
	
	public JCheckBox getEmployee() {
		return employee;
	}
	
	public String getUsernameText() {
		return usernameText.getText();
	}
	
	public String getPassText() {
		return passText.getText();
	}
	
	public void SetValidationText(String text) {
		show_validation_here.setText(text);
	}
	
}
