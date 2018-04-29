package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import model.Medications;

class CreateEntity {

	@Test
	void test() {
		Medications med = new Medications("parasinus", "ceva", "aaa", 200, 15);
		
		assertEquals("parasinus", med.getName());
		
	}

}
