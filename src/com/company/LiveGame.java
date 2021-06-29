package com.company;

import java.util.Arrays;

public class LiveGame {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0}, {0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void gameOfLife(int[][] board) {
        int a = board.length;
        int b = board[0].length;
        int[][] res = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int curr = board[i][j];
                if (curr == 1 && livesAround(board, i, j) < 2)
                    res[i][j] = 0;
                else if (curr == 1 && (livesAround(board, i, j) == 2 || livesAround(board, i, j) == 3))
                    res[i][j] = 1;
                else if (curr == 1 && livesAround(board, i, j) > 3)
                    res[i][j] = 0;
                else if (curr == 0 && livesAround(board, i, j) == 3)
                    res[i][j] = 1;
                else
                    res[i][j] = 0;
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                board[i][j] = res[i][j];
            }
        }
        // System.out.println(Arrays.deepToString(res));
    }

    public static int livesAround(int[][] board, int m, int n) {
        return livesAt(board, m-1, n-1)
                + livesAt(board, m-1, n)
                + livesAt(board,m-1, n+1)
                + livesAt(board,m,n+1)
                + livesAt(board,m+1, n+1)
                + livesAt(board, m+1, n)
                + livesAt(board, m+1, n-1)
                + livesAt(board,m, n-1);
    }

    public static int livesAt(int[][] board, int p, int q) {
        if (p < 0 || q < 0 || p >= board.length || q >= board[0].length)
            return 0;
        return board[p][q];
    }
}
