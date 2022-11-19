package com.example.lucaberardi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class GameActivity extends Activity {

    private int totalQuestions; //domande a cui l'utente ha risposto
    private int scorePlayer1; //punteggio giocatore 1
    private int scorePlayer2;  //punteggio giocatore 2
    private int player2; //indica il turno del giocatore 2
    private Mode mode;
    private  List<Question> questionsList; //lista con le domande

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //
        Intent intent = getIntent();
        mode = (Mode) intent.getSerializableExtra("mode");
        scorePlayer1= intent.getIntExtra("scorePlayer1",  0); //punteggio giocatore 1
        player2=intent.getIntExtra("player2",-1); // ==1 se è il turno del giocatore 2
        //CREA LISTA DI DOMANDE:
        questionsList = QuestionsList.getQuestionList(mode.getQuestion());
        //
        totalQuestions = 0;
        if(mode.getPlayers()==2)  scorePlayer2=0;
        else  scorePlayer2=-1; //singolo gioctore
        // recupero  riferimento  View per monitorare gli event
        //BUTTON:
        Button b3 = findViewById(R.id.button3);
        Button b2 = findViewById(R.id.button2);
        Button b1 = findViewById(R.id.button1);
        // TEXTVIEW:
        TextView txt = findViewById(R.id.textView);
        //RIEMPI VIEW:
        txt.setText(questionsList.get(totalQuestions).getQuestion());
        b1.setText(questionsList.get(totalQuestions).getAnswer1());
        b2.setText(questionsList.get(totalQuestions).getAnswer2());
        b3.setText(questionsList.get(totalQuestions).getAnswer3());
        //
        //

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                       TextView txtv = findViewById(R.id.textView);
                        Button b3 = findViewById(R.id.button3);
                        Button b2 = findViewById(R.id.button2);
                        Button b1 = findViewById(R.id.button1);

                        //RISPOSTA ESATTA:
                      if(b1.getText().toString().equalsIgnoreCase(questionsList.get(totalQuestions).getCorrectAnswer()))
                        {
                            if(player2==-1)  scorePlayer1++; //risposta esatta gicatore 1
                            else  scorePlayer2++; //risposta esatta giocatore 2
                       }

                        ++totalQuestions; //incremento domande con risposta

                        //FINE PARTITA:
                        if (totalQuestions == mode.getQuestion())
                        {
                            if(mode.getPlayers()==1) // se la partita singolo giocatore è finita
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                            else if(mode.getPlayers()==2 && player2==-1) //se deve giocare il giocatore 2
                            {
                                Intent intent =new Intent(GameActivity.this, NextActivity.class);
                                intent.putExtra("mode", mode);
                                intent.putExtra(" scorePlayer1",  scorePlayer1);
                                startActivity(intent);

                            }
                            else if(mode.getPlayers()==2 && player2==1) // se la partita è finita
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                        }//CAMBIA DOMANDA:
                        else
                        {
                            txtv.setText(questionsList.get(totalQuestions).getQuestion());
                            b1.setText(questionsList.get(totalQuestions).getAnswer1());
                            b2.setText(questionsList.get(totalQuestions).getAnswer2());
                            b3.setText(questionsList.get(totalQuestions).getAnswer3());
                        }




                    }

                });

        // BUTTON 2
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView txtv = findViewById(R.id.textView);
                        Button b3 = findViewById(R.id.button3);
                        Button b2 = findViewById(R.id.button2);
                        Button b1 = findViewById(R.id.button1);

                        //RISPOSTA ESATTA:
                        if(b2.getText().toString().equalsIgnoreCase(questionsList.get(totalQuestions).getCorrectAnswer()))
                        {
                            if(player2==-1)  scorePlayer1++; //risposta esatta gicatore 1
                            else  scorePlayer2++; //risposta esatta giocatore 2
                        }

                        ++totalQuestions; //incremento domande con risposta

                        //FINE PARTITA:
                        if (totalQuestions == mode.getQuestion())
                        {
                            if(mode.getPlayers()==1) // se la partita singolo giocatore è finita
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                            else if(mode.getPlayers()==2 && player2==-1) //se deve giocare il giocatore 2
                            {
                                Intent intent =new Intent(GameActivity.this, NextActivity.class);
                                intent.putExtra("mode", mode);
                                intent.putExtra(" scorePlayer1",  scorePlayer1);
                                startActivity(intent);

                            }
                            else if(mode.getPlayers()==2 && player2==1) // se la partita è finita
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                        }//CAMBIA DOMANDA:
                        else
                        {
                            txtv.setText(questionsList.get(totalQuestions).getQuestion());
                            b1.setText(questionsList.get(totalQuestions).getAnswer1());
                            b2.setText(questionsList.get(totalQuestions).getAnswer2());
                            b3.setText(questionsList.get(totalQuestions).getAnswer3());
                        }




                    }

                });

        // BUTTON 3
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView txtv = findViewById(R.id.textView);
                        Button b3 = findViewById(R.id.button3);
                        Button b2 = findViewById(R.id.button2);
                        Button b1 = findViewById(R.id.button1);

                        //RISPOSTA ESATTA:
                        if(b3.getText().toString().equalsIgnoreCase(questionsList.get(totalQuestions).getCorrectAnswer()))
                        {
                            if(player2==-1)  scorePlayer1++; //risposta esatta gicatore 1
                            else  scorePlayer2++; //risposta esatta giocatore 2
                        }

                        ++totalQuestions; //incremento domande con risposta

                        //FINE PARTITA:
                        if (totalQuestions == mode.getQuestion())
                        {
                            if(mode.getPlayers()==1) // se la partita singolo giocatore è finita
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                            else if(mode.getPlayers()==2 && player2==-1) //se deve giocare il giocatore 2
                            {
                                Intent intent =new Intent(GameActivity.this, NextActivity.class);
                                intent.putExtra("mode", mode);
                                intent.putExtra(" scorePlayer1",  scorePlayer1);
                                startActivity(intent);

                            }
                            else if(mode.getPlayers()==2 && player2==1) // se la partita è finita
                            {
                                Intent newActivity = new Intent(GameActivity.this, EndActivity.class);
                                newActivity.putExtra(" scorePlayer1",  scorePlayer1);
                                newActivity.putExtra(" scorePlayer2",  scorePlayer2);
                                startActivity(newActivity);
                            }
                        }//CAMBIA DOMANDA:
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