package VideoRental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class VideoRentalSystem {

	private ArrayList<Customer> custs = new ArrayList<Customer>();
	private ArrayList<Movie> movie = new ArrayList<Movie>();
	private ArrayList<MovieCopy> movieCopy = new ArrayList<MovieCopy>();
	private ArrayList<Loan> loan = new ArrayList<Loan>();
	private ArrayList<Clerk> emp = new ArrayList<Clerk>();
	private Clerk clerk = null;
	private int rentalCount = 0;
	private static final Scanner sc = new Scanner(System.in);

	public ArrayList<Customer> getCustomers() {
		return custs;
	}

	public ArrayList<Movie> getMovie() {
		return movie;
	}

	public ArrayList<MovieCopy> getMovieCopy() {
		return movieCopy;
	}

	public ArrayList<Clerk> getClerks() {
		return emp;
	}
	public ArrayList<Loan> getLoan() {
		return loan;
	}

	public Customer getCustomer(String name) {
		for (int i = 0; i < custs.size(); i++)
			if (custs.get(i).getName().compareTo(name) == 0)
				return custs.get(i);
		return null;
	}

	public Movie getMovie(String title) {
		for (int i = 0; i < movie.size(); i++)
			if (movie.get(i).getMovTitle().compareTo(title) == 0)
				return movie.get(i);
		return null;
	}

	public static void main(String[] args) {
		VideoRentalSystem f = new VideoRentalSystem();
		f.go();
	}

	// variables required to process user's menu selection
	public void go() {
		String input;
		char selection = '\0';

		// keep repeating the menu until the user chooses to exit

		do {
			// display menu options
			System.out.println("******* Video Rental System Menu *******");
			System.out.println("");
			System.out.println("A - Login as Clerk");
			System.out.println("B - Search By Title");
			System.out.println("C - Search By Category");
			System.out.println("D - Rent a Movie");
			System.out.println("W - Display Loan details");
			System.out.println("W - Display Movie Copy");
			System.out.println("Y - Display Customers");
			System.out.println("Z - Display Movies");
			System.out.println("X - Exit Program");
			System.out.println();

			// prompt the user to enter their selection
			System.out.print("Enter your selection: ");
			input = sc.nextLine();

			System.out.println();

			// check to see if the user failed to enter exactly one character
			// for their menu selection

			if (input.length() != 1) {
				System.out.println("Error - selection must be a single" + " character!");

			} else {
				// extract the user's menu selection as a char value and
				// convert it to upper case so that the menu becomes
				// case-insensitive

				selection = Character.toUpperCase(input.charAt(0));

				// process the user's selection
				switch (selection) {
				case 'A':

					login();
					// employeeMenu();
					break;
				case 'B':
					searchByTitle();
					break;
				case 'C':
					searchByCategory();
					break;
				case 'D':
					rentMovie();
					break;
				case 'V':
					// call addTour() helper method
					displayLoan();
					break;
				case 'W':
					// call addTour() helper method
					displayMovieCopy();
					break;
				case 'Y':
					displayCustSummary();
					break;
				case 'Z':
					displayMovSummary();
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

	public void login() {
		System.out.println("*** Please Enter Login details ***");
		System.out.print("Enter username : ");
		String un = sc.nextLine();
		System.out.print("Enter password : ");
		String pw = sc.nextLine();
		int i;
		for (i = 0; i < emp.size(); i++)
			if (emp.get(i).getUsername().compareTo(un) == 0 && emp.get(i).getPassword().compareTo(pw) == 0) {
				clerk = emp.get(i);
				System.out.println("Welcome " + clerk.getEmpName());
				clerkMenu();
				break;
			}

		if (i == emp.size())
			System.out.println("Invalid username/password");
		System.out.println("Press enter to continue");
		sc.nextLine();

	}

	private void clerkMenu() {

		String input;
		char selection = '\0';

		// keep repeating the menu until the user chooses to exit
		do {
			// display menu options
			System.out.println("******* Clerk Menu *******");
			System.out.println("");
			System.out.println("A - Add Movie");
			System.out.println("B - Add Movie copy");
			System.out.println("C - Add Customer");
			System.out.println("Y - Diplay Movie Copy details");
			System.out.println("X - Exit Program");
			System.out.println();

			// prompt the user to enter their selection
			System.out.print("Enter your selection: ");
			input = sc.nextLine();

			System.out.println();

			// check to see if the user failed to enter exactly one character
			// for their menu selection

			if (input.length() != 1) {
				System.out.println("Error - selection must be a single" + " character!");

			} else {
				// extract the user's menu selection as a char value and
				// convert it to upper case so that the menu becomes
				// case-insensitive

				selection = Character.toUpperCase(input.charAt(0));

				// process the user's selection
				switch (selection) {

				case 'A':

					// call displayTourSummary() helper method
					addMovie();
					break;
				case 'B':

					// call addTour() helper method
					addMovieCopy();
					break;
				case 'C':

					// call addTour() helper method
					addCustomer();
					break;

				case 'Y':

					// call addTour() helper method
					displayMovieCopy();
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

	private void addMovie() {
		System.out.println("****** Add new movie ******");

		System.out.print("Enter Movie ID : ");
		String movId = sc.nextLine();

		System.out.print("Enter Movie Title : ");
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
		//String odCharge = sc.nextLine();
		//double overdueCharge = Double.parseDouble(odCharge);
		System.out.print("");
		String odCharge = sc.nextLine();
		// Stores all the details in an array
		Movie objt = new Movie(movId, movTitle, category, rentalCharge, rentalPeriod, yearOfRelease, overdueCharge);
		movie.add(objt);

		
		System.out.println("Video details stored successfully ");
		addMovieCopy();
	}

	private void addMovieCopy() {

		System.out.println("****** Add new movie copy ******");
		System.out.print("Enter a Movie ID :");
		String movId = sc.nextLine();
		Movie temp = null;
		
		for (int i = 0; i < movie.size(); i++) {
			
			
			if (movie.get(i).getMovID().equals(movId)){
				temp = movie.get(i);
			}
		}
		if(temp == null) {
			System.out.println("");
			System.out.println("Movie copy cannot be stored");
		}
		else {

			System.out.print("Enter Movie Copy ID : ");
			String movCopyID = sc.nextLine();

			System.out.print("Date-Purchased : ");
			String datePurchased = sc.nextLine();

			String movCondition = "Good";
			String movStatus = "Available";
			rentalCount = 0;

			// Stores all the details in an array
			MovieCopy objt = new MovieCopy(movId, movCopyID, datePurchased, movCondition, movStatus, rentalCount);
			movieCopy.add(objt);

			System.out.println("Movie copy is stored successfully ");

		} 
	}

	private void addCustomer() {
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
		Customer objt = new Customer(custID, name, address, email, phone, rating);
		custs.add(objt);

		System.out.print("Customer details stored successfully ");

	}

	private void rentMovie() {
		System.out.println("****** Add new customer ******");
		System.out.print("Enter CustID : ");
		String custId = sc.nextLine();
		String resp = "";
		Customer cust =null;
		Movie temp = null;
		MovieCopy movCopy = null;
		
        for (int i = 0; i < custs.size(); i++) {
			if (custs.get(i).getCustID().equals(custId)){
				cust = custs.get(i);
			}
		}
        
        if(cust== null){
        	System.out.println("");
			System.out.println("Customer Id cannot be found");
			
        }
       int loanID = 0;
        ArrayList<Integer> loanId = new ArrayList<Integer>();
        for (int i=1; i<11; i++) {
        	loanId.add(new Integer(i));
        }
        Collections.shuffle(loanId);
        for (int i=0; i<1; i++) {
        	 loanID = loanId.get(i);
            System.out.println("Loan ID: " +loanID);
        }
        
//        int j = 1;
//        Integer[] loanId = new Integer[1];
//        for (j = 0; j < 1; j++) {
//        	loanId[j] = j;
//        }
//        Collections.shuffle(Arrays.asList(loanId));
//        String loanID = Arrays.toString(loanId);
//        System.out.println("LoanID: " + loanID);
            
        
        do{
        if(cust != null){
//        System.out.print("Enter LoanID : ");
//		String loanId = sc.nextLine();
		
		System.out.print("Enter MovieID : ");
		String movId = sc.nextLine();
		
        for (int i = 0; i < movie.size(); i++) {
			if (movie.get(i).getMovID().equals(movId)){
				temp = movie.get(i);
			}
		}
        for (int i = 0; i < movieCopy.size(); i++) {
			if (movieCopy.get(i).getMovID().equals(movId) 
					&& movieCopy.get(i).getMovStatus() == "Available"){
				
				movCopy = movieCopy.get(i);
			}
		}
        
        
       if(temp == null) {
			System.out.println("");
			System.out.println("Movie Id cannot be found");
		}
       else if(movCopy.getMovStatus() != "Available"){
    	   System.out.println("Sorry this movie can't be rented. This movie is " +
           movCopy.getMovStatus());
       }
        else if(movCopy.getMovStatus() == "Available"){
			  
			  
		    //  Date dateObject = new Date();
		     // rentDate = dateObject.toString();
	         movCopy.setMovStatus("OnLoan"); 
	        
	 		  
	         System.out.println("Movie checked out successfully");
	         int rc = rentalCount++;
		}
        Date rentalDate = new Date();
        Loan ln = new Loan(loanID, custId, rentalDate );
        loan.add(ln);
        System.out.print("Any more items ? : Y/N");
        resp = sc.nextLine().toUpperCase();
        }
        }while (resp.compareTo("Y") == 0 );
        
        
        
	}

	private void displayLoan() {
		System.out.println("List of Loan:" + "\n");
		int i = 0;
		for (i = 0; i < loan.size(); i++) {

			System.out.println("CustID:" + loan.get(i).getCustID());
			System.out.println("Rental date:" +loan.get(i).getRentalDate());
			System.out.println("LoanID:" + loan.get(i).getLoanID());
			
		}
	}
	
	private void displayCustSummary() {
		System.out.println("List of Available Customer:" + "\n");
		int i = 0;
		for (i = 0; i < custs.size(); i++) {

			System.out.println("CustID:" + custs.get(i).getCustID());
			System.out.println("Name:" +custs.get(i).getName());
			System.out.println("Address:" + custs.get(i).getAddress());
			System.out.println("Email" + custs.get(i).getEmail());
			System.out.println("Phone" + custs.get(i).getPhone());
			System.out.println("Rating" +custs.get(i).getRating());
		}
	}

	private void displayMovSummary() {
		System.out.println("List of Available Movies:" + "\n");
		int i = 0;
		for (i = 0; i < movie.size(); i++) {
			System.out.println("MovID: " + movie.get(i).getMovID());
			System.out.println("MovTitle: " + movie.get(i).getMovTitle());
			System.out.println("Category: " + movie.get(i).getCategory());
			System.out.println("RentalCharge: " + movie.get(i).getRentalCharge());
			System.out.println("RentalPeriod: " + movie.get(i).getRentalPeriod());
			System.out.println("YearOfRelease: " + movie.get(i).getYearOfRelease());
			System.out.println("OverdueCharge: " + movie.get(i).getOverdueCharge());
		}

	}

	private void displayMovieCopy() {
		System.out.println("List of Available Movies:" + "\n");
		int i = 0;
		for (i = 0; i < movieCopy.size(); i++) {

			System.out.println("MovID: " + movieCopy.get(i).getMovID());
			System.out.println("MovCopyID: " + movieCopy.get(i).getMovCopyID());
			System.out.println("DatePurchased: " + movieCopy.get(i).getDatePurchased());
			System.out.println("MovCondition: " + movieCopy.get(i).getMovCondition());
			System.out.println("MovStatus: " + movieCopy.get(i).getMovStatus());
			System.out.println("RentalCount: " + movieCopy.get(i).getRentalCount());
		}

	}

	private void searchByTitle() {
		System.out.print("Please enter a title:");
		String searchTitle = sc.nextLine().toUpperCase();

		Movie temp = null;
		int i = 0;

		for (i = 0; i < movie.size(); i++) {
			if (movie.get(i).getMovTitle().toUpperCase().equals(searchTitle)) {
				temp = movie.get(i);
			}

		}

		if (temp == null) { // prompts an error message if temp is null
			System.out.println("Movie is not available");
		} else {
			System.out.println("Movie " + temp.getMovTitle() + " is Available");
		}

	}

	private void searchByCategory() {
		System.out.print("Please enter a Category(Action/Comedy/Drama/Family):");
		String searchCategory = sc.nextLine().toUpperCase();

		Movie temp = null;
		int i = 0;
		System.out.println("List of available movies:-");

		for (i = 0; i < movie.size(); i++) {

			temp = movie.get(i);
			if (movie.get(i).getCategory().toUpperCase().equals(searchCategory)
					&& movie.get(i).getCategory() == "Action") {

				System.out.println("Title: " + movie.get(i).getMovTitle() + " Category: " + movie.get(i).getCategory());
			} else if (movie.get(i).getCategory().toUpperCase().equals(searchCategory)
					&& movie.get(i).getCategory() == "Drama") {
				System.out.println("Title: " + movie.get(i).getMovTitle() + " Category: " + movie.get(i).getCategory());
			} else if (movie.get(i).getCategory().toUpperCase().equals(searchCategory)
					&& movie.get(i).getCategory() == "Family") {
				System.out.println("Title: " + movie.get(i).getMovTitle() + " Category: " + movie.get(i).getCategory());
			} else if (movie.get(i).getCategory().toUpperCase().equals(searchCategory)
					&& movie.get(i).getCategory() == "Comedy") {
				System.out.println("Title: " + movie.get(i).getMovTitle() + " Category: " + movie.get(i).getCategory());
			}

			// if(temp == null){
			//
			// System.out.println("Movie not found in this category");
			// }

		}

	}

	VideoRentalSystem() {
		Clerk objt1 = new Clerk("Priya", "priya", "123");
		emp.add(objt1);

		custs.add(new Customer("1", "Derrik", "Pointcook", "derrick@gmail.com", "0433678123", "Premium"));
		custs.add(new Customer("2", "Jimmy", "Werribee", "jimmy@gmail.com", "0456123897", "Standard"));

		movie.add(new Movie("1", "Home", "Drama", 12.00, 5.00, 2013, 2.00));
		movie.add(new Movie("2", "Avatar", "Family", 12.00, 5.00, 2013, 2.00));
		movie.add(new Movie("3", "Dragon Hunt", "Action", 12.00, 6.00, 2014, 3.00));
		movie.add(new Movie("4", "Hang Over", "Comedy", 12.00, 7.00, 2015, 4.00));
		movie.add(new Movie("5", "Avengers", "Action", 10.00, 3.00, 2016, 3.00));
		movieCopy.add(new MovieCopy("1", "01", "1.10.2015", "Good", "Available", 0));
		movieCopy.add(new MovieCopy("1", "02", "03.2.2014", "Good", "Available", 0));
		movieCopy.add(new MovieCopy("2", "02", "2.1.2014", "Good", "Available", 0));
	}
}
