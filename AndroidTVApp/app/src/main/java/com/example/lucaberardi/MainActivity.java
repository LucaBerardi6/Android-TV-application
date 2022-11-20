package com.example.lucaberardi;

import android.app.Activity;
import android.os.Bundle;

/**
 * The launch Activity which represents the main screen of the application
 * where it is possible to choose the game mode and the type of challenge.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}