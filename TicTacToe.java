package com.NumberGuessing;

import java.util.Scanner;

class TicTok {

    private char[][] board;
    private char currentPlayer;

    public TicTok() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public void printBoard() {
        System.out.println("----------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("----------------");
        }
    }

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}

public class TicTacToe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicTok game = new TicTok();

        System.out.println("🎮 Tic Tac Toe : 2 Player Game");

        while (true) {

            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + " turn");

            int row, col;

            // Safe Input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number 0-2.");
                sc.next();
                continue;
            }
            row = sc.nextInt();

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number 0-2.");
                sc.next();
                continue;
            }
            col = sc.nextInt();

            if (!game.makeMove(row, col)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (game.checkWin()) {
                game.printBoard();
                System.out.println("🎉 Player " + game.getCurrentPlayer() + " Wins!!!");
                break;
            }

            if (game.isBoardFull()) {
                game.printBoard();
                System.out.println("🤝 It's a Draw!");
                break;
            }

            game.switchPlayer();
        }

        sc.close();
    }
}
