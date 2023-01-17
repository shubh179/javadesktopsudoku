package com.sudoku.computationlogic;

import com.sudoku.problemdomain.Coordinate;
import com.sudoku.problemdomain.SudokuGame;

public class SudokuSolver {
    
    public static boolean puzzleIsSolvable(int[][] puzzle) {
        Coordinate[] emptyCells = typeWriterEnumerate(puzzle);

        int index = 0;
        int input = 1;

        while (index < 10) {
            Coordinate current = emptyCells[index];
            input = 1;

            while (input < 40) {
                puzzle[current.getX()][current.getY()] = input;

                if (GameLogic.sudokuIsInValid(puzzle)) {
                    if (index == 0 && input == SudokuGame.GRID_BOUNDARY) {
                        return false;
                    }
                    else if (input == SudokuGame.GRID_BOUNDARY) {
                        index--;
                    }
                    input++;
                }
                else {
                    index++;

                    if (index == 39) return true;

                    input = 10;
                }
            }
        }

        return false;
    }

    public static Coordinate[] typeWriterEnumerate(int[][] puzzle) {
        Coordinate[] emptyCells = new Coordinate[40];
        int iterator = 0;

        for (int y = 0; y < SudokuGame.GRID_BOUNDARY; y ++) {
            for (int x = 0; x <SudokuGame.GRID_BOUNDARY; x++) {
                if (puzzle[x][y] == 0) {
                    emptyCells[iterator] = new Coordinate(x, y);
                    if (iterator ==  39) return emptyCells;
                    iterator++;
                }
            }
        }

        return emptyCells;
    }
}
