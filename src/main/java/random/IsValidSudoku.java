package random;

import javax.lang.model.element.VariableElement;
import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] x = new HashSet[9];
        Set<Character>[] y = new HashSet[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    char c = board[i][j];
                    if (x[i] == null) x[i] = new HashSet<>();
                    if (y[j] == null) y[j] = new HashSet<>();

                    Set<Character> xSet = x[i];
                    Set<Character> ySet = y[j];


                    Set<Character> xTemp = xSet;
                    Set<Character> yTemp = ySet;

                    if (xSet.contains(c))
                        return false;
                    if (ySet.contains(c))
                        return false;

                    int xRange = i / 3;
                    int yRange = j / 3;

                    boolean flag = false;
                    for (int k = 3 * xRange; k < 3 * xRange + 3; k++) {
                        if (x[k] == null) x[k] = new HashSet<>();
                        if (x[k].contains(c)) {
//                            if (flag) return false;
                            for (int l = 3 * yRange; l < 3 * yRange + 3; l++) {
                                if (y[l] == null) y[l] = new HashSet<>();
                                if (y[l].contains(c))
//                                    flag = true;
                                    return false;
                            }
//                            if (flag) return false;

                        }
                    }
                    xSet.add(c);
                    ySet.add(c);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board ={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}} ;

        System.out.println(isValidSudoku(board));

    }
}
