import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
// class just to organize stuff, only purpose of this class is to create a window for us
public class Window extends Canvas
{   
    public Window(int width, int height, String title, Game game)
    {
        JFrame frame = new JFrame(title);
        //The Dimension class encapsulates the width and height of a component in a single object
        frame.setPreferredSize(new Dimension (width,height)); // setPreferredSize (Dimension object);
        frame.setMaximumSize(new Dimension (width,height));
        frame.setMinimumSize(new Dimension (width,height));        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }    
}