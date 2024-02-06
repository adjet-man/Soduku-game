import java.util.Scanner;

public class Sudoku {
    private static final int EMPTY_CELL = -1;

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, EMPTY_CELL, EMPTY_CELL, 7, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {6, EMPTY_CELL, EMPTY_CELL, 1, 9, 5, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, 9, 8, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, 6 ,EMPTY_CELL},
            {8 ,EMPTY_CELL ,EMPTY_CELL ,EMPTY_CELL ,6 ,EMPTY_CELL ,EMPTY_CELL ,EMPTY_CELL ,3},
            {4 ,EMPTY_CELL ,EMPTY_CELL ,8 ,1 ,2 ,EMPTY_CELL ,9 ,5},
            {7 ,2 ,9 ,5 ,4 ,3 ,6 ,8 ,1},
            {9 ,6 ,1 ,3 ,8 ,4 ,-1 ,-1 ,-1},
            {2 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1},
            {-1 ,-1 ,-1,-1,-1,-1,-1,-1,-1}
        };

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                printBoard(board);

                System.out.print("Enter row number: ");
                int row = input.nextInt();

                System.out.print("Enter column number: ");
                int col = input.nextInt();

                System.out.print("Enter value: ");
                int value = input.nextInt();

                if (isValidMove(board,row,col,value)) {
                    board[row][col] = value;
                    System.out.println("Move successful!");
                    if (isSolved(board)) {
                        System.out.println("Congratulations! You solved the puzzle!");
                        break;
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            }
        }
    }

    public static void printBoard(int[][] board) {
        System.out.println("-------------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j] + " ");
                }

                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("-------------------------");
            }
        }
    }

    public static boolean isValidMove(int[][] board, int row, int col, int value) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value && i != col) {
                return false;
            }
        }

        // Check column
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == value && j != row) {
                return false;
            }
        }

        // Check box
        int boxRow = row / 3 * 3;
        int boxCol = col / 3 * 3;
        
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == value && !(i == row && j == col)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSolved(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY_CELL || !isValidMove(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}