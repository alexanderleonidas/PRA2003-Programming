import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * PRA2003: File for Week 4 tasks.
 * @author cambolbro (based on code from previous years).
 */

//=============================================================================

// Task 4.1 (a): Complete the missing State interface. 
//
//  Add your code here...

//=============================================================================

/**
 * Tic-Tac-Toe board that implements the game state.
 */
class TTTBoard implements TTTState 
{
   	public static final int Dim = 3;

    private char[][] board;
    private char player;

    //-------------------------------------------------------------------------
    
    /**
     * Constructor.
     */
    public TTTBoard() 
    {    	
        player = 'o';
        board  = new char[Dim][Dim];

        for (int r = 0; r < Dim; r++)
            for (int c = 0; c < Dim; c++)
                board[r][c] = '.';
    }

    //-------------------------------------------------------------------------
    // Overrides from State class
    
    @Override
    public char getValue(final int row, final int col) 
    {
        return board[row][col];
    }

    @Override
    public char currentPlayer() 
    {
        return player;
    }

    @Override
    public void clickCell(final int row, final int col) 
    {
        if (board[row][col] == '.') 
        {
            board[row][col] = player;
            nextPlayer();
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Switch to next player.
     */
    private void nextPlayer() 
    {
    	player = (player == 'o') ? 'x' : 'o';
    }
}

//=============================================================================

// Task 4.1 (b): Implement the MouseEventTrapperClass:

class MouseEventTrapper implements MouseListener 
{
    private final TTTPanel panel;
    private final TTTState state;

    public MouseEventTrapper(TTTPanel panel, TTTState state){
        this.panel = panel;
        this.state = state;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("Click at: (" + e.getX() + "," + e.getY() + ").");
        final int cellHeight = e.getY()/(panel.getHeight()/TTTBoard.Dim);
        final int cellWidth = e.getX()/(panel.getWidth()/TTTBoard.Dim);
        if(state.getValue(cellHeight, cellWidth) == '.'){
            panel.addDogAt(state.currentPlayer(), cellHeight , cellWidth);
            state.clickCell(cellHeight, cellWidth);
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // System.out.println("Pressed at: (" + e.getX() + "," + e.getY() + ").");
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.println("Released at: (" + e.getX() + "," + e.getY() + ").");
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}

//=============================================================================

/**
 * Custom panel for our TTT game.
 */
class TTTPanel extends JPanel 
{
    private final JLabel[][] labels;

    /**
     * Constructor.
     */
    public TTTPanel() 
    {
        // Make a 3-by-3 grid layout
        final GridLayout layout = new GridLayout(TTTBoard.Dim, TTTBoard.Dim, 0, 0);
        setLayout(layout);

        // Create a label for each cell
        labels = new JLabel[TTTBoard.Dim][TTTBoard.Dim];
        for (int r = 0; r < TTTBoard.Dim; r++)
            for (int c = 0; c < TTTBoard.Dim; c++) 
            {
                labels[r][c] = new JLabel();
                add(labels[r][c]);
            }
    }

    /**
     * Modify the appropriate label by setting its image icon.
     * The player should be either 'x' or 'o'.
     */
    public void addDogAt(final char player, final int row, final int col) 
    {
        labels[row][col].setIcon(new ImageIcon("dog-" + player + ".png"));
        repaint();
    }

}

//=============================================================================

/**
 * Main GUI class.
 */
class GUI 
{
    private JFrame   frame;
    private TTTPanel panel;
    private TTTBoard board;

    /**
     * Initialise the GUI.
     */
    public void init() 
    {
        frame = new JFrame("Tic-Tac-Toe, MSC PRA2003 Edition");

        // Each cell is 100x100
        // Add 5 pixels for outer edge and 10 pixels for bar at top
        frame.setPreferredSize(new Dimension(305, 310));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel
        panel = new TTTPanel();
        panel.setSize(305, 310);

        // Add the panel to the frame
        frame.add(panel);

        // Create the Tic-Tac-Doge board
        board = new TTTBoard();

        // Add the mouse event trapper to the panel
        panel.addMouseListener(new MouseEventTrapper(panel, board));

        frame.pack();
        frame.setVisible(true);
    }

    //-------------------------------------------------------------------------
    
    /**
     * Main entry point.
     */
    public static void main(final String[] args) 
    {
        GUI gui = new GUI();
        gui.init();
    }

}

/**
 * Q1) The X and Y values are the coordinates starting at the top left and increasing to the bottom right
 * Q2) The mouse position is not shown while dragging the mouse because the MouseListner method mousePressed
 * must be implemented.
 */
