package LeetCode;

import java.util.Arrays;

public class s37解数独 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new s37解数独().solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    public boolean solveSudoku(char[][] board, int x, int y) {
        if (board[x][y] != '.') {
            if (y == board.length - 1 && x == board.length - 1) {
                return true;
            }
            if (y == board.length - 1) {
                return solveSudoku(board, x + 1, 0);

            } else {
                return solveSudoku(board, x, y + 1);
            }
        } else {
            for (char i = '1'; i <= '9'; i++) {
                board[x][y] = i;
                if (Judge(board, x, y)) {
                    if (x == board.length - 1 && y == board.length - 1) {
                        return true;
                    }
                    if (y == board.length - 1) {
                        if (solveSudoku(board, x + 1, 0)) {
                            return true;
                        }
                    } else {
                        if (solveSudoku(board, x, y + 1)) {
                            return true;
                        }
                    }
                }
                board[x][y] = '.';
            }
        }
        return false;
    }


    public static boolean Judge(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (y != i && board[x][i] == board[x][y]) {
                return false;
            }
            if (x != i && board[i][y] == board[x][y]) {
                return false;
            }

        }
        int startRow = (x / 3) * 3;
        int startCol = (y / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
