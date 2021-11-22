import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * PRA2003: Simple action and key listener demo.
 * @author cambolbro (based on code from previous years). 
 */
public class Listener 
{
    final JFrame         frame = new JFrame("A Frame");
    final JButton       button = new JButton("Add Text");
    final JTextField textField = new JTextField();

    //-------------------------------------------------------------------------

    /**
     * Duplicates the field's text when button is clicked.
      */
    private class MyButtonListener implements ActionListener 
    {
        @Override
   	    public void actionPerformed(ActionEvent event) 
        {
    	    final String text = textField.getText();
           	textField.setText(text + text);

           	//This line is for testing only; it can be removed.
            System.out.println("Button event happened!");
        }
    }

    //-------------------------------------------------------------------------
    
    /**
     * Updates the button's text when the text field is non-empty.
     */
    private class MyTextFieldListener implements KeyListener 
    {
    	@Override
   	    public void keyPressed(KeyEvent event) 
   	    {
   	        final String text = textField.getText();
           	if (text.isEmpty())
           	    button.setText("Add Text");
           	else
           	    button.setText("Press Me!");
   	    }
   	    
    	@Override
   	    public void keyReleased(KeyEvent event) 
    	{
    		// Do nothing.
    	}
   	    
    	@Override
   	    public void keyTyped(KeyEvent event)    
    	{
    		// Do nothing.
    	}
    }

    //-------------------------------------------------------------------------

    /**
     * Test the demo.
     */
    public void test() 
    {
        textField.setColumns(20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(textField);
        frame.pack();
        
        frame.setVisible(true);
        
        // Add custom ActionListener to the button
        button.addActionListener(new MyButtonListener());

        // Add custom KeyListener to the test field
        textField.addKeyListener(new MyTextFieldListener());
    }

    //-------------------------------------------------------------------------
    
    /**
     * Main entry point.
     */
    public static void main(final String [] args) 
    {
        final Listener app = new Listener();
        app.test();
    }
}
