package JUnit;

import static org.junit.Assert.*;
import java.util.Scanner;
public class JUnit {

		public String Categories(String comedy, String drama, String action, String family){
/*			String categorySelected = "blank";
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch (option){
			case 1: categorySelected = Comedy;
					break;
			case 2: categorySelected = Drama;
					break;
			case 3: categorySelected = Action;
					break;
			case 4: categorySelected = Family;
					break;
			}
*/
			return comedy + drama + action + family;
			
		}
		
		public String Customer(String Name, int CustID, String address, String email, int phone){
			
			return Name + CustID + address + email + phone;
		}
}
