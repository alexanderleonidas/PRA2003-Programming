import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseTester {

    public static void gui(){        
        final JFrame frame = new JFrame("Mouse Tester");        
        frame.add(new MousePanel());        
        frame.setSize(600, 600);        
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MouseTester mt = new MouseTester();
        mt.gui();
    }
}

class MousePanel extends JPanel implements MouseListener, MouseMotionListener {
    
    private Point mouseDown;
    private Point mouseDrag;

    public MousePanel(){    
        addMouseListener(this);    
        addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseDrag = e.getPoint();
        repaint();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDown = e.getPoint();
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDown = null;
        mouseDrag = null;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        if(mouseDown != null){
            int r = 4; // Radius of the circle
            g.setColor(new Color(255, 0, 0));
            g.fillOval(mouseDown.x-r, mouseDown.y-r, 2*r-1, 2*r-1);
            repaint();
        } 
        if (mouseDrag != null){
            int r = 4;
            g.setColor(new Color(0, 0, 255));
            g.fillOval(mouseDrag.x-r, mouseDrag.y-r, 2*r-1, 2*r-1);
            repaint();
        }
    }
}
