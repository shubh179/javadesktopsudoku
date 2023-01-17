package com.sudoku.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sudoku.problemdomain.IStorage;
import com.sudoku.problemdomain.SudokuGame;

public class LocalStorageImpl implements IStorage {

    private static File GAME_DATA = new File(
        "C:/Users/shubh/Desktop/projects/java/javadesktopsudoku",
        "gamedata.txt"
    );

    @Override
    public void updateGameData(SudokuGame game) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        try {
            objectOutputStream.writeObject(game);
        }
        catch (IOException e) {
            throw new IOException("Unable to access Game Data");
        }
        finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
     }

    @Override
    public SudokuGame getGameData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            return (SudokuGame) objectInputStream.readObject();
        }
        catch (ClassNotFoundException e) {
            throw new IOException("File Not Found");
        }
        finally {
            objectInputStream.close();
            fileInputStream.close();
        }
    }
    
}
