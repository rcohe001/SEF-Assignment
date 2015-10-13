public class addMovies()
{
        System.out.println("****** Add new movie ******);
        System.out.println("Enter Video Title : ");
            String vidTitle = sc.nextLine();
        
        System.out.print("Enter Video Category : ")
            String category = sc.nextLine();
            
        System.out.print("rental-charge : ");
            Double rental-charge = sc.nextLine();
            
        System.out.print("rental-period : ");
            Double rental-period = sc.nextLine();
        
        System.out.print("year-of-release : ");
            int year-of-release = sc.nextLine();
            
        System.out.print("overdue-charge : ");
            Double overdue-charge = sc.nextLine();
            
            //Stores all the details in an array
            video objt = new Video(vidTitle, category, rental-charge, rental-period, year-of-releasem overdue-charge);
            videos.add(objt);
            
        
        System.out.print("Video details stored successfully ");
        
    }
        
