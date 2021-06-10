/**
 * This is my SudokuSolver class and is responsible to solve the Sudoku
 *
 * @author Jan Nussberger
 * @version 1.0
 * @since 2021-06-10
 */

package ch.jannussberger.Solver;

import ch.jannussberger.Board.SudokuBoard;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    private Set<Integer> checker;

    public SudokuSolver() {
        checker = new HashSet<Integer>();
        checker.add(1);
        checker.add(2);
        checker.add(3);
        checker.add(4);
        checker.add(5);
        checker.add(6);
        checker.add(7);
        checker.add(8);
        checker.add(9);
    }

    /**
     *
     * check an existing board
     * does not have two numbers in the same row
     *
     * @param b is the bord we wanne check
     * @param r is the row we wanne check
     * @return return true is it valid
     */
    public boolean vailidRow(SudokuBoard b, int r) {
        Set<Integer> n = new HashSet<Integer>(checker);
        for (int c = 0; c < 9; c++) {
            Integer i = b.get(c, r);
            if (i != null) {
                if (!n.contains(i)) {
                    return false;
                } else {
                    n.remove(i);
                }
            }
        }
        return true;
    }

    /**
     * check an existing board
     * does not have two numbers in all rows
     *
     * @param b is the bord we wanne check
     * @return return true is it valid
     */
    public boolean validAllRows(SudokuBoard b) {
        for (int r = 0; r < 9; r++) {
            if (!vailidRow(b, r)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * check an existing board
     * does not have two numbers in the same colums
     *
     * @param b is the bord we wanne check
     * @param c is the row we colum check
     * @return return true is it valid
     */
    public boolean vailidColumn(SudokuBoard b, int c) {
        Set<Integer> n = new HashSet<Integer>(checker);
        for (int r = 0; r < 9; r++) {
            Integer i = b.get(c, r);
            if (i != null) {
                if (!n.contains(i)) {
                    return false;
                } else {
                    n.remove(i);
                }
            }
        }
        return true;
    }

    /**
     * check an existing board
     * does not have two numbers in all column
     *
     * @param b is the bord we wanne check
     * @return return true is it valid
     */
    public boolean validAllColumn(SudokuBoard b) {
        for (int c = 0; c < 9; c++) {
            if (!vailidColumn(b, c)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * check an existing board
     * does not have two numbers in the same square
     *
     * @param b is the bord we wanne check
     * @param ac is the colum we colum check
     * @param ar is the row we colum check
     * @return return true is it valid
     */
    public boolean vailidSquares(SudokuBoard b, int ac, int ar) {
        Set<Integer> n = new HashSet<Integer>(checker);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                Integer i = b.get(ac + c, ar + r);
                if (i != null) {
                    if (!n.contains(i)) {
                        return false;
                    } else {
                        n.remove(i);
                    }
                }
            }
        }
        return true;
    }

    /**
     * check an existing board
     * does not have two numbers in all squares
     *
     * @param b is the bord we wanne check
     * @return return true is it valid
     */
    public boolean validAllSquares(SudokuBoard b) {
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!vailidSquares(b, c, r)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * overall board checker
     *
     * @param b b is the bord we wanne check
     * @return return true is it valid
     */
    public boolean valid(SudokuBoard b) {
        return validAllRows(b) && validAllColumn(b) && validAllSquares(b);
    }

    public boolean complete(SudokuBoard b) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (b.get(c, r) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean completeAndValid(SudokuBoard b) {
        return valid(b) && complete(b);
    }

    /**
     * creates two endcases
     *
     * @return on a wrong board return false
     * @return on a good board return true
     */
    public SudokuBoard solve(SudokuBoard partial) {
        if (!valid(partial)) {
            return null;
        }
        if (completeAndValid(partial)) {
            return partial;
        }

        SudokuBoard b = new SudokuBoard(partial);

        /**
         * sudoku backtracking algorithm
         */
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Integer i = b.get(c, r);
                if (i == null) {
                    Set<Integer> tryUs = new HashSet<Integer>(checker);
                    for (Integer sudokuNumber : tryUs) {
                        b.set(c, r, sudokuNumber);
                        SudokuBoard solution = solve(b);
                        if (solution != null) {
                            return solution;
                        }
                    }
                    return null;
                }

            }

        }
        return null;
    }
}


