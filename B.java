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

    // The target value that we're looking for
    private int target;

    // A timer for keeping track of how long your algorithm takes
    private SimpleTimer timer = new SimpleTimer();

    public B()
    {
        // Instantiate the main array
        nums = new int[N];

        // Setup the array 
        setup(nums);

        // Choose a target to look for
        target = nums[N-1];

        // shuffle the array
        shuffle(nums);
    }

    /**    
     * TODO: Refactor any relevant code from class A into Canvas superclass
     * so that you can use it in this class
     * 
     * TODO: Implement the code to show a linear search.
     */
    public void run()
    {
        // Set the timer to 0
        timer.mark();

        // Run the search algorithm to find the target value
        linSearch(nums, target);  

        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;

        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    /**
     * Set up the array so that every element has a value that is an integer
     * from 1 to the length of the array (1 - N).
     * @param arr An array of integers
     */
    private void setup(int[] arr)
    {
        // populate the array with values
        for(int i = 1; i <= N; i++)
        {
            arr[i-1] = i;
        }
    }

    /**
     * TODO: Implement this method
     * Swap elements at index positions i and j in the given array.  
     * @param arr An integer array
     * @param a The index of one of the elements to swap
     * @param b The index of the other element to swap with
     */
    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Shuffle an array using the Fisher-Yates method.
     * The Fisher-Yates method iterates the array once, swapping each
     * element with a random element chosen in the range between
     * the current position to the length of the array.
     * @param arr An array of integers
     */
    private void shuffle(int[] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            // swap the current element with a random one in the range
            // between the current index and the length of the array
            int r = Greenfoot.getRandomNumber(n - i) + i;
            swap(arr, i, r);
        }
    }


    private boolean linSearch(int[] nums, int target)
    {
        for(int i = 0; i < nums.length; i++)
        {
            // draw the array highlighting the rectangle at position i
            drawArray(nums, i);
            if(nums[i] == target)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Draw the given array, highlighting the element at position k
     * @param arr An integer array
     * @param k The current element we are querying
     */
    public void drawArray(int[] arr, int k)
    {
        // Exit this method if k is larger than the length of the array
        if(k > arr.length)
        {
            return;
        }

        double bin = 1.0/N;
        for(int i = 0; i < N; i++)
        {
            double height = (double)arr[i]/N;
            double x = i * bin;
            double y = 0;

            if(i == k){
                setColor(Color.YELLOW);
            }

            // Draw a rectangle on the canvas
            rect2(x, y, bin, height);

            setColor(Color.BLACK);
        }
        // Show the canvas
        update();
        Greenfoot.delay(1);
    } 
}