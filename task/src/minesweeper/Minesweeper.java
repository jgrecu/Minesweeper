package minesweeper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
    private int rows;
    private int columns;
    private char[][] table;

    public Minesweeper(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        init();
    }

    private void init() {
        table = new char[rows][columns];
        for (char[] row : table) {
            Arrays.fill(row, '.');
        }
    }

    private void startTable() {
        Random rand = new Random(LocalDateTime.now().getNano());
        for (char[] row : table) {
            int randInt = rand.nextInt(9);
            row[randInt] = 'X';
        }
    }

    public void printTable() {
        startTable();
        for (char[] row : table) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
