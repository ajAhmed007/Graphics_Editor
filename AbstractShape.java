import java.util.*;
import java.awt.*;
import javax.swing.*;
import static java.lang.Math.pow;

/**
 * Abstract class implenting Shape
 * @author Ahmed Abdullahi
 */
public abstract class AbstractShape implements Shape{
    private int upLeftx; 
    private int upLefty;
    private int height;
    private boolean isSelected;
    private Color shapeColor;
    /**
     * Initializes instance variables
     * @param upLeftx upperleft x coordinate of shape
     * @param upLefty upperleft y coordinate of shape
     * @param height of shape
     */
    public AbstractShape(int upLeftx,int upLefty,int height){
        this.upLeftx = upLeftx;
        this.upLefty = upLefty;
        this.height = height;
        if(height < 0){throw new IllegalArgumentException("the height must NOT be negative");
        }
    }

    /**
     * Checks if point is on shape, subclasses have their own isOn 
     * methods so no need in this class
     * @param x is the x coordinate of the xy point
     * @param y is the y coordinate of the xy point
     */
    public abstract boolean isOn(int x, int y);

    /**
     * Identifies if shape is selected or not
     * @return isSelected is true if shape is selected, false if not
     */  
    public boolean isSelected(){
        return isSelected;

    }

    /**
     * Selects item/ Deselects
     * @param b 
     */
    public void setSelected(boolean b){
        isSelected = b;
    }

    public abstract void drawShape(Graphics g);

    /**
     * Access height to use on other classes
     * @return height of shape
     */
    public int getHeight(){
        return height;
    }

    /**
     * Access upper left corner x value to use on other classes
     * @return upLeftx 
     */
    public int getUpLeftx(){
        return upLeftx;
    }

    /**
     * Access upper left corner y value to use on other classes
     * @return upLefty
     */
    public int getUpLefty(){
        return upLefty;
    }

    /**
     * Access shapeColor to use on other classes
     * @return shapeColor 
     */
    public Color getShapeColor(){
        return shapeColor;
    }

    /**
     * Sets color to new color
     * @param newShapeColor
     */
    public void setShapeColor(Color newShapeColor){
        this.shapeColor = newShapeColor;
    }

    /**
     * Shifts shape by how many x and y units
     * @param deltaX moves x coordinate by however many units
     * @param deltaY moves y coordinate by however many units
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY){
        upLeftx += deltaX;
        upLefty += deltaY;
    }

    /**
     * Moves shape to new x and y units
     * @param newX moves x coordinate to new x point
     * @param newY moves y coordinate to new y point
     */
    public void moveUpperLeftTo(int newX, int newY){
        upLeftx = newX;
        upLefty = newY;
    }

    /**
     * Making a string representation of the object
     * @return result string 
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NEW_LINE);
        result.append(" upLeftx: " + upLeftx + NEW_LINE);
        result.append(" upLefty: " + upLefty + NEW_LINE);
        result.append(" height: " + height + NEW_LINE );
        result.append(" isSelected: " + isSelected + NEW_LINE);
        result.append(" shapeColor : " + shapeColor + NEW_LINE);
        result.append("}");

        return result.toString();
    }

}  

  