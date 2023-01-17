package com.sudoku;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.sudoku.buildlogic.SudokuBuildLogic;
import com.sudoku.userinterface.IUserInterfaceContract;
import com.sudoku.userinterface.UserInterfaceImpl;

/**
 * JavaFX App
 */
public class SudokuApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        IUserInterfaceContract.View uiImpl = new UserInterfaceImpl(stage);

       try {
        SudokuBuildLogic.build(uiImpl);
       } catch (IOException e) {
        e.printStackTrace();
        throw e;
       }
    }

    public static void main(String[] args) {
        launch(args);
    }
}