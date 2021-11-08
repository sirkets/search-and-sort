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
    int numElements = 10;
    
    /**
     * TODO: Replace this code with your own code.
     * 
     */
    public void draw()
    {
        setup();
        rect2(0, 0, 0.2, 0.2);
        rect2(0.2, 0.5, 0.2,0.3);
        //drawArray();
        
        //bubbleSort();
    }
    
    public void drawArray()
    {
        double width = 1.0/list.size();
        
        for(int i = 0; i < list.size(); i++)
        {
            double height = list.get(i) / list.size();
            double x = i * width;
            double y = 0;
            rect2(x, y, width, height);
        }
    
    }
    
    public double sortTime()
    {
        return 0.0;
    }
    
    
    
    private void setup()
    {
        for(int i = 0; i < numElements; i++)
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
                    
                }
            }
        }
        System.out.println(timer.millisElapsed());
    }
}
