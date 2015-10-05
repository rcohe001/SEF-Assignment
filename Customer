package VideoRental;

public class Customer {
	private String custID;
	   private String name;
	   private String address;
	   private String email;
	   private String phone;
	   private String rating;
	   private double discount;

	   public Customer(String custID, String name,
			           String address, String email,String phone,String rating )
	   {
		    this.custID = custID;
	        this.name = name;
	        this.address = address;
	        this.email = email;
	        this.phone = phone;
	        this.rating = rating;
	   }
	   public String getCustID() { return custID; }
	   public String getName() {return name; }
	   public String getAddress() { return address; }
	   public String getEmail() { return email; }
	   public String getPhone() { return phone; }
	   public String getRating() { 
		  
		   return rating; 
	   }
	   public double CalcDisc(int amt)
	   {
		   if(rating == "Premium"){
			   amt-= amt * 0.1;
		   } 
		   return amt; 
	   }
	
}
