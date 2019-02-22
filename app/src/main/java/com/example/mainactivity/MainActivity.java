package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //initiation
    Game game;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    TextView txt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();


        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        txt1 = (TextView) findViewById(R.id.textView);


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //serialization of class game to save disabled buttons
        outState.putSerializable("Game1", game);
        //save state of visibility of X or O, key:value pair
        outState.putCharSequence("btn1", btn1.getText());
        outState.putCharSequence("btn2", btn2.getText());
        outState.putCharSequence("btn3", btn3.getText());
        outState.putCharSequence("btn4", btn4.getText());
        outState.putCharSequence("btn5", btn5.getText());
        outState.putCharSequence("btn6", btn6.getText());
        outState.putCharSequence("btn7", btn7.getText());
        outState.putCharSequence("btn8", btn8.getText());
        outState.putCharSequence("btn9", btn9.getText());
        outState.putInt("txt1", txt1.getVisibility());

    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        //calling serialised game and calling GameEnder to disable buttons
        game = (Game) inState.getSerializable("Game1");
        GameEnder(game.won());
        //summon value of image with key
        btn1.setText(inState.getCharSequence("btn1"));
        btn2.setText(inState.getCharSequence("btn2"));
        btn3.setText(inState.getCharSequence("btn3"));
        btn4.setText(inState.getCharSequence("btn4"));
        btn5.setText(inState.getCharSequence("btn5"));
        btn6.setText(inState.getCharSequence("btn6"));
        btn7.setText(inState.getCharSequence("btn7"));
        btn8.setText(inState.getCharSequence("btn8"));
        btn9.setText(inState.getCharSequence("btn9"));
        txt1.setVisibility(inState.getInt("txt1"));


    }






    public void tileClicked(View view) {
        int id = view.getId();
        TileState state = null;
        switch(view.getId()){
            case R.id.button1:
                state = game.choose(0, 0);
                break;
            case R.id.button2:
                state = game.choose(0,1);
                break;
            case R.id.button3:
                state = game.choose(0, 2);
                break;
            case R.id.button4:
                state = game.choose(1,0);
                break;
            case R.id.button5:
                state = game.choose(1,1);
                break;
            case R.id.button6:
                state = game.choose(1,2);
                break;
            case R.id.button7:
                state = game.choose(2,0);
                break;
            case R.id.button8:
                state = game.choose(2,1);
                break;
            case R.id.button9:
                state = game.choose(2,2);
                break;

        }
        //call GameEnder and buttonUpdater
        game.won();
        GameEnder(game.won());

        buttonUpdater(state, id);

    }
    //disable all ties when there is a tie or when someone wins
    public void GameEnder(GameState state){
        TextView txt1;
        Button btn1;
        Button btn2;
        Button btn3;
        Button btn4;
        Button btn5;
        Button btn6;
        Button btn7;
        Button btn8;
        Button btn9;
        txt1 = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        switch(state){
            case PLAYER_ONE:
                txt1.setText("Cross wins!");
                txt1.setVisibility(View.VISIBLE);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);

                break;
            case PLAYER_TWO:
                txt1.setText("Circle wins!");
                txt1.setVisibility(View.VISIBLE);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);

                break;
            case DRAW:
                txt1.setText("It's a draw!");
                txt1.setVisibility(View.VISIBLE);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                break;
            case IN_PROGRESS:
                break;



        }
    }

    public void buttonUpdater(TileState state, int id){

        // change the tilestate of button
        Button btn = findViewById(id);


        switch(state) {
            case CROSS:
                btn.setText("X");
                break;
            case CIRCLE:
                btn.setText("O");
                break;
            case INVALID:
                // just break
                break;
        }

    }
    //reset game when 'reset' button is clicked
    public void resetClicked(View view) {
        setContentView(R.layout.activity_main);
        game = new Game();
    }







}
