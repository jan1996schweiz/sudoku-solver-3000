package ch.jannussberger;

import ch.jannussberger.Board.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testBoard() {
        SudokuBoard b = new SudokuBoard();
    }

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

    @Test
    void get() {
        SudokuBoard b = new SudokuBoard();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                assertTrue(b.get(c, r) == null);
            }
        }
    }

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