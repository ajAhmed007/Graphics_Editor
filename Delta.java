import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * This class represents a delta shape that can be used on the drawing board
 * @author Ahmed Abdullahi
 */
public class Delta extends AbstractShape {

    /**
     * Initializes instance variables
     * @param upLeftx upperleft x coordinate of shape
     * @param upLefty upperleft y coordinate of shape
     * @param height of shape
     */
    public Delta(int apexx,int apexy,int height){
        super(apexx - (height/2), apexy, height);

        if(height % 2 != 0 && height <= 0){
            throw  new IllegalArgumentException("Sorry, height must be even");
        }

    }

    /**
     * Checks if point is on shape
     * @param x is the x coordinate of the xy point
     * @param y is the y coordinate of the xy point
     */
    public boolean isOn(int x, int y) {
        int apexx = super.getUpLeftx() + (super.getHeight()/2);
        int apexy = super.getUpLefty();
        System.out.println( apexx + " " + apexy + " " + super.getUpLeftx() );
        if(y >= apexy && y <= apexy + super.getHeight() 
        && x >= apexx - super.getHeight()/2 && x <= apexx + super.getHeight()/2){
            if(y - apexy >= Math.abs(2*(apexx - x))){
                return true;
            }
        }
        return false;
    }

    /**
     * Draws Delta
     * @param g 
     */ 
    public void drawShape(Graphics g){
        int height = super.getHeight();
        int upLftx = super.getUpLeftx();
        int upLfty = super.getUpLefty();
        int[] x = {upLftx, upLftx + height/2, upLftx + height};
        int[] y = {upLfty + height, upLfty, upLfty + height};
        g.setColor(super.getShapeColor());
        g.fillPolygon(x,y,3);
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