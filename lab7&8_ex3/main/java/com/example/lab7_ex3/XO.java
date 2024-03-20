package com.example.lab7_ex3;

public class XO {
    public static final int SIZE = 3;

    private char[][] board;
    private char currentPlayer;

    public XO() {
        board = new char[SIZE][SIZE];
        currentPlayer = 'X'; // X starts the game
        initializeBoard();
    }

    private void initializeBoard() {
        // Fill the board with empty cells
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }



    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
    }

    public void makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public boolean checkWin() {
        // Check rows
        for (int row = 0; row < SIZE; row++) {
            if (board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < SIZE; col++) {
            if (board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }


    public boolean checkDraw() {
        // Check if all cells are filled
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return !checkWin();
    }


    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

}
