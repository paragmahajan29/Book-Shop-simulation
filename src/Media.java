
/**
 * Write a description of class Media here.
 * 
 * @author Parag Mahajan
 * @version (a version number or a date)
 */
public abstract class Media
{
    // instance variables - replace the example below with your own
    protected String title;
    protected double price;
    protected int available;
    protected int sold;
    protected int selected;
    Rating r;

    /**
     * Constructor for objects of class Media
     */
    public Media(String title, int available, double price)
    {
        // initialise instance variables
       this.title = title;
       this.available = available;
       sold = 0;
       this.price = price;
       r = new Rating();
    }
    
    public abstract boolean sellCopies(int noOfCopies);
    public abstract String getTitle();
    public abstract double getPrice();
    public abstract int getSold();
    public abstract void updateRating(int newRating);

}
