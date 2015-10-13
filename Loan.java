package VideoRental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Loan {
	
	Scanner scan = new Scanner(System.in);
	Movie movie = new Movie("Finding Nemo", "Children", 13.0, 7.0, 3, 3.00);
	public ArrayList<Movie> movies;
	
	LoanItem loan = new LoanItem();
	private String dateDue;
	private String dateReturned;
	private String status;
	private double fine;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();
	private double total = 0;

	public Loan(ArrayList<Movie> movies)
	{
		this.movies = movies;
	}
	
	public void calcFine(ArrayList<Movie> movies, String enteredTitle, String returnedDate) {
		
		for(Movie movie : movies)
		{
			
			if(enteredTitle.equalsIgnoreCase(movie.getMovTitle()))
			{
				
				int overdueDays = returnedDate.compareTo(dateDue);
				System.out.println("This movie is overdue by " + overdueDays + " days" );
				if (overdueDays > 0) {
					fine = movie.getOverdueCharge() * overdueDays;
				} else if (overdueDays <= 0) {
					fine = 0;
				}
				
			}
		}
	}

	public void printDate() {
		System.out.println(date.toString());
	}

	public double calcTotal(ArrayList<Movie> movie ) {
		
		/*
		 * use movie title - get charge
		 * add to total
		 * repeat for all movies
		 * apply discount (10% off) if premium
		 * add joining fee if apllicable
		 * add overdue fees
		 * print total
		 * 
		 */
		
		
//		for (int i = 0; i > subtotal.length; i++) {
//			total += subtotal[i];
//		}
//
//		total -= discount;
//		total += fine;
//		// total +=getJoiningFee();
//		return total;
		return 0;
	}

	public String enterDueDate(String dateDue) throws ParseException {

		sdf.parse(dateDue);
		return dateDue;

	}

	public void printMovieDetails(ArrayList<Movie> movies, String enteredTitle)  {
		
		
		for(Movie movie : movies)
		{
			
			if(enteredTitle.equalsIgnoreCase(movie.getMovTitle()))
			{
				System.out.println("************");
				System.out.println("Movie Title: " + movie.getMovTitle());
				System.out.println("Rental charged: $" + movie.getRentalCharge());
				System.out.println("Rental period: " + movie.getRentalPeriod());
				System.out.println("Due date: " + dateDue);
				System.out.println("Overdue charge per day if late: $"
						+ movie.getOverdueCharge());
			}
			
		}
		

	}

	public String enterActualDate() throws ParseException {
		System.out.println("Enter returned date: ");
		dateReturned = scan.nextLine();
		sdf.parse(dateReturned);
		return dateReturned;

	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDateDue() {
		return dateDue;
	}

	public void setDateDue(String dateDue) {
		this.dateDue = dateDue;
	}

	public String getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(String dateReturned) {
		this.dateReturned = dateReturned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

}
