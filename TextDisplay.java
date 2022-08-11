import java.util.*;
/**
 * Displays number of shapes on DrawingBoard and information on selected shape
 * @author Ahmed Abdullahi
 */
public class TextDisplay implements View{
  private DrawingBoard model;
  /**
   * Construct a new Text Display
   */ 
  public TextDisplay(DrawingBoard model){
    this.model = model;  
  }
  /**
   * Overriding notifyListener
   */ 
  public void notifyListener(){
    ArrayList<Shape> list = model.getArrayListCopy(); // copy of list
    Shape d = model.getSelectedShape();
    if(d == null){ // checking if selecred
      System.out.println("No Selected shape.");
    }
    else{
      System.out.println("Numbers of Shapes: " + list.size()); //print to  cosole
      System.out.println(d.toString()); // referring to method in Abstract class
    }
  }
}