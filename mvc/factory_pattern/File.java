package factory_pattern;

import java.util.List;
import model.Medications;

public interface File {
	
	public void generate(List<Medications> medications);
	
}
