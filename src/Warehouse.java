

import java.util.ArrayList;
/**
 * Write a description of class Warehouse here.
 * 
 * @author Parag Mahajan
 * @version 1.1 16 Sept 2014
 */


/**
     * This method initialize and returns book list.
     * 
     * @param  nothing
     * @return     ArrayList<Book>
     */    
public class Warehouse
{
    // instance variables - replace the example below with your own
   public static ArrayList<Book> getBooks()
    {
        ArrayList<Book> books = new  ArrayList<Book>();
        Book book;
        book = new Book("Five point someone", "Chetan Bhagat", 50, 14.00);
        books.add(book);
        book = new Book("Revolution 2020", "Chetan Bhagat", 70, 18.00);
        books.add(book);
        book = new Book("3 mistakes of my life", "Chetan Bhagat", 20, 12.99);
        books.add(book);
        book = new Book("Cloudstreet", "Tim Winton", 100, 14.00);
        books.add(book);
        book = new Book("Jasper Jones", "Craig Silvey", 80, 22.00);
        books.add(book);
        book = new Book("The Spare room", "Helen Garner", 100, 50.00);
        books.add(book);
        
        return books;
    }
    
    /**
     * This method initialize and returns cd list.
     * 
     * @param  nothing
     * @return     ArrayList<CD>
     */
     public static ArrayList<CD> getCDs()
    {
        ArrayList<CD> cds = new  ArrayList<CD>();
        CD cd;
        cd = new CD("Midnight Oil", "Diesel and Dust", "mp3", 100, 10.00);
        cds.add(cd);
        cd = new CD("Thriller", "Michael Jackson", "mp3", 700, 28.00);
        cds.add(cd);
        cd = new CD("Dangerous", "Michael Jackson", "mp3", 200, 32.00);
        cds.add(cd);
        cd = new CD("Recovery", "Eminem", "mp3", 67, 23.00);
        cds.add(cd);
        cd = new CD("Escape", "Enrique Iglesias", "mp3", 80, 25.00);
        cds.add(cd);
        cd = new CD("Euphoria", "Enrique Iglesias", "mp3", 50, 18.00);
        cds.add(cd);
        
        return cds;
    }
    
    /**
     * This method initialize and returns movie list.
     * 
     * @param  nothing
     * @return     ArrayList<Movie>
     */
    public static ArrayList<Movie> getMovies()
    {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie;
        movie = new Movie("Captain America", "Joe Johnston", "Marvel Studios", "mp4", 70, 33.00);
        movies.add(movie);
        movie = new Movie("Edge of Tomorrow", "Doug Liman", "Marvel Studios", "avi", 200, 32.00);
        movies.add(movie);
        movie = new Movie("Finding Nemo", "Lee Unkrich, Andrew Stanton", " Pixar Animation Studios", "mp4", 200, 23.00);
        movies.add(movie);
        movie = new Movie("Finding Fanny", "Homi Adajania", " Illuminati Films", "avi", 23, 12.00);
        movies.add(movie);
        
        return movies;
    }
    
    /**
     * This method  returns weather parameter string is integer or not.
     * 
     * @param  String
     * @return boolean
     */
    public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    }
    // only got here if we didn't return false
    return true;
}
}
