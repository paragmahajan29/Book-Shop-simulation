
/**
 * Movie class defines each movies information.
 * 
 * @author Parag Mahajan
 * @version 1.1 14 Sept 2014
 */
public class CD extends Media
{
    // instance variables
    private String performer;
    private String fileType;
    //constructer of cd
    public CD(String title, String performer, String fileType, int available, double price)
    { 
        // initialise instance variables
        super(title, available,  price);
        this.performer = performer;
        this.fileType = fileType;
    }
    
    /**
     * This method returns title of cd.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    public String getTitle()
    {
        return title;
    }
    
    /**
     * This method returns performer in cd.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    public String getPerformer()
    {
        return performer;
    }
    
    /**
     * This method returns price of cd.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    
    public double getPrice()
    {
        return price;
    }
    
    /**
     * This method returns number of vailable cd.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    public int getAvailable()
    {
        return available;
    }
    
    /**
     * This method returns filetype of cd.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    public String getFileType()
    {
        return fileType;
    }
    
    /**
     * This method returns number of sold book.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    
    public int getSold()
    {
        return sold;
    }

    /**
     * This method sales cds and saves data and returns true if it is successful
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
            sold = true;
            return sold;
        }else{
            return sold;
        }
    }
    
    /**
     * This method updates rating of cds 
     * 
     * @param  nothing
     * @return     nothing
     */
    public void updateRating(int newRating)
    {
        r.updateRating(newRating);
        
    }
    
    /**
     * This method returns information about cd. 
     * 
     * @param  nothing
     * @return     nothing
     */
    public String toString()
    {
        return "'"+ title+"' Performer: " + performer + ", Price: "+ price + ", Available: " +available+ ", Sold: "+ sold + " Rating: "+r.getAvarageRating();
    }
}
