import javax.swing.*;
import java.awt.*;
/**
 * Create window and makes Shapes
 * @author Ahmed Abdullahi  
 */
public class GraphicsEditorApp extends JPanel{

    public static void main( String[] args ) { 
        DrawingBoard model = new DrawingBoard();


        // Create a graphics view,  put it in a window, and show it
        JFrame frame = new JFrame("Draw Shapes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Controller n=new Controller(model);
        //View nd= new GraphicDisplay(model);
        //GraphicDisplay view = new GraphicDisplay(model);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.getContentPane().add(n);
        frame.pack();
        frame.setVisible(true);

        //model.addView(view);

    }
}