package Backtracking;

import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true }, { true, true, true }, { true, true, true } };
        int[][] stepboard = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        new Solution().mazeProblem(2, 0, 0, -1, -1, board, stepboard, 1, "");
        // new Solution().mazeProblem2(2, 0, 0, board, stepboard, 1, "");
    }
}

class Solution {

    void mazeProblem(int size, int r, int c, int prer, int prec, boolean[][] board, int[][] stepboard, int step,
            String path) {
        // backtraking logic
        if (board[r][c] == false) {
            return;
        }

        if (prer != -1 && prec != -1) {
            board[prer][prec] = false;
        }
        // backtraking logic
        stepboard[r][c] = step;

        if (r == size && c == size) {
            System.out.println(path);
            System.out.println(Arrays.deepToString(stepboard));
            board[prer][prec] = true; // backtraking logic
            return;
        }

        if (r < size) {
            mazeProblem(size, r + 1, c, r, c, board, stepboard, step + 1, path + "D");
        }

        if (c < size) {
            mazeProblem(size, r, c + 1, r, c, board, stepboard, step + 1, path + "R");
        }

        if (r > 0) {
            mazeProblem(size, r - 1, c, r, c, board, stepboard, step + 1, path + "U");
        }

        if (c > 0) {
            mazeProblem(size, r, c - 1, r, c, board, stepboard, step + 1, path + "L");
        }

        // backtraking logic
        if (prer != -1 && prec != -1) {
            board[prer][prec] = true;
        }
        // stepboard[r][c] = 0;
        // backtraking logic
    }

    void mazeProblem2(int size, int r, int c, boolean[][] board, int[][] stepboard, int step, String path) {
        // backtraking logic
        if (board[r][c] == false) {
            return;
        } else {
            board[r][c] = false;
        }
        // backtraking logic
        stepboard[r][c] = step;
        if (r == size && c == size) {
            System.out.println(Arrays.deepToString(stepboard));
            System.out.println(path);
            board[r][c] = true; // backtraking logic
            return;
        }

        if (r < size) {
            mazeProblem2(size, r + 1, c, board, stepboard, step + 1, path + "D");
        }

        if (c < size) {
            mazeProblem2(size, r, c + 1, board, stepboard, step + 1, path + "R");
        }

        if (r > 0) {
            mazeProblem2(size, r - 1, c, board, stepboard, step + 1, path + "U");
        }

        if (c > 0) {
            mazeProblem2(size, r, c - 1, board, stepboard, step + 1, path + "L");
        }
        // backtraking logic
        board[r][c] = true;
        // backtraking logic
    }
}
