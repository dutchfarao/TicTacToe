package com.example.mainactivity;

import android.widget.Button;

import java.sql.RowId;


public class Game {

    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

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

    public TileState choose(int row, int column) {
        if (this.getTileState(row, column) == TileState.BLANK){
            if (playerOneTurn){
                if()
                this.board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                return TileState.CROSS;
            }
            else{
                this.board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                return TileState.CIRCLE;
            }
        }
        else{
            return TileState.INVALID;
        }


    }

 


   // public GameState status(GameState){
    //    RowId
      //  Button btn = (Button)findViewById(id)
        //player 1 wins with 3 crosses in a row
        //if(R.id.button1 && R.)
       // return GameState.PLAYER_ONE


       // return GameState.PLAYER_TWO

       // return GameState.IN_PROGRESS

    //}



}