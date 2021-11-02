package minesweeper;

import java.util.Scanner;

public class Game {
    Field field;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("How many mines do you want on the field? ");
        int mines = scanner.nextInt();
        field = new Field(mines);
        field.printField();

        int markedMines = 0;

        while (!field.areAllMinesMarked() || markedMines != mines) {
            System.out.println("Set/delete mines marks (x and y coordinates): ");
            int col = scanner.nextInt() - 1;
            int row = scanner.nextInt() - 1;
            if (field.countMines(row, col) <= 0) {
                if (!field.getCellMarked(row, col)) {
                    field.setCellMarked(row, col, true);
                    markedMines++;
                } else {
                    field.setCellMarked(row, col, false);
                    markedMines--;
                }
                field.printField();
            } else {
                System.out.println("There is a number here!");
            }
        }
        System.out.println("Congratulations! You found all mines!");
    }
}
