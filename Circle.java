import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * This class represents a Circle shape that can be used on the drawing board
 * @author Ahmed Abdullahi
 */
public class Circle extends AbstractShape {

    /**
     * Initializes instance variables
     * @param upLeftx upperleft x coordinate of shape
     * @param upLefty upperleft y coordinate of shape
     * @param height of shape
     */
    public Circle(int upLeftx,int upLefty,int height){
        super(upLeftx-(height/2), upLefty-(height/2),height);   
    }

    /**
     * Checks if point is on shape
     * @param x is the x coordinate of the xy point
     * @param y is the y coordinate of the xy point
     */
    public boolean isOn(int x, int y) {
        int distx = 0;
        int disty = 0;
        double totaldist = 0.0;
        distx = Math.abs((super.getUpLeftx() + super.getHeight()/2) - x);
        disty = Math.abs((super.getUpLefty() + super.getHeight()/2) - y);
        totaldist = Math.sqrt(((distx*distx) + (disty*disty)));
        if(totaldist <= (super.getHeight())/2 ){
            return true;
        }
        return false;

    }

    /**
     * Draws Circle
     * @param g 
     */
    public void drawShape(Graphics g){
        if (this.isSelected()){
        g.setColor(Color.green);
        g.drawOval(super.getUpLeftx(),super.getUpLefty(),
            super.getHeight(),super.getHeight());
        }
         g.setColor(super.getShapeColor());
        g.fillOval(super.getUpLeftx(),super.getUpLefty(),
            super.getHeight(),super.getHeight());
    }

    /**
     * Shifts shape by how many x and y units
     * @param deltaX moves x coordinate by however many units
     * @param deltaY moves y coordinate by however many units
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY){
        super.shiftUpperLeftBy(deltaX, deltaY);

    }

    /**
     * Moves shape to new x and y units
     * @param newX moves x coordinate to new x point
     * @param newY moves y coordinate to new y point
     */
    public void moveUpperLeftTo(int newX, int newY){
        super.moveUpperLeftTo(newX, newY);
    }

    /**
     * Making a string representation of the object
     * @return result string 
     */
    public String toString(){
        return super.toString();
    }

}