package com.example.lucaberardi;

import java.util.ArrayList;
import java.util.List;

/**
 * ModeList provides a list of Modes.
 */
public final class ModeList {
    public static final String GAMEMODE[] = {
            "SINGLE PLAYER:",
            "1 VS 1:",

    };

    /**List of Modes. */
    private static ArrayList<Mode> list;


    /** return the list of Modes. */
    public static ArrayList<Mode> getList() {
        if (list == null) {
            list = setupMode();
        }
        return list;
    }

    /**Initialize the list of Modes.*/
    public static ArrayList<Mode> setupMode() {
        list = new ArrayList<>();

        /**mode title*/
        String title[] = {
                "5 QUESTIONS", "10 QUESTIONS","15 QUESTIONS",
                "5 QUESTIONS", "10 QUESTIONS", "15 QUESTIONS",
        };

        /**Mode description.*/
        String description[] = {
                "Single player mode",  "Single player mode",  "Single player mode",
                "play against a friend", "play against a friend","play against a friend"
        };

        /**Number of players in the mode.*/
        int players[] = {
                1, 1, 1,
                2, 2, 2,
        };

        /**Number of question in the mode.*/
        int question[] = {
               5, 10, 15,
                5, 10, 15
        };

        /**Image used in the main screen for that mode.*/
        int image[] = {
                 R.drawable.ungiocatore,R.drawable.ungiocatore, R.drawable.ungiocatore,
                R.drawable.duegiocatori,R.drawable.duegiocatori, R.drawable.duegiocatori
        };

        for (int index = 0; index < title.length; index++)
        {
            list.add(getMode(title[index], description[index], players[index], question[index],image[index]));
        }

        return list;
    }

    /**Returns the game mode.*/
    private static Mode getMode(String title,String description,int players,int question, int image) {
        Mode mode = new Mode();
        mode.setTitle(title);
        mode.setDescription(description);
        mode.setPlayers(players);
        mode.setQuestion(question);
        mode.setImage(image);
        return mode;
    }
}