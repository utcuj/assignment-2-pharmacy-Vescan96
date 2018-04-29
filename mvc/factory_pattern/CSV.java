package factory_pattern;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Medications;

public class CSV implements File{

	//Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",\t";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER = "name \tingredients \tmanufacturer \tquantity \tprice";
	
	@Override
	public void generate(List<Medications> medications) {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("reports.csv");
			
			writer.append(FILE_HEADER);
			writer.append(NEW_LINE_SEPARATOR);
			
			for(Medications med : medications)
			{
				writer.append(med.getName());
				writer.append(COMMA_DELIMITER);
				writer.append(med.getIngredients());
				writer.append(COMMA_DELIMITER);
				writer.append(med.getManufacturer());
				writer.append(COMMA_DELIMITER);
				writer.append(""+med.getQuantity());
				writer.append(COMMA_DELIMITER);
				writer.append(""+med.getPrice());
				writer.append(NEW_LINE_SEPARATOR);		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	



}
