package ch.jannussberger.Board;

public class SudokuBoard {
        /*
        represent the sudoku board
        class to try oute some conf numbers in the bord
         */

        Integer[][] board = new Integer[9][9];

        //Constructor
        public SudokuBoard() {
        }

        public SudokuBoard(SudokuBoard copyMe) {
            for (int c = 0; c < 9; c++) {
                for (int r = 0; r < 9; r++) {
                    board[c][r] = copyMe.get(c,r);
                }
            }
        }
        public Integer get(int c, int r) {
            return board[c][r];
        }
        public void set(int c, int r, Integer x) {
            board[c][r]=x;
        }
    }

