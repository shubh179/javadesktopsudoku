package com.sudoku.buildlogic;

import java.io.IOException;

import com.sudoku.computationlogic.GameLogic;
import com.sudoku.persistence.LocalStorageImpl;
import com.sudoku.problemdomain.IStorage;
import com.sudoku.problemdomain.SudokuGame;
import com.sudoku.userinterface.IUserInterfaceContract;
import com.sudoku.userinterface.logic.ControlLogic;

public class SudokuBuildLogic {

    private SudokuBuildLogic() {
        //do nothing
    }

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        }
        catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);

        userInterface.updateBoard(initialState);
    }
}
