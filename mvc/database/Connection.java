package database;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Connection {

	private Session session;
	private Transaction transaction;
	
	public Connection() {
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.buildSessionFactory();
				
		session = sf.openSession();
				
		transaction = session.beginTransaction();		
	}
	
	public void closeConnection() {
		session.close();
	}
	
	public Session getSession() {
		return session;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
}
