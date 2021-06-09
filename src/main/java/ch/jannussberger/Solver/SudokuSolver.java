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

    public boolean validAllRows(SudokuBoard b) {
        for (int r = 0; r < 9; r++) {
            if (!vailidRow(b, r)) {
                return false;
            }
        }
        return true;
    }

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

    public boolean validAllColumn(SudokuBoard b) {
        for (int c = 0; c < 9; c++) {
            if (!vailidColumn(b, c)) {
                return false;
            }
        }
        return true;
    }

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

    public SudokuBoard solve(SudokuBoard partial) {
        if (!valid(partial)) {
            return null;
        }
        if (completeAndValid(partial)) {
            return partial;
        }

        SudokuBoard b = new SudokuBoard(partial);

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Integer i = b.get(c, r);
                if (i == null) {
                    Set<Integer> tryUs = new HashSet<Integer>(checker);
                    for (Integer number : tryUs) {
                        b.set(c, r, number);
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


