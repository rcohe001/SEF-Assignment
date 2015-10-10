package VideoRental;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


	public class Loan {
	Scanner scan = new Scanner(System.in);
	Movie movie = new Movie("Finding Nemo","Children",13.0,7.0,3,3.00);

	LoanItem loan = new LoanItem();
	public String dateDue;
	public String dateReturned;
	public String status;
	private double fine;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date date = new Date();
	private double total = 0;

public double calcFine(){
	int overdueDays = dateDue.compareTo(dateReturned);
	if(overdueDays>0){
		fine = movie.getOverdueCharge() * overdueDays;
	}else if (overdueDays<=0){
		fine = 0;
	}
		return fine;
	}

public void printDate(){
	System.out.println(date.toString());
}

public double calcTotal(double discount, double[] subtotal){
	for (int i = 0; i>subtotal.length; i++){
		total += subtotal[i];
	}
	
	total -= discount;
	total +=fine;
	//total +=getJoiningFee();
	return total;
}

public String enterDueDate(String dateDue) throws ParseException {
	
        sdf.parse(dateDue);
        return dateDue;

	
}
public void printMovieDetails(){
	System.out.println("************");
	System.out.println("Rental charged: " + movie.getRentalCharge());
	System.out.println("Rental period: "+ movie.getRentalPeriod());
	System.out.println("Due date: " + dateDue);
	System.out.println("Overdue charge per day if late: " + movie.getOverdueCharge());
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

}
