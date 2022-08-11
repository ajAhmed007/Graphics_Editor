import java.awt.*;
import java.util.*;
/**
 * Holds shape objects in list and moves order around
 * @author Ahmed Abdullahi
 */
public class DrawingBoard {
    private ArrayList<Shape> list;
    private Shape selectedShape;
    private ArrayList<View> listeners;
    /**
     * Contstructs list
     */
    public DrawingBoard() {
        listeners = new ArrayList<View>();
        list = new ArrayList<Shape>();

    }
    /**
     * Adds shape to list, makes shape selected shape
     * @param newShape a Shape object
     */
    public void addNewShape(Shape newShape){//**
        list.add(newShape);
        setSelectedShape(newShape);

        addListener(new GraphicDisplay(this));
    }

    /**
     * Seeing if point is on shape and makes it
     * selected shape
     * @param x representing x point
     * @param y representing y point
     */
    public void passIn(int x, int y){
        selectedShape = null;
        for(int i = list.size()-1; i>0; i--){
            if(list.get(i).isOn(x,y) == true){
                setSelectedShape(list.get(i));
            }
        }
    }

    /**
     * Selects shape
     * @return selectedShape
     */
    public Shape getSelectedShape(){
        return selectedShape;
    }

    /**
     * 
     */
    private void setSelectedShape(Shape newSelectedShape){//**
        if(selectedShape != null){
            selectedShape.setSelected(false);
        }
        selectedShape = newSelectedShape;
        selectedShape.setSelected(true);

        addView(new GraphicDisplay(this));
    }

    /**
     * Removes selected shape
     */
    public void removeSelectedShape(){//**
        if(selectedShape != null){
            selectedShape.setSelected(false);
            if(list.size() > 0 ){
                removeShape(list.size()-1);
            }
            else{
                selectedShape = null;
            }
        }
        else{
            throw new IllegalStateException();
        }

        addView(new GraphicDisplay(this));
    }

    /**
     * 
     */
    private void removeShape(int indexOfShapeToRemove){
        list.remove(indexOfShapeToRemove);
        if(list.size() > 0 ){
            setSelectedShape(list.get(list.size()-1));
        }

        addView(new GraphicDisplay(this));
    }

    /**
     * Changes shape color of selected shape
     * @param newSelectedShapeColor 
     */
    public void setSelectedShapeColor(Color newSelectedShapeColor ){
        if(selectedShape != null){
            selectedShape.setShapeColor(newSelectedShapeColor);
        }
        else{
            throw new IllegalStateException();
        }

        addView(new GraphicDisplay(this));
    }

    /**
     * Add the given View to the list of viewers to be
     * notified.
     * @param v the new viewer
     */
    public void addView(View v) {
        listeners.add(v);
        notifyAllListeners();
    }

    /**
     * Shifts selected shaped
     * @param changeInX shifting by how many x units
     * @param changeInY shifting by how many y units
     */
    public void shiftSelectedShape(int changeInX, int changeInY){//**
        if(selectedShape != null){
            selectedShape.shiftUpperLeftBy(changeInX,changeInY);
        }
        else{
            throw new IllegalStateException();
        }

        addView(new GraphicDisplay(this));
    }

    /**
     * Makes copy of array
     * return copy
     */
    public ArrayList getArrayListCopy(){
        ArrayList<Shape> copy =  new ArrayList<Shape>();
        copy.addAll(list);

        return copy;
    }
    // operations to support listeners 
    /**
     * adding the listener
     * @param c the view object.
     */
    public void addListener( View c ) {
        listeners.add( c );
        c.notifyListener();
        // update new listener 
    }
    /**
     * notifying all the listeners.
     */
    private void notifyAllListeners() {
        Iterator<View> it = listeners.iterator();
        while ( it.hasNext() ) {
            View c = it.next();
            c.notifyListener();
        }
    }
}