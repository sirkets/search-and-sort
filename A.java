import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Example Canvas for practicing how to draw/visualize an array
 */
public class A extends Canvas
{
    // The size of your array
    private int N = 200;

    // The main array to visualize
    private int[] nums;

    // A timer for keeping track of how long your algorithm takes
    private SimpleTimer timer = new SimpleTimer();

    /**
     * When this class is instantiated, set up and shuffle the main array
     */
    public A()
    {
        // Instantiate the main array
        nums = new int[N];

        // Setup the array 
        setup(nums);

        // shuffle the array
        shuffle(nums);
    }

    /**
     * TODO: Replace this code with your own code to draw your array.
     */
    public void run()
    {
        // Set the timer to 0
        timer.mark();
        
        // Run the sort algorithm on an array
        bubbleSort(nums);  
        
        // How much time has elapsed?
        double time = (double)timer.millisElapsed()/1000;
        
        // Display that time on the canvas
        MyWorld world = (MyWorld) getWorld();
        String result = "Time: " + Double.toString(time) + " seconds";
        world.display(result);
    }

    /**
     * TODO: Implement any other methods that you need below.  These are
     * sometimes called 'helper' methods
     */

    /**
     * Set up the array so that every element has a value that is an integer
     * from 1 to the length of the array (1 - N).
     * @param arr An array of integers
     */
    private void setup(int[] arr)
    {
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
    }

    /**
     * Draw the given array
     * @param arr An array of integers
     */
    public void drawArray(int[] arr)
    {
        double bin = 1.0/N;
        for(int i = 0; i < N; i++)
        {
            double height = (double)arr[i]/N;
            double x = i * bin;
            double y = 0;
            // Draw a rectangle on the canvas
            rect2(x, y, bin, height);
        }
        // Show the canvas
        update();
    }

    /**
     * Draw the given array, highlighting the element at position k
     * @param arr An integer array
     * @param k The position in the array to draw in a different color. k < arr.length
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

            // Change the color for the one index
            if(i == k)
            {
                setColor(Color.RED);
            }

            // Draw a rectangle on the canvas
            rect2(x, y, bin, height);

            if(i == k)
            {
                setColor(Color.BLACK);
            }
        }
        // Show the canvas
        update();
    }

    /**
     * A simple sorting algorithm
     * @param arr An integer array
     */
    public void bubbleSort(int[] arr)
    {
        timer.mark();
        int N = arr.length;
        for(int i = 0; i < N; i++)
        {
            for(int j = 1; j < N; j++)
            {
                if(arr[j] < arr[j-1])
                {
                    swap(arr, j, j-1);
                    drawArray(arr, j);
                }
            }
        }
    }
}
