package com.example.lucaberardi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * The activity used only in the case in which the modality that
 * foresees the challenge between two players is chosen.
 * The second player is invited to prepare, as he is about to start his turn.
 */

public class NextActivity extends Activity {

    private int scorePlayer1;
    private Mode mode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        //
        Intent intent = getIntent();
        mode = (Mode) intent.getSerializableExtra("mode");
        scorePlayer1= intent.getIntExtra(" scorePlayer1",  0);

        Button b = findViewById(R.id.nextButton);

        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(NextActivity.this, GameActivity.class);
                        intent2.putExtra("mode", mode);
                        intent2.putExtra("scorePlayer1",  scorePlayer1);
                        intent2.putExtra("player2",  1); //second player's turn
                         startActivity(intent2);
                         }

                });

    }
}