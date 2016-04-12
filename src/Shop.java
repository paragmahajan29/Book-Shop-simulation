
/**
 * Write a description of class Shop here.
 * 
 * @author Parag Mahajan
 * @version 1.1 14 Sept 2014
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    // instance variables - replace the example below with your own
    private ArrayList<Movie> movies;
    private ArrayList<CD> cds;
    private ArrayList<Book> books;
    Scanner sc = new Scanner(System.in);
    /**
     * Constructer of Shop. gets initiated from Warehaouse static methods.
     * 
     * @param  nothing
     * @return     nothing
     */
    public Shop()
    {
        books = Warehouse.getBooks();
        cds = Warehouse.getCDs();
        movies = Warehouse.getMovies();

    }        
    
    /**
     * This method used to generate revenune statement of shop. 
     * 
     * @param  nothing
     * @return     String
     */
    public String displaySalesItem()
    {
        return "Sold "+ getSoldBooks() + " Books, " + " sold " + getSoldCds() + " CDs and sold " + getSoldMovies() + " Movies, total revenue is " + calculateRevenue();
        
    }
    
    /**
     * This method returns book list.
     * 
     * @param  nothing
     * @return     ArrayList<Book>
     */    
    public ArrayList<Book> getBooks()
    {
        return books;
    }
    
    /**
     * This method returns cd list.
     * 
     * @param  nothing
     * @return     ArrayList<CD>
     */    
    public ArrayList<CD> getCDs()
    {
        return cds;
    }
    
    /**
     * This method returns movie list.
     * 
     * @param  nothing
     * @return     ArrayList<Movie>
     */    
    public ArrayList<Movie> getMovies()
    {
        return movies;
    }
    
    
    /**
     * This method return total revenue of shop. 
     * 
     * @param  nothing
     * @return     total revenue
     */
    public double calculateRevenue()
    {
        double totalRevenue = 0.0;
        for(Book book: books)
        {
            totalRevenue += book.getSold() * book.getPrice();
        }
        for(CD cd: cds)
        {
            totalRevenue += cd.getSold() * cd.getPrice();
        }
        for(Movie movie: movies)
        {
            totalRevenue += movie.getSold() * movie.getPrice();
        }
        
        return totalRevenue;
    
    }
    
    /**
     * This method gives number of books sold. 
     * 
     * @param  nothing
     * @return     int
     */
    public int getSoldBooks()
    {
        int soldBooks = 0;
        
        for(Book book: books)
        {
            soldBooks += book.getSold();
        }
        
        return soldBooks;
    
    }
    
    /**
     * This method gives number of cds sold. 
     * 
     * @param  nothing
     * @return     int
     */
    public int getSoldCds()
    {
        int soldCDs = 0;
        for(CD cd: cds)
        {
            soldCDs += cd.getSold(); 
        
        }
        
        return soldCDs;
    }
    
    /**
     * This method gives number of movies sold. 
     * 
     * @param  nothing
     * @return     int
     */
    public int getSoldMovies()
    {
        int soldMovies = 0;
        for(Movie movie: movies)
        {
            soldMovies += movie.getSold();
        }
        return soldMovies;
    }   
   
}
