
/**
 * Movie class defines each movies information.
 * 
 * @author Parag Mahajan
 * @version 1.1 14 Sept 2014
 */
public class Movie extends Media
{
    // instance variables
    private String director;
    private String producer;
    private String fileType;
  
    //constructer of movie
    public Movie(String title, String director, String producer, String fileType, int available, double price)
    { 
        // initialise instance variables
        super(title, available,  price);
        this.director = director;
        this.producer = producer;
        this.fileType = fileType;
       
    }
    
    /**
     * This method returns title of movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    
    public String getTitle()
    {
        return title;
    }
    
    
    /**
     * This method returns director of movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    public String getDirector()
    {
        return director;
    }
    
    /**
     * This method returns price of movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * This method returns number of available movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    public int getAvailable()
    {
        return available;
    }
    
    /**
     * This method returns filetype of movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    public String getFileType()
    {
        return fileType;
    }
    
    /**
     * This method returns producer of movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    public String getProducer()
    {
        return producer;
    }
    
    /**
     * This method returns number of sold copies movie.
     * 
     * @param  nothing
     * @return     nothing
     */
    public int getSold()
    {
        return sold;
    }
    

     /**
     * This method sales movies and saves data and returns true if it is successful
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
     * This method updates rating of movies 
     * 
     * @param  nothing
     * @return     nothing
     */
    public void updateRating(int newRating)
    {
        r.updateRating(newRating);
        
    }
    
    /**
     * This method returns information about movie. 
     * 
     * @param  nothing
     * @return     nothing
     */
    public String toString()
    {
        return "'"+ title+"' Director: " + director+ ", Producer: " + producer + ", Price: "+ price + ", Available: " +available+ ", Sold: "+ sold + " Rating: "+r.getAvarageRating();
    }
}
