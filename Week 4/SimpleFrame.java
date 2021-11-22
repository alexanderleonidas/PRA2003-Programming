import java.awt.*;
import javax.swing.*;

/**
 * PRA2003: Simple Swing frame for testing.
 * @author cambolbro (based on code from previous years).
 */
public class SimpleFrame 
{
    public static void main(final String[] args) 
    {
        final JFrame frame = new JFrame("A Frame");
        
        frame.getContentPane().setBackground(new Color(230, 230, 200));  // r, g, b (0..255)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exit app with close frame
        frame.setLocation(100, 150);  // (x,y) coordinate for top left corner
        frame.setSize(300, 120);      // size in pixels (width and height)
        frame.setVisible(true);
    }
}
