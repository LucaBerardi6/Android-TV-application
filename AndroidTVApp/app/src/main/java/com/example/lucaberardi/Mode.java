package com.example.lucaberardi;

import java.io.Serializable;

public class Mode implements Serializable {
    static final long serialVersionUID = 727566175075960653L;
    private String title; //titolo
    private String description; //descrizione
    private int players; //numero di giocatori
    private int question; // numero di domande
    private int image; //immagine


    public Mode() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getPlayers() {
        return players;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getQuestion() {
        return question;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Mode{" +
                " title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", players='" + players + '\'' +
                '}';
    }
}