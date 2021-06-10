/**
 * Junit test class to test the board
 *
 *
 * @author Jan Nussberger
 * @version 1.0
 * @since 2021-06-10
 */

package ch.jannussberger;

import ch.jannussberger.Board.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    /**
     * test the basic constructor
     */
    @Test
    void testBoard() {
        SudokuBoard b = new SudokuBoard();
    }

    /**
     * tests that there are no duplicates numbers
     */
    @Test
    void testBoardBoard() {
        SudokuBoard b = new SudokuBoard();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                b.set(c, r, 1);
            }
        }
        SudokuBoard b2 = new SudokuBoard();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                assertTrue(b2.get(c, r) == null);
            }
        }
    }

    /**
     * tests the getter
     * tests that everything is null when I create it
     */
    @Test
    void get() {
        SudokuBoard b = new SudokuBoard();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                assertTrue(b.get(c, r) == null);
            }
        }
    }


    /**
     * tests the setter
     * tests that if I set one it turns to one
     */
    @Test
    void set() {
        SudokuBoard b = new SudokuBoard();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                b.set(c, r, 1);
            }
        }
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                assertTrue(b.get(c, r) == 1);
            }
        }
    }
}