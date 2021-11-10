import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * Linear Search Canvas
 */
public class A extends Canvas
{
    SimpleTimer timer = new SimpleTimer();
    ArrayList<Integer> list = new ArrayList<Integer>();
    int numElements = 100;
    
    /**
     * TODO: Replace this code with your own code.
     * 
     */
    public void draw()
    {
        setup();

        //drawArray();
        
        bubbleSort();
    }
    
    public void drawArray()
    {
        //clearCanvas();
        double bin = 1.0/list.size();

        for(int i = 0; i < list.size(); i++)
        {
            double height = (double)list.get(i) / list.size();
            double x = i * bin;
            double y = 0;
            rect2(x, y, bin, height);
        }
    
    }
    
    public double sortTime()
    {
        return 0.0;
    }
    
    
    private void setup()
    {
        for(int i = 1; i <= numElements; i++)
        {
            list.add(i);
        }
        Collections.shuffle(list);
    }
    
    public void bubbleSort()
    {
        timer.mark();
        for(int i = 0; i < numElements; i++)
        {
            for(int j = 1; j < numElements; j++)
            {
                if(list.get(j) < list.get(j-1))
                {
                    Collections.swap(list, j, j-1);
                    drawArray();
                }
            }
        }
        System.out.println(timer.millisElapsed());
    }
}
