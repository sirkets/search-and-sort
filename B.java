import greenfoot.*;

/**
 * Linear Search
 * 
 */
public class B extends Canvas
{    
    /**
     * TODO: Refactor the array and any relevant helper methods
     */
    // The size of your array
    private int N = 300;

    // The main array to visualize
    private int[] nums;

    // The target value that the search algorithm will search for
    private int target;

    // A timer for keeping track of how long your algorithm takes
    private SimpleTimer timer = new SimpleTimer();

    /**
     * TODO: Set up this canvas by
     * 1. Instantiating the main array
     * 2. Choosing a target number to search for
     * 3. Shuffling the array
     */
    public B()
    {
    }

    /**    
     * TODO: Refactor any relevant code from class A into Canvas superclass
     * so that you can use it in this class
     * 
     * TODO: Implement the code to show a linear search.
     */
    public void run()
    {
    }


    /**
     * TODO: complete the code for this linear search algorithm
     * to draw the array, highlighting the rectangle at position i
     */
    private boolean linSearch(int[] nums, int target)
    {
        for(int i = 0; i < nums.length; i++)
        {
            // TODO: draw the array highlighting the rectangle at position i
            
            if(nums[i] == target)
            {
                return true;
            }
        }
        return false;
    }

 
}