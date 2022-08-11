import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * This class represents a tee shape that can be used on the drawing board
 * @author Ahmed Abdullahi
 */
public class Tee extends AbstractShape {
    /**
     * Initializes instance variables
     * @param upLeftx upperleft x coordinate of shape
     * @param upLefty upperleft y coordinate of shape
     * @param height of shape
     */
    public Tee(int upLeftx,int upLefty,int height){
        super(upLeftx, upLefty, height);
        if( height % 10 != 0){
            throw new IllegalArgumentException("Sorry, height is not multiple of 10");
        }
    }

    /**
     * Checks if point is on shape
     * @param x is the x coordinate of the xy point
     * @param y is the y coordinate of the xy point
     */
    public boolean isOn(int x, int y) {
        int newHeight = super.getHeight();
        int upperLeftx = super.getUpLeftx();
        int upperLefty = super.getUpLefty();
        int thick = 0;
        thick = newHeight / 5;
        if(x >= upperLeftx && x <= (upperLeftx + newHeight)){
            if(y >= upperLefty && y <= (y + thick)){
                return true;
            }
        }
        if(x >= (upperLeftx+(2*thick)) && x <= (upperLeftx+(3*thick))){
            if( y >= upperLefty && y <= (upperLefty + newHeight)){
                return true;
            }
        }
        return false;
    }

    /**
     * Draws Tee
     * @param g 
     */
    public void drawShape(Graphics g){
        int height = super.getHeight();
        int upLftx = super.getUpLeftx();
        int upLfty = super.getUpLefty();
        int thick = 0;
        thick = (super.getHeight()) / 5;
        int[] x = {upLftx, upLftx, upLftx + thick*2, upLftx + 
                thick*2, upLftx + thick*3,upLftx + thick*3, upLftx + 
                height, upLftx + height};
        int[] y = {upLfty, upLfty + thick, upLfty + thick, upLfty +
                height, upLfty + height, upLfty + thick, upLfty + thick, upLfty};
        g.setColor(super.getShapeColor());
        g.fillPolygon(x,  y,  8);

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