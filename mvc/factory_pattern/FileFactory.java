package factory_pattern;

public class FileFactory {

	public File getFile(String fileType) {
		
		if(fileType.equalsIgnoreCase("PDF")) 
			return new PDF();
		
		if(fileType.equalsIgnoreCase("CSV"))
			return new CSV();
		
		return null;
	}
}
