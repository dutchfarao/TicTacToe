package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

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

        buttonUpdater(state, id);

    }

    public void buttonUpdater(TileState state, int id){

        // globally
        Button btn = (Button)findViewById(id);


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

    public void resetClicked(View view) {
        setContentView(R.layout.activity_main);
        game = new Game();
    }





}
