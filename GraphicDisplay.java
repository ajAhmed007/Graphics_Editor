import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *  Graphical view for Shapes
 *  @author Ahmed Abdullahi
 */
public class GraphicDisplay extends JPanel implements View{
  
  private DrawingBoard model; // the DrawingBoard we are viewing
  /**
   * Construct a new GraphicDisplay viewer for the given model
   * @param model  The model we are watching
   */
  public GraphicDisplay(DrawingBoard model) {
    this.model = model;
  }
  /**
   * React when notified of a change by a model by repainting this view
   */
  public void notifyListener() {
    repaint();
  }
  /**
   * Repaint the simulation by requesting each item to repaint itself
   * @param g the graphics context where the painting should take place
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    //Rectangle bounds = getBounds();
    //g.clearRect(0, 0, 500, 500);
    
    ArrayList<Shape> things = model.getArrayListCopy();
    Iterator<Shape> it = things.iterator();
    while (it.hasNext()) {
      Shape thing = it.next();
      thing.drawShape(g);
    }
    
  }
  
}