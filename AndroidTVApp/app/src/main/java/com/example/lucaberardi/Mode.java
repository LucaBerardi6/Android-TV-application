package com.example.lucaberardi;

import java.io.Serializable;

/**
 * A Mode is used in conjunction with the CardPresenter class
 * to create the cards visible on the main screen that represent
 * a given challenge for a specific game mode.
 */
public class Mode implements Serializable {
    static final long serialVersionUID = 727566175075960653L;
    private String title;
    private String description;
    private int players; //number of players
    private int question; // number of questions
    private int image;


    public Mode() {
    }

    /**
     *--------------- get and set methods:--------------------------------------------
     * */
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


    /**--------------------------------------------------------------------------*/

    /**Returns a string representation of the mode.*/
    @Override
    public String toString() {
        return "Mode{" +
                " title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", players='" + players + '\'' +
                '}';
    }
}