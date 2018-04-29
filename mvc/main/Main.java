package main;

import controller.UIManagement;
import database.Connection;
import view.*;

public class Main {

	public static void main(String[] args) {
		
		Connection connection = new Connection();
		
		Login login = new Login();
		
		new UIManagement(login, connection);
	}

}
