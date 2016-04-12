
/**
 * Movie class defines each movies information.
 * 
 * @author Parag Mahajan
 * @version 1.1 14 Sept 2014
 */
 
public class Book extends Media
{
    // instance variables
    private String author;
    
    
    //constructer of book
    public Book(String title, String author, int available, double price)
    { 
        // initialise instance variables
        super(title, available,  price);
        this.author = author;
        
    }
    
     /**
     * This method sales books and saves data and returns true if it is successful
     * otherwise returns false
     * 
     * @param  int
     * @return     boolean
     */
    public boolean sellCopies(int noOfCopies)
    {
        boolean sold = false;
        if(noOfCopies <= available)
        {
            available -= noOfCopies;
            this.sold += noOfCopies;
            double totalAmount = 0.0;
            totalAmount = noOfCopies*price;
            sold = true;
            return sold;
        }else{
            return sold;
        }
    }
    
    /**
     * This method returns title of book.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    public String getTitle()
    {
        return title;
    }
    
    /**
     * This method returns author of book.
     * 
     * @param  nothing
     * @return     nothing
     */
 
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * This method returns price of book.
     * 
     * @param  nothing
     * @return     nothing
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * This method returns number of available of book.
     * 
     * @param  nothing
     * @return     nothing
     */
    public int getAvailable()
    {
        return available;
    }
    
    /**
     * This method returns number of sold  book.
     * 
     * @param  nothing
     * @return     nothing
     */
    public int getSold()
    {
        return sold;
    }
    
    /**
     * This method updates rating of books 
     * 
     * @param  nothing
     * @return     nothing
     */
    public void updateRating(int newRating)
    {
        r.updateRating(newRating);
    }
    
    /**
     * This method returns information about book. 
     * 
     * @param  nothing
     * @return     nothing
     */
    public String toString()
    {
        return "'"+ title+"' Author: " + author + ", Price: "+ price + ", Available: " +available+ ", Sold: "+ sold + " Rating: "+r.getAvarageRating();
    }
}
