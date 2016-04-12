
/**
 * Write a description of class Rating here.
 * 
 * @author Parag Mahajan
 * @version 1.1 14 Sept  2014
 */
public class Rating
{
    // instance variables - replace the example below with your own
    private int [] scores;
    private int numberOfRating;

    public Rating()
    {
        // initialise instance variables
        scores = new int[100];
        numberOfRating = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void updateRating(int newRating)
    {
        scores[numberOfRating%100] = newRating;
        numberOfRating++;
    }
    
    public double getAvarageRating()
    {
        double avg = 0.0; 
        int sum = 0;
        int count = 1;

        if(scores.length > 0)
        {
           // for(int i=0; i<scores.length; i++)
                //sum += scores[i];
                
            for(int a:scores)   
            {
                if(a>0)
                {
                 sum += a;
                 if(a!=1)
                 count++;
                }
            }
            if(numberOfRating == 0)
            	avg = sum/1;
            else 
            	avg = sum/numberOfRating;
            
            return avg;
        }else{
            return avg;
        }
    }
}
