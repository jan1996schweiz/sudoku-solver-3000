/**
 * This is my JavaFX class represent a board is to try out different configurations on the board
 *
 * @author Jan Nussberger
 * @version 1.0
 * @since 2021-06-10
 */

package ch.jannussberger.Board;

public class SudokuBoard {

    private Integer[][] board = new Integer[9][9];

    //Constructor
    public SudokuBoard() {
    }

    /**
     *a constructor to copy an existing board
     *
     * @param copyBoard
     */
    public SudokuBoard(SudokuBoard copyBoard) {
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                board[c][r] = copyBoard.get(c, r);
            }
        }
    }

    /**
     * @param c colum
     * @param r row
     * @return return the board
     */
    public Integer get(int c, int r) {
        return board[c][r];
    }

    /**
     * @param c colum
     * @param r row
     * @param x to set an intiger
     */
    public void set(int c, int r, Integer x) {
        board[c][r] = x;
    }
}

