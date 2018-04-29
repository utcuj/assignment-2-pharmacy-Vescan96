package model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class ExportToXml {

	private final String file = "exported.xml";
	
	public ExportToXml(List<Medications> medications) {
		XMLEncoder xml = null;
		
		try {
			xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xml.writeObject(medications);
		xml.close();
	}
}
