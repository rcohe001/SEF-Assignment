package VideoRental;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	
	private static ArrayList<Customer> custs = new ArrayList<Customer>();
	
	private static final Scanner sc = new Scanner(System.in);
	
    public ArrayList<Customer> getCustomers() { return custs; }  
	
    public Customer getCustomer(String name)
    {
        for (int i=0; i<custs.size(); i++)
           if ( custs.get(i).getName().compareTo(name)==0)
              return custs.get(i);
        return null;
    }
	
	public static void main(String[] args) {
		 // variables required to process user's menu selection
	      String input;
	      char selection = '\0';

	      // keep repeating the menu until the user chooses to exit
	      do
	      {
	         // display menu options
	         System.out.println("******* Video Rental System Menu *******");
	         System.out.println("");
	         System.out.println("A - Employee");
	         System.out.println("B - Customer");
	         System.out.println("X - Exit Program");
	         System.out.println();

	         // prompt the user to enter their selection
	         System.out.print("Enter your selection: ");
	         input = sc.nextLine();

	         System.out.println();

	         // check to see if the user failed to enter exactly one character
	         // for their menu selection

	         if (input.length() != 1)
	         {
	            System.out.println("Error - selection must be a single"
	                               + " character!");

	         }
	         else
	         {
	            // extract the user's menu selection as a char value and
	            // convert it to upper case so that the menu becomes
	            // case-insensitive

	            selection = Character.toUpperCase(input.charAt(0));

	            // process the user's selection
	            switch (selection)
	            {
	            case 'A':

	               // call addTour() helper method
	               employeeMenu();
	               break;

	            case 'B':

	               // call displayTourSummary() helper method
	            	customerMenu();
	               break;

	            case 'X':

	               System.out.println("Video Rental system shutting down – goodbye!");
	               break;

	            default:

	               // default case - handles invalid selections
	               System.out.println("Error - invalid selection!");

	            }
	         }
	         System.out.println();

	      } while (selection != 'X');

	   }
	   private static final void employeeMenu()
	   {
		   String input;
		      char selection = '\0';

		      // keep repeating the menu until the user chooses to exit
		      do
		      {
		         // display menu options
		         System.out.println("******* Employee Menu *******");
		         System.out.println("");
		         System.out.println("A - Add Movie");
		         System.out.println("B - Add Customer");
		         System.out.println("X - Exit Program");
		         System.out.println();

		         // prompt the user to enter their selection
		         System.out.print("Enter your selection: ");
		         input = sc.nextLine();

		         System.out.println();

		         // check to see if the user failed to enter exactly one character
		         // for their menu selection

		         if (input.length() != 1)
		         {
		            System.out.println("Error - selection must be a single"
		                               + " character!");

		         }
		         else
		         {
		            // extract the user's menu selection as a char value and
		            // convert it to upper case so that the menu becomes
		            // case-insensitive

		            selection = Character.toUpperCase(input.charAt(0));

		            // process the user's selection
		            switch (selection)
		            {
		            case 'A':

		               // call addTour() helper method
		              addMovie();
		               break;

		            case 'B':

		               // call displayTourSummary() helper method
		            	addCustomer();
		               break;

		            case 'X':

		               System.out.println("Video Rental system shutting down – goodbye!");
		               break;

		            default:

		               // default case - handles invalid selections
		               System.out.println("Error - invalid selection!");

		            }
		         }
		         System.out.println();

		      } while (selection != 'X');
	   }
	   private static final void addMovie()
	   {
		   
	   }
	   private static final void addCustomer()
	   {
		   System.out.print("Enter customerID : ");        
		      String custID = sc.nextLine();
		      
		   System.out.print("Enter customer name : ");        
		   	  String name = sc.nextLine();
		   	  
		   System.out.print("Enter customer address : ");        
		   	  String address = sc.nextLine();
		   	  
		   System.out.print("Enter customer email : ");        
		   	  String email = sc.nextLine();
		   	  
		   System.out.print("Enter customer phone number : ");        
		   	  String phone = sc.nextLine();
		   	  
		   System.out.print("Enter customer rating (Standard/Premium) : ");        
		   	  String rating = sc.nextLine();

		      // Stores the new tour details in an array
		   	Customer objt = new Customer(custID,name,address,email,phone,rating);
		   	custs.add(objt);
		   
		   	  
		   System.out.print("Customer details stored successfully "); 	  
		   
	   }
	  
	   private static final void customerMenu()
	   {
		   
           
	   }
	

}
