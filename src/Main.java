

/**
 * Write a description of class Main here.
 * 
 * @author Parag Mahajan
 * @version 1.1 16 Sept 2014
 */

import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
    static int customerCount = 0;
    static Shop shop = new Shop();
    static Scanner sc = new Scanner(System.in);

    /**
     * Main method program starts here.
     * 
     * @param   string array    used for command line argument to run shop functinality.
     * @return     nothing
     */
   public static void main(String args[])
    {
        String option = args[0];
        
        
        if(option.equals("sell") || option.equals("show"))
        {
            run();
        }else
        {
        
            System.out.println("Please run program correctly. Try again!!");
            System.exit(0);
        }
        
    
    }
    
  /**
     * This method is used to show menu to user.
     * 
     * @param  nothing
     * @return    nothing
     */  
  public static void run()
   {
    
    if(customerCount == 4) // code to show demo for only 4 users. after that show method will get executated to show sold items.
        show();
     else
        customerCount++;
        
    System.out.println("=====================================");
    System.out.println("Welcome to media shop");
    System.out.println("=====================================");
    System.out.println("Choose from the following:");
    System.out.println(" 1.Books(enter 'b') \n 2.CDs(enter 'c') \n 3.Movies(enter 'm')");
    System.out.print("Choice: ");
  
    getMenuOption();

    
   }
   
   /**
     * This method shows user all books, cds and movies sold and revenue.
     * 
     * @param  nothing
     * @return     nothing
     */
   public static void show()
   {
       System.out.println("=====================================");
       System.out.println(shop.displaySalesItem());
       System.out.println("=====================================");
       System.exit(0);
   }
   
   /**
     * This method gets choice of media from user and validates it. 
     * On proper response it calls another method to display list of seleted media
     * 
     * @param  nothing
     * @return     nothing
     */
   public static void getMenuOption()
    {
        char choice;
        
        choice = sc.next().trim().charAt(0);
    
        switch(choice)
        {
           case 'b':
                        System.out.println("Books: ");
                        displayBooksAvailable();
                        break;
           case 'c':
                        System.out.println("CDs: ");
                        displayCDsAvailable();
                        break;
           case 'm':
                        System.out.println("Movies");
                        displayMoviesAvailable();
                        break;
           default:     
                        System.out.println("Invalid choice try again.");
                        getMenuOption();
                 
        }
    }
    
    /**
     * This method shows list of books available and get input from user to select particualar book and validates input. 
     * 
     * @param  nothing
     * @return     nothing
     */
    public static void displayBooksAvailable()
    {
        ArrayList<Book> books = shop.getBooks();
    
        int choice = 0;

        System.out.println("Type the number to choose a book.");
        Book selectedBook;
        System.out.println("==================================");
        
        for(Book book: books)
        {
           if(book.getAvailable() > 1) 
                System.out.println(books.indexOf(book)+1 + ". " + book.getTitle() + " by " + book.getAuthor() + ", Price: "+ book.getPrice() + " Available: " + book.getAvailable()+" Rating:"+book.r.getAvarageRating());
        }
        
        System.out.print("Enter book number: ");
        String choiceStr = sc.next().trim();
        if(Warehouse.isInteger(choiceStr))
            choice = Integer.parseInt(choiceStr);
        else{
            System.out.println("Please enter valid number.");
            displayBooksAvailable();
        }    
            
        if(0<choice && choice<=books.size())
        {
           selectedBook = books.get(choice-1);
           System.out.println("Ypu have selected " + selectedBook.getTitle() +"\n ");
           chooseQuantityOfBooks(selectedBook);
        }else{
           System.out.println("Please enter valid number.");
           displayBooksAvailable();
        }
    
    }
    
    /**
     * This method gets number of copies of book from user and validates it and makes a sell.
     * 
     * @param  Book object
     * @return     nothing
     */
    public static void chooseQuantityOfBooks(Book book)
    {

        int quantity = 0;
        boolean sold;
        System.out.print("Please enter the number of copies you want.");
        
        String choiceStr = sc.next().trim();
        if(Warehouse.isInteger(choiceStr))
            quantity = Integer.parseInt(choiceStr);
        else{
            System.out.println("You have entered invalid number.");
            chooseQuantityOfBooks(book);
        }

        
        sold = book.sellCopies(quantity);
        if(sold)
        {
            System.out.println("You have been charged  "+ quantity * book.getPrice());
            rateBookSold(book);
        }    
        else{
            System.out.println("You have entered more copies than available. Try again");
            chooseQuantityOfBooks(book);
        }
    }
    
    /**
     * This method gets rating for book from user, validates it and saves it. 
     * 
     * @param  Book
     * @return     nothing
     */
    public static void rateBookSold(Book book)
    {
       int rating = 0;
       System.out.println("==================================");
       System.out.println("Rate the book you have bought on a scale of 1 - 10. 10 is excellent. 1 is absulately uninteresting.\n");
       System.out.print("Enter Rating:");
       String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           rating = Integer.parseInt(choiceStr);
      else{
           System.out.println("Please enter valid rating between 1 and 10");
           rateBookSold(book);
       }  
        
       if(rating > 0 && rating <11 )
       {
           book.updateRating(rating);
           System.out.println("Your rating have been saved. Thank you for your feedback.");
           System.out.println("Good Bye");
           run();// code to show again menu list to user.
       }else{
           System.out.println("Please enter valid rating between 1 and 10");
           rateBookSold(book);
       }
    }
    
    /**
     * This method shows list of cds available and get input from user to select particualar cd and validates input. 
     * 
     * @param  nothing
     * @return     nothing
     */
    public static void displayCDsAvailable()
    {
        ArrayList<CD> cds = shop.getCDs();
        int choice = 0;
        System.out.println("Type the number to choose a cd.");
        CD selectedCD;
        System.out.println("==================================");
        
        for(CD cd: cds)
        {
           if(cd.getAvailable() > 1) 
                System.out.println(cds.indexOf(cd)+1 + ". " + cd.getTitle() + " Performer: " + cd.getPerformer() + ", File Type: "+ cd.getFileType()+", Price: "+ cd.getPrice() + " Available: " + cd.getAvailable());
        }
       
       System.out.print("Enter cd number: "); 
       String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           choice = Integer.parseInt(choiceStr);
       else{
           System.out.println("Please enter valid number.");
           displayCDsAvailable();
        }     
        
        if(0<choice && choice<=cds.size())
        {
           selectedCD = cds.get(choice-1);
           System.out.println("Ypu have selected " + selectedCD.getTitle() +"\n ");
           chooseQuantityOfCDs(selectedCD);
        }else{
           System.out.println("Please enter valid number.");
           displayCDsAvailable();
        } 
       
    }
    
    /**
     * This method gets number of copies of cd from user and validates it and makes a sell.
     * 
     * @param  CD object
     * @return     nothing
     */
    public static void chooseQuantityOfCDs(CD cd)
    {
        int quantity = 0;
        boolean sold;
        System.out.print("Please enter the number of copies you want.");
        String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           quantity = Integer.parseInt(choiceStr);
        else  
            chooseQuantityOfCDs(cd);
            
        sold = cd.sellCopies(quantity);
        if(sold)
        {
            System.out.println("You have been charged  "+ quantity * cd.getPrice());
            rateCDSold(cd);
        }    
        else{
            System.out.println("You have entered more copies than available. Try again");
            chooseQuantityOfCDs(cd);
        }
        
    }
    
    /**
     * This method gets rating for cd from user, validates it and saves it. 
     * 
     * @param  CD
     * @return     nothing
     */
    public static void rateCDSold(CD cd)
    {
       int rating = 0;
       System.out.println("==================================");
       System.out.println("Rate the CD you have bought on a scale of 1 - 10. 10 is excellent. 1 is absulately uninteresting.\n");
       String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           rating = Integer.parseInt(choiceStr);
       else{
           System.out.println("Please enter valid rating between 1 and 10");
           System.out.print("Enter Rating:");
           rateCDSold(cd);
       } 
       
       if(rating > 0 && rating < 11 )
       {
           cd.updateRating(rating);
           System.out.println("Your rating have been saved. Thank you for your feedback.");
           System.out.println("Good Bye");
           run();// code to show again menu list to user.
       }else{
           System.out.println("Please enter valid rating between 1 and 10");
           rateCDSold(cd);
       }
    }
    
    /**
     * This method shows list of movies available and get input from user to select particualar movie and validates input. 
     * 
     * @param  nothing
     * @return     nothing
     */
    public static void displayMoviesAvailable()
    {
        ArrayList<Movie> movies = shop.getMovies();
        int choice = 0;
        System.out.println("Type the number to choose a movie.");
        Movie selectedMovie;
        
        for(Movie movie: movies)
        {
           if(movie.getAvailable() > 1) 
                      System.out.println(movies.indexOf(movie)+1 + ". " + movie.getTitle() + " Director: " + movie.getDirector() + ", File Type: "+ movie.getFileType()+", Price: "+ movie.getPrice() + " Available: " + movie.getAvailable());
        }
      
       System.out.print("Enter movie number: "); 
       String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           choice = Integer.parseInt(choiceStr);
        else{
            System.out.println("Please enter valid choice.");
            displayMoviesAvailable();
        }    
        
        if(0<choice && choice<=movies.size())
        {
           selectedMovie = movies.get(choice-1);
           System.out.println("Ypu have selected " + selectedMovie.getTitle() +"\n ");
           chooseQuantityOfMovies(selectedMovie);
        }else{
           System.out.println("Please enter valid choice.");
           displayMoviesAvailable();
        } 
       
    }
    
    /**
     * This method gets number of copies of movie from user and validates it and makes a sell.
     * 
     * @param  Movie object
     * @return     nothing
     */
    public static void chooseQuantityOfMovies(Movie movie)
    {
        int quantity = 0;
        boolean sold;
        System.out.print("Please enter the number of copies you want.");
        String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           quantity = Integer.parseInt(choiceStr);
        else
            chooseQuantityOfMovies(movie);
            
        sold = movie.sellCopies(quantity);
        if(sold)
        {
            System.out.println("You have been charged  "+ quantity * movie.getPrice());
            rateMovieSold(movie);
        }    
        else{
            System.out.println("You have entered more copies than available. Try again");
            chooseQuantityOfMovies(movie);
        }
    }
    
    /**
     * This method gets rating for movie from user, validates it and saves it. 
     * 
     * @param  Movie
     * @return     nothing
     */
    public static void rateMovieSold(Movie movie)
    {
       int rating = 0;
       System.out.println("==================================");
       System.out.println("Rate the Movie you have bought on a scale of 1 - 10. 10 is excellent. 1 is absulately uninteresting.\n");
       System.out.print("Enter Rating:");
       String choiceStr = sc.next().trim();
       if(Warehouse.isInteger(choiceStr))
           rating = Integer.parseInt(choiceStr);
      else{
           System.out.println("Please enter valid rating between 1 and 10");
           rateMovieSold(movie);
       }     
           
       if(rating > 0 && rating < 11 )
       {
           movie.updateRating(rating);
           System.out.println("Your rating have been saved. Thank you for your feedback.");
           System.out.println("Good Bye");
           run();// code to show again menu list to user.
       }else{
           System.out.println("Please enter valid rating between 1 and 10");
           rateMovieSold(movie);
       }
    }
    
    
}