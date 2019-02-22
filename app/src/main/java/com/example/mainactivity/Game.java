package com.example.mainactivity;

import java.io.Serializable;

public class Game implements Serializable{

    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed = 0;
    public Boolean gameOver;



//create board, set tilestate to blank for all tiles
    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public TileState getTileState(int row, int column){
        return this.board[row][column];
    }

    //change tilestate, switch between player 1 and two, then add 1 to movesplayed to keep track of the turn for a tie.
    public TileState choose(int row, int column) {
        if (this.getTileState(row, column) == TileState.BLANK){
            if (playerOneTurn){
                this.board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                movesPlayed ++;
                return TileState.CROSS;
            }
            else{
                this.board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                movesPlayed ++;
                return TileState.CIRCLE;
            }
        }
        else{
            return TileState.INVALID;
        }


    }


    public GameState won(){
        //check all possible winning combinations, also check for a tie.
        if(movesPlayed >= 9){
            return GameState.DRAW;
        }
        else if(getTileState(0, 0) == getTileState(0,1) && getTileState(0,2) == getTileState(0,1) && getTileState(0,1) != TileState.BLANK){
            if(!playerOneTurn){

                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        else if(getTileState(1,0) == getTileState(1,1) && getTileState(1,2) == getTileState(1,1)&& getTileState(1,0) != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        else if(getTileState(2, 0) == getTileState(2,1) && getTileState(2,2) == getTileState(2,1)&& getTileState(2,0) != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        //check all columns
        else if(getTileState(0, 0) == getTileState(1,0) && getTileState(2,0) == getTileState(1,0)&& getTileState(0,0) != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        else if(getTileState(0, 1) == getTileState(1,1) && getTileState(2,1) == getTileState(1,1)&& getTileState(0,1) != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else {

                return GameState.PLAYER_TWO;
            }
        }
        else if(getTileState(0, 2) == getTileState(1,2) && getTileState(2,2) == getTileState(1,2)&& getTileState(0,2) != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        // check voor schuine rij
        else if(getTileState(0, 0) == getTileState(1,1) && getTileState(2,2) == getTileState(1,1)&& getTileState(0,0) != TileState.BLANK){
            if(!playerOneTurn){

                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        //check voor andere schuine rij
        else if(getTileState(2, 0) == getTileState(1,1) && getTileState(0,2) == getTileState(1,1)&& getTileState(2,0) != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else {
                return GameState.PLAYER_TWO;
            }
        }
        else{
            return GameState.IN_PROGRESS;
        }


    }


}

