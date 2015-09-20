package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	 public void testCustomer() {
		  JUnit test = new JUnit();
		  String result = test.Customer("Bob", 000014, "12 gtfo road", "email@email.com", 0404040040 );
		  assertEquals("Bob00001412 gtfo roademail@email.com0404040040", result);
		  
		 }
}
