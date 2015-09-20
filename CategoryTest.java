package JUnit;
import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTest {

 @Test
 public void testCategories() {
  JUnit test = new JUnit();
  String result = test.Categories("Comedy", "Drama", "Action", "Family" );
  assertEquals("ComedyDramaActionFamily", result);
  
 }

}
