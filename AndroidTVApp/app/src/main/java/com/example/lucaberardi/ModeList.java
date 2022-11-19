package com.example.lucaberardi;

import java.util.ArrayList;
import java.util.List;

public final class ModeList {
    public static final String GAMEMODE[] = {
            "UN GIOCATORE:",
            "DUE GIOCATORI:",

    };

    private static ArrayList<Mode> list;


    public static ArrayList<Mode> getList() {
        if (list == null) {
            list = setupMode();
        }
        return list;
    }

    public static ArrayList<Mode> setupMode() {
        list = new ArrayList<>();
        String title[] = {
                "5 DOMANDE", "10 DOMANDE","15 DOMANDE",
                "5 DOMANDE", "10 DOMANDE", "15 DOMANDE",
        };


        String description[] = {
                "Modalità singolo giocatore",  "Modalità singolo giocatore",  "Modalità singolo giocatore",
                "Sfida un amico", "Sfida un amico","Sfida un amico"
        };

        int players[] = {
                1, 1, 1,
                2, 2, 2,
        };

        int question[] = {
               5, 10, 15,
                5, 10, 15
        };

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