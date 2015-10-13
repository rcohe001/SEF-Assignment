package VideoRental;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoRentalSystem {

	public ArrayList<Customer> custs = new ArrayList<Customer>();
	public ArrayList<Movie> movie = new ArrayList<Movie>();
	public ArrayList<Clerk> emp = new ArrayList<Clerk>();
	private Clerk clerk = null;
	public Loan loan = new Loan(movie);
	public LoanItem item = new LoanItem();
	
	private static final Scanner sc = new Scanner(System.in);
	
    public ArrayList<Customer> getCustomers() { return custs; } 
    public ArrayList<Movie> getMovie() { return movie; } 
    public ArrayList<Clerk> getClerks() { return emp; } 
    
	
    public Customer getCustomer(String name)
    {
        for (int i=0; i<custs.size(); i++)
           if ( custs.get(i).getName().compareTo(name)==0)
              return custs.get(i);
        return null;
    }
	
    public Movie getMovie(String title)
    {
        for (int i=0; i<movie.size(); i++)
           if ( movie.get(i).getMovTitle().compareTo(title)==0)
              return movie.get(i);
        return null;
    }
    
	public static void main(String[] args) throws ParseException {
		  VideoRentalSystem f = new VideoRentalSystem();
	       f.go();
	   }	
		 // variables required to process user's menu selection
	public void go() throws ParseException
	   {
	      String input;
	      char selection = '\0';

	      // keep repeating the menu until the user chooses to exit
	   
	      do
	      {
	         // display menu options
	         System.out.println("******* Video Rental System Menu *******");
	         System.out.println("");
	         System.out.println("A - Login as Clerk");
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
	            	login();
	               //employeeMenu();
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
	 public void login() throws ParseException
	   {
		  System.out.println("*** Please Enter Login details ***"); 
	      System.out.print("Enter username : ");  
	      String un = sc.nextLine();
	      System.out.print("Enter password : ");     
	      String pw = sc.nextLine();
	      int i;
	      for (i=0; i< emp.size(); i++)
	        if ( emp.get(i).getUsername().compareTo(un)==0 && 
	                  emp.get(i).getPassword().compareTo(pw)==0)
	        {
	           clerk = emp.get(i);
	           System.out.println("Welcome " + clerk.getEmpName());
	           clerkMenu();
	           break;
	        }
	      
	      if ( i == emp.size() )
	         System.out.println("Invalid username/password"); 
	      System.out.println("Press enter to continue");
	      sc.nextLine();
	        
	      }
	   private void clerkMenu() throws ParseException
	   {
		   
		   
		   String input;
		      char selection = '\0';

		      // keep repeating the menu until the user chooses to exit
		      do
		      {
		         // display menu options
		         System.out.println("******* Clerk Menu *******");
		         System.out.println("");
		         System.out.println("A - Add Movie");
		         System.out.println("B - Add Customer");
		         System.out.println("C - Checkout Movie");
		         System.out.println("D - Return movie");
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
		               
		            case 'C':
		            	System.out.println("Enter due date: 'dd-MM-yyyy'");
		            	String enteredDate = sc.nextLine();
		               	System.out.println("Enter movie Title: ");
		             	String enteredTitle = sc.nextLine();
		             	
		            	loan.setDateDue(enteredDate); 
		            	loan.printMovieDetails(movie, enteredTitle);
		            	break;
		            	
		            case 'D':
		            	System.out.println("Enter return date: 'dd-MM-yyyy'");
		            	String returnedDate = sc.nextLine();
		               	System.out.println("Enter movie Title: ");
		             	String returnedTitle = sc.nextLine();
		             	

		            	loan.calcFine(movie, returnedTitle, returnedDate);
		            	System.out.println("You have been charged a fine of: " + loan.getFine());
		            	break;
		            case 'X':

		               System.out.println("Exited");
		               break;

		            default:

		               // default case - handles invalid selections
		               System.out.println("Error - invalid selection!");

		            }
		         }
		         System.out.println();

		      } while (selection != 'X');
	   }
	   private void addMovie()
	   {
		   
		   
		           System.out.println("****** Add new movie ******");
		           System.out.println("Enter Video Title : ");
		               String movTitle = sc.nextLine();
		           
		           System.out.print("Enter Movie Category : ");
		               String category = sc.nextLine();
		               
		           System.out.print("rental-charge : ");
		               Double rentalCharge = sc.nextDouble();
		               
		           System.out.print("rental-period : ");
		               Double rentalPeriod = sc.nextDouble();
		           
		           System.out.print("year-of-release : ");
		               int yearOfRelease = sc.nextInt();
		               
		           System.out.print("overdue-charge : ");
		               Double overdueCharge = sc.nextDouble();
		               
		               //Stores all the details in an array
		               Movie objt = new Movie(movTitle, category, rentalCharge, rentalPeriod, yearOfRelease, overdueCharge);
		               movie.add(objt);
		               
		           
		           System.out.print("Video details stored successfully ");
		           
		       
	   }
	   private void addCustomer()
	   {
		   System.out.println("****** Add new customer ******");
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
	  
	   private void customerMenu()
	   {
		   
           
	   }
	   
	   VideoRentalSystem()
	   {
			Clerk objt1 = new Clerk("Priya", "priya", "123");
		   	emp.add(objt1);
	   }
}
