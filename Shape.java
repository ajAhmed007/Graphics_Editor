import java.awt.*;
/**
 * This class has all the interface methods with no implementations.
 * @author Ahmed Abdullahi
 */
public interface Shape {
    /**
     * interface method for the isOn method. 
     * @param x coordinate
     * @param y coordinate 
     */
    public boolean isOn(int x, int y);

    /**
     * interface method checting if a method is selected.
     */
    public boolean isSelected();

    /**
     * method for the selected shape.
     * @param b the selected shape.
     */
    public void setSelected(boolean b);

    /**
     * getting the height of the shape.
     */
    public int getHeight();

    /**
     * getting the upper left x.
     */
    public int getUpLeftx();

    /**
     * getting the upper left y
     */
    public int getUpLefty();

    /**
     * getting the color of the shape.
     */
    public Color getShapeColor();

    /**
     * setting the color.
     * @param newShapeColor the shape color.
     */
    public void setShapeColor(Color newShapeColor);

    /**
     * shifting up and left.
     * @param deltaX the x value.
     * @param deltaY the y value.
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY);

    /**
     * moving shape supper left.
     * @param newX the x value.
     * @param newY the y value.
     */
    public void moveUpperLeftTo(int newX, int newY);

    /**
     * A string representation of the states of the objects.
     */
    String toString();

    public void drawShape(Graphics g);
}