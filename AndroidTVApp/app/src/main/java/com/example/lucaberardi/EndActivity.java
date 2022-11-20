package com.example.lucaberardi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * the Activity used at the end of each game.
 * The outcome of the game is displayed on the user interface and
 * it is possible to start the MainActivity to start a new one.
 */
public class EndActivity extends Activity {

    private int scorePlayer1;
    private int scorePlayer2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        //
        Intent intent = getIntent();
        scorePlayer1= intent.getIntExtra(" scorePlayer1",  -1);
        scorePlayer2= intent.getIntExtra(" scorePlayer2",  -1);
        //
        TextView txt1 = findViewById(R.id.score1);
        TextView txt2 = findViewById(R.id.score2);
        Button b = findViewById(R.id.home);

        
        if(scorePlayer1!=-1) txt1.setText("Player 1 Score:  "+scorePlayer1);
        if(scorePlayer2!=-1) txt2.setText("Player 2 Score:  "+scorePlayer2);

        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EndActivity.this, MainActivity.class);
                      startActivity(intent);
                         }

                });

    }
}