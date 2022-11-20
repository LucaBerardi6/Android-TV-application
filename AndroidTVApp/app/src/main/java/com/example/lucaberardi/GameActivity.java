package com.example.lucaberardi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * the Activity that represents the game screen. The user interacts
 * with the application by answering the questions.
 */
public class GameActivity extends Activity {

    private int totalQuestions; //questions that the user answered
    private int scorePlayer1; //player1 score
    private int scorePlayer2;  //player2 score
    private int player2; //indicates player 2's turn
    private Mode mode; // game mode
    private  List<Question> questionsList; //list with questions


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //
        Intent intent = getIntent();
        mode = (Mode) intent.getSerializableExtra("mode");
        scorePlayer1= intent.getIntExtra("scorePlayer1",  0); //player 1 score
        player2=intent.getIntExtra("player2",-1); // ==1 if it's player 2's turn
        //CREATE LIST OF QUESTIONS:
        questionsList = QuestionsList.getQuestionList(mode.getQuestion());
        //
        totalQuestions = 0;
        if(mode.getPlayers()==2)  scorePlayer2=0;
        else  scorePlayer2=-1; //single player
        //Retrieve Reference View to monitor events
        //--------------------BUTTON:--------------------------------
        Button b3 = findViewById(R.id.button3);
        Button b2 = findViewById(R.id.button2);
        Button b1 = findViewById(R.id.button1);
        //--------------------TEXTVIEW:------------------------------
        TextView txt = findViewById(R.id.textView);
        //--------------------SET VIEW:------------------------------
        txt.setText(questionsList.get(totalQuestions).getQuestion());
        b1.setText(questionsList.get(totalQuestions).getAnswer1());
        b2.setText(questionsList.get(totalQuestions).getAnswer2());
        b3.setText(questionsList.get(totalQuestions).getAnswer3());
        //
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       TextView txtv = findViewById(R.id.textView);
                        Button b3 = findViewById(R.id.button3);
                        Button b2 = findViewById(R.id.button2);
                        Button b1 = findViewById(R.id.button1);

                        //CORRECT ANSWER:
                      if(b1.getText().toString().equalsIgnoreCase(questionsList.get(totalQuestions).getCorrectAnswer()))
                        {
                            if(player2==-1)  scorePlayer1++; //correct answer (player 1)
                            else  scorePlayer2++; //correct answer (player 2)
                       }

                        ++totalQuestions; //increment answered questions
                        //END OF GAME:
                        if (totalQuestions == mode.getQuestion())
                        {
                            if(mode.getPlayers()==1) // if the single player game is over
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                            else if(mode.getPlayers()==2 && player2==-1) //if player 2 should play
                            {
                                Intent intent =new Intent(GameActivity.this, NextActivity.class);
                                intent.putExtra("mode", mode);
                                intent.putExtra(" scorePlayer1",  scorePlayer1);
                                startActivity(intent);

                            }
                            else if(mode.getPlayers()==2 && player2==1) // if the game is over
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                        }//CHANGE QUESTION:
                        else
                        {
                            txtv.setText(questionsList.get(totalQuestions).getQuestion());
                            b1.setText(questionsList.get(totalQuestions).getAnswer1());
                            b2.setText(questionsList.get(totalQuestions).getAnswer2());
                            b3.setText(questionsList.get(totalQuestions).getAnswer3());
                        }




                    }

                });

        // ----------------------------------BUTTON 2-----------------------------------------------

        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView txtv = findViewById(R.id.textView);
                        Button b3 = findViewById(R.id.button3);
                        Button b2 = findViewById(R.id.button2);
                        Button b1 = findViewById(R.id.button1);

                        //CORRECT ANSWER:
                        if(b2.getText().toString().equalsIgnoreCase(questionsList.get(totalQuestions).getCorrectAnswer()))
                        {
                            if(player2==-1)  scorePlayer1++; //correct answer (player 1)
                            else  scorePlayer2++; //correct answer (player 2)
                        }

                        ++totalQuestions; //increment answered questions

                        //END OF GAME:
                        if (totalQuestions == mode.getQuestion())
                        {
                            if(mode.getPlayers()==1) // if the single player game is over
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                            else if(mode.getPlayers()==2 && player2==-1)//if player 2 should play
                            {
                                Intent intent =new Intent(GameActivity.this, NextActivity.class);
                                intent.putExtra("mode", mode);
                                intent.putExtra(" scorePlayer1",  scorePlayer1);
                                startActivity(intent);

                            }
                            else if(mode.getPlayers()==2 && player2==1) // if the game is over
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                        }//CHANGE QUESTION:
                        else
                        {
                            txtv.setText(questionsList.get(totalQuestions).getQuestion());
                            b1.setText(questionsList.get(totalQuestions).getAnswer1());
                            b2.setText(questionsList.get(totalQuestions).getAnswer2());
                            b3.setText(questionsList.get(totalQuestions).getAnswer3());
                        }




                    }

                });

        //------------------------------------BUTTON 3----------------------------------------------
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView txtv = findViewById(R.id.textView);
                        Button b3 = findViewById(R.id.button3);
                        Button b2 = findViewById(R.id.button2);
                        Button b1 = findViewById(R.id.button1);

                        //CORRECT ANSWER:
                        if(b3.getText().toString().equalsIgnoreCase(questionsList.get(totalQuestions).getCorrectAnswer()))
                        {
                            if(player2==-1)  scorePlayer1++; //correct answer (player 1)
                            else  scorePlayer2++; //correct answer (player 2)
                        }

                        ++totalQuestions; //increment answered questions

                        //END OF GAME:
                        if (totalQuestions == mode.getQuestion())
                        {
                            if(mode.getPlayers()==1) // if the single player game is over
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                            else if(mode.getPlayers()==2 && player2==-1) //if player 2 should play
                            {
                                Intent intent =new Intent(GameActivity.this, NextActivity.class);
                                intent.putExtra("mode", mode);
                                intent.putExtra(" scorePlayer1",  scorePlayer1);
                                startActivity(intent);

                            }
                            else if(mode.getPlayers()==2 && player2==1) // if the game is over
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                        }//CHANGE QUESTION:
                        else
                        {
                            txtv.setText(questionsList.get(totalQuestions).getQuestion());
                            b1.setText(questionsList.get(totalQuestions).getAnswer1());
                            b2.setText(questionsList.get(totalQuestions).getAnswer2());
                            b3.setText(questionsList.get(totalQuestions).getAnswer3());
                        }




                    }

                });


    }





}