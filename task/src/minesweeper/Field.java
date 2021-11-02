package minesweeper;

import java.util.Random;

public class Field {
    final int SIZE = 9;
    final char UNKNOWN = '.';
    final char MINE = 'X';
    final char MARKED = '*';

    private Cell[][] cells;

    public Field(int mines) {
        cells = new Cell[SIZE][SIZE];

        int numberOfMines = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell();
            }
        }

        while (numberOfMines < mines) {
            Random random = new Random();
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (!cells[row][col].hasMine) {
                cells[row][col].hasMine = true;
                numberOfMines++;
            }
        }

    }

    public void printField() {
        System.out.println(" │123456789│\n—│—————————│");
        for (int i = 0; i < cells.length; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j].isMarked) {
                    System.out.print(MARKED);
                } else {
                    int numberOfMines = countMines(i, j);
                    if (numberOfMines <= 0) {
                        System.out.print(UNKNOWN);
                    } else {
                        System.out.print(numberOfMines);
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }

    public int countMines(int row, int col) {
        int result = 0;

        if (cells[row][col].hasMine) {
            return -1;
        }
        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;

        if (row == 0) {
            up = 0;
        }
        if (row == cells.length - 1) {
            down = 0;
        }
        if (col == 0) {
            left = 0;
        }
        if (col == cells.length - 1) {
            right = 0;
        }

        for (int i = row - up; i <= row + down; i++) {
            for (int j = col - left; j <= col + right; j++) {
                if (cells[i][j].hasMine) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean getCellMarked(int row, int col) {
        return cells[row][col].isMarked;
    }

    public void setCellMarked(int row, int col, boolean value) {
        cells[row][col].isMarked = value;
    }

    public boolean areAllMinesMarked() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j].hasMine && !cells[i][j].isMarked) {
                    return false;
                }
            }
        }
        return true;
    }
}
