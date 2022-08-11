/**
 * A View can be added to a DrawingBoard, which will periodically notify the View so it can
 * update its display after changes occur in the model.
 * @author Ahmed Abdullahi
 */
public interface View{
  public void notifyListener();
  
}
