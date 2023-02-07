import java.awt.*;
/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam, Jake Sonsini
 * @version: Feb 2023
 */

public class Square {
    private final int squareSize = 200;
    private final int xShift = 200;
    private final int yShift = 150;
    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
    public void draw(Graphics g, TicTacToeViewer tic){
        if (isWinningSquare == true){
            // After determining whether this square is a winning square,
            // set color to green and print green square
            g.setColor(Color.green);
            g.fillRect(200 + squareSize * col, 150 + squareSize * row, squareSize, squareSize);
            // Then print the board outline and image
            g.setColor(Color.black);
            g.drawRect(xShift + squareSize * col, yShift + squareSize * row, squareSize, squareSize);
            // This if statement checks which image to print
            if (marker.equals("X")){
                g.drawImage(tic.getImages()[1], xShift + squareSize * col, yShift + squareSize * row, squareSize, squareSize, tic);
            }
            else if (marker.equals("O")){
                g.drawImage(tic.getImages()[0], xShift + squareSize * col, yShift + squareSize * row, squareSize, squareSize, tic);
            }
            // Set font and print winning message
            g.setFont(new Font("Font", Font.ROMAN_BASELINE, 20));
            g.drawString(marker + " Wins!", 500, 800);
        }
        else{
            // Print the board outline and image
            g.setColor(Color.black);
            g.drawRect(xShift + squareSize * col, yShift + squareSize * row, squareSize, squareSize);
            // This if statement checks which image to print
            if (marker.equals("X")){
                g.drawImage(tic.getImages()[1], xShift + squareSize * col, yShift + squareSize * row, squareSize, squareSize, tic);
            }
            if (marker.equals("O")){
                g.drawImage(tic.getImages()[0], xShift + squareSize * col, yShift + squareSize * row, squareSize, squareSize, tic);
            }
        }
    }
}
