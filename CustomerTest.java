package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	 public void testCustomer() {
		  JUnit test = new JUnit();
		  String result = test.Customer("Bob", 000, "12 abc road", "email@email.com", 0404040040 );
		  assertEquals("Bob012 abc roademail@email.com68173856", result);
		  
		 }
}
