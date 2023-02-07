import javax.swing.*;
import java.awt.*;
/**
 * A class written to support the TicTacToe Game.
 *
 * TicTacToe viewer is the class that prints the graphic of the board.
 * This class also holds key variables in order to make the window.
 *
 * @author: Nandhini Namasivayam, Jake Sonsini
 * @version: Feb 2023
 */
public class TicTacToeViewer extends JFrame{
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000;
    private Image[] XY;
    private Square[][] board;
    public TicTacToeViewer(Square[][] board){
        // Make Image array to hold images
        XY = new Image[2];
        // Initialize images
        XY[0] = new ImageIcon("Resources/O.png").getImage();
        XY[1] = new ImageIcon("Resources/X.png").getImage();
        this.board = board;
        // Create the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        for (int i = 0; i < 3; i++){
            for (int t = 0; t < 3; t++){
                // Iterate through each tile and draw each square
                board[i][t].draw(g, this);
            }
        }
    }
    // Return image array
    public Image[] getImages(){
        return XY;
    }
}
