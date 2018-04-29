package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import factory_pattern.File;
import factory_pattern.FileFactory;
import factory_pattern.PDF;


class ValidateData {

	@Test
	void test() {
		File  file= new FileFactory().getFile("pdf");
		
		assertEquals(file.getClass(), new PDF().getClass());
		 
	}

}
