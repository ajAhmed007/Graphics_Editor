import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * The controller's job is to interact with the user. 
 * @author  Ahmed Abdullahi
 */
public class Controller extends JPanel {

    // listener object for buttons
    private SimMouseListener  mouseListener;
    private buttonListener buttonClick;
    // instance variables
    private GraphicDisplay viewPane;         // the panel with the bouncing balls
    private DrawingBoard board;                    // the simulation board
    //private Controller bu
    // listener object for mouse clicks
    private int n;
    /**
     * Construct a viewer/controller for the given board
     * @param w the model object this BallSimControl object is controlling 
     * and viewing
     */
    public Controller( DrawingBoard b ) {

        // capture model
        board = b;

        // default layout manager for JPanel is flow layout - we want border layout
        setLayout( new BorderLayout( ) );

        // create pane with ball display and place it in the center
        viewPane = new GraphicDisplay( board ); 

        add( viewPane, BorderLayout.CENTER );

        // register the view with the model
        board.addView( viewPane );
        // set up listener for mouse clicks on the view
        mouseListener = new SimMouseListener( board );

        viewPane.addMouseListener(mouseListener);

        // create panel with start/stop buttons and add it at the bottom
        JButton Circle = new JButton( "Circle" );
        JButton Delta = new JButton( "Delta" );
        JButton T = new JButton( "T" );
        JPanel buttons = new JPanel( );
        buttons.add( Circle );
        buttons.add( Delta );
        buttons.add( T );
        Circle.setBackground( Color.yellow );
        Delta.setBackground( Color.green );
        T.setBackground( Color.red );
        buttons.setBackground( Color.lightGray );
        this.add( buttons, BorderLayout.SOUTH );

        // set up listener for the buttons
        buttonClick = new buttonListener( board );        
        Circle.addActionListener( buttonClick );
        Delta.addActionListener( buttonClick );
        T.addActionListener( buttonClick );
    }

    /**
     * Handle button clicks for the  window.
     * @author Ahmed Abdullahi 
     * @version 10/22/18
     */
    class buttonListener implements ActionListener {
        // instance variables
        private DrawingBoard board; // the DrawingBoard we are controlling

        /**
         * Constructor for objects of class DrawingBoard
         * @param board the model object of the simulation
         */
        public buttonListener( DrawingBoard b ) {
            this.board = b;
        }

        /**
         * Process button clicks by turning the simulation on and off
         * @param e the event created by the button click
         */

        public void actionPerformed( ActionEvent e ) {
            if ( e.getActionCommand( ).equals( "Circle" ) ) {
                n=1;
            } else if ( e.getActionCommand( ).equals( "Delta" ) ) {
                n=2;
            } else if ( e.getActionCommand( ).equals( "T" ) ) {
                n=3;
            }
        }

    }
    /**
     * Handle mouse clicks for the window.
     * @author Ahmed Abdullahi 
     * @version 10/22/18
     */
    class SimMouseListener implements MouseListener, MouseMotionListener {
        // instance variables
        private DrawingBoard board; // the DrawingBoard we are controlling

        /**
         * Constructor for objects of class SimMouseListener
         * @param board the model object containing the state of the system
         */
        public SimMouseListener( DrawingBoard b ) {
            super( );
            this.board = b;
        }

        /**
         * Process mouse click by adding a new ball to the simulation at the location
         * of the click with a random color, size, and velocity
         * @param e the mouse click event
         */
        public void mouseClicked( MouseEvent e ) {

        }

        /**
         * Checking for mouse events, presses, exiting, and entered actions. 
         * @param e - the mouse events. 
         */

        public void mouseEntered ( MouseEvent e ) { }

        public void mouseExited  ( MouseEvent e ) { }

        public void mousePressed ( MouseEvent e ) { 
            if(n==1){

                board.addNewShape(new Circle(e.getX(),e.getY(),100));
                n=0;
            }
            else if(n==2){

                board.addNewShape(new Delta(e.getX(),e.getY(),100));
                n=0;
            }
            else if(n==3){

                board.addNewShape(new Tee(e.getX(),e.getY(),100));
                n=0;
            }
        }

        public void mouseReleased( MouseEvent e ) { }
        // mouseMotion Listener implementation
        public void mouseDragged  ( MouseEvent e ) { }

        public void mouseMoved  ( MouseEvent e ) { }
    }
}