import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * Example Canvas for practicing how to draw/visualize an array on the canvas
 */
public class A extends Canvas
{
    // A timer for keeping track of how long your algorithm takes
    private SimpleTimer timer = new SimpleTimer();
    
    // The size of your array
    private int N = 200;
    
    // Instantiate the array
    private int[] nums = new int[N];

    /**
     * TODO: Replace this code with your own code to draw your array.
     */
    public void run()
    {
        setup(nums);
        bubbleSort(nums);
    }

    /**
     * TODO: Implement helper methods below
     */

    /**
     * Create the array
     */
    private void setup(int[] nums)
    {
        // populate the array with values
        for(int i = 1; i <= N; i++)
        {
            nums[i-1] = i;
        }
        
        // shuffle the array
        shuffle(nums);
    }

    /**
     * Shuffling an array using the Fisher-Yates method
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
    
    /**
     * Swap elements in an array
     * @param arr An integer array
     * @param a The index of one of the elements to swap
     * @param b The index of the other element to swap with
     */
    private void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    /**
     * Draw the array
     */
    public void drawArray()
    {
        double bin = 1.0/N;
        for(int i = 0; i < N; i++)
        {
            double height = (double)nums[i]/N;
            double x = i * bin;
            double y = 0;
            // Draw a rectangle on the canvas
            rect2(x, y, bin, height);
        }
        // Show the canvas
        update();
    }
    

    public double sortTime()
    {
        return 0.0;
    }

    /**
     * A simple sorting algorithm
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
                    drawArray();
                }
            }
        }
        int elapsed = timer.millisElapsed();
    }
}
