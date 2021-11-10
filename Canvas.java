import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class contains methods to make simple drawings.
 * Extend this class to make your own canvas for drawing.
 * Override the 'draw()' method in your subclass.
 * Enter your drawing code in the 'draw()' method of the subclass
 */
public class Canvas extends Actor
{

    private int delay = 0; // The drawing delay
    GreenfootImage blankImage = new GreenfootImage(1,1);
    GreenfootImage image = new GreenfootImage(1,1);
    private int scale; // The side-length of the world.
    
    /**
     * Override and implement your drawing in this method.
     * 
     * The canvas has coordinates (0, 0) in the bottom left corner
     * and (1.0, 1.0) in the top right corner
     * 
     *      |-----|(1.0,1.0)
     *      |     |
     *      |     |
     * (0,0)|-----|
     * 
     * 
     */
    public void draw()
    {
    }
 
    public void addedToWorld(World world)
    {
        // set the scale to the width of the world
        // ensure width = height in the world
        scale = world.getWidth();
        
        blankImage = new GreenfootImage(scale, scale);
        // instantiate an image to draw on
        image = new GreenfootImage(scale, scale);

        clearCanvas();

        // draw the image
        draw();
    }
    
    /**
     * Clear the canvas
     */
    public void clearCanvas()
    {
        this.image = blankImage;
        // Draw a line at the bottom of the canvas to separate from buttons
        image.drawLine(0, scale-1, scale, scale-1);
    }
    
    /**
     * Draw a line between coordinates (x1, y1) and (x2, y2)
     */
    public void line(double x1, double y1, double x2, double y2)
    {
        int nx1 = (int) (x1 * scale);
        int nx2 = (int) (x2 * scale);
        int ny1 = (int) ((1 - y1) * scale);
        int ny2 = (int) ((1 - y2) * scale);
        image.drawLine(nx1, ny1, nx2, ny2);
        this.setImage(image);
        Greenfoot.delay(delay);
    }

    /**
     * Draw a circle with centre (x, y) and radius
     */
    public void circle(double x, double y, double radius)
    {
        oval(x, y, radius, radius);
    }

    /**
     * Draw an oval with centre (x, y) and with xRadius and yRadius
     */
    public void oval(double x, double y, double xRadius, double yRadius)
    {
        int nx = (int) ((x - xRadius) * scale);
        int ny = (int) ((1 - y) * scale - yRadius * scale);
        int width = (int) (xRadius * 2 * scale);
        int height = (int) (yRadius * 2 * scale);
        image.drawOval(nx, ny, width, height);
        this.setImage(image);
        Greenfoot.delay(delay);
    }

    /**
     * Draw a rectangle centred on (x, y) with halfWidth and halfHeight
     */
    public void rect(double x, double y, double halfWidth, double halfHeight)
    {
        int nx = (int) ((x - halfWidth) * scale);
        int ny = (int) ((1 - y) * scale - halfHeight * scale);
        int width = (int) (halfWidth * 2 * scale);
        int height = (int) (halfHeight * 2 * scale);
        image.drawRect(nx, ny, width, height);
        this.setImage(image);
        Greenfoot.delay(delay);
    }
    
    /**
     * Draw a rectangle with bottom left coordinate (x, y) with width and height
     */
    public void rect2(double x, double y, double width, double height)
    {
        int nx = (int) (x * scale);
        int ny = (int) ((1-y) * scale - height * scale);
        int w = (int) (width * scale);
        int h = (int) (height * scale);
        image.drawRect(nx, ny, w, h);
        this.setImage(image);
        Greenfoot.delay(delay);
    }


    /**
     * Set the drawing color
     */
    public void setColor(Color color)
    {
        image.setColor(color);
    }

}
