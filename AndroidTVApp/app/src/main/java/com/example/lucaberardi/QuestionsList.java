package com.example.lucaberardi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionsList {

    private static String questions[] = {
            "Quando è stato presentato ufficialmente Android TV?",
            "Qual è il miglior amico dell'uomo?",
            "Da chi è stata dipinta la Gioconda?",
            "Chi è il protagonista della serie Dragon Ball?",
            "Quando iniziò la seconda guerra modiale?",
            "Qual è la capitale dell'Italia?",
            "Quando è stata scoperta l'America?",
            "Qual è la capitale della Spagna?",
            "In che città si trova il Teatro alla Scala?",
            "Chi è Leopardi?",
            "In quale di questi sport si usa una racchetta?",
            "A quanto equivale un metro?",
            "2+(3*5)=?",
            "Dove si trova il Colosseo?",
            "Da chi è stata dipinta l'Ultima Cena?",
            "Quanti europei ha vinto la nazionale italiana?"

    };

    private static  String correctAnswer[] = {
            "2014",
            "Cane",
            "Da Vinci",
            "Goku",
            "1914",
            "Roma",
            "1492",
            "Madrid",
            "Milano",
            "Un poeta",
            "Tennis",
            "100 cm",
            "17",
            "Roma",
            "Da Vinci",
            "2"

    };

    private static String answer2[] = {
            "2010",
            "Gatto",
            "Giotto",
            "Vegeta",
            "1918",
            "Londra",
            "1500",
            "Barcellona",
            "Roma",
            "Un pittore",
            "Nuoto",
            "1000 cm",
            "100",
            "Napoli",
            "Van Gogh",
            "3"
    };

    private static  String answer3[] = {
            "2012",
            "Coniglio",
            "Picasso",
            "Ghoan",
            "1920",
            "Milano",
            "1592",
            "Valencia",
            "Torino",
            "Un calciatore",
            "Calcio",
            "100 mm",
            "18",
            "Bologna",
            "Monet",
            "1"
    };


    public static List<Question> getQuestionList(int number) {

        List<Question> list = new ArrayList<>();

        Random random= new Random();
        Random random2= new Random();
        List<Integer> duplicate =  new ArrayList<>(); // per verificare che non escano domande uguali in una partita
        int next;

        for (int index = 0; index < number; index++) {

            next= random.nextInt(questions.length); //numero per prendere una domanda casuale
            //domande sempre diverse:
            while(duplicate.contains(next))  next=random.nextInt(questions.length);
            duplicate.add(next);
            //
            //PRENDE 3 RISPOSTE CASUALI:
            int r1= random2.nextInt(3);
            int r2= random2.nextInt(3);
            int r3= random2.nextInt(3);
            while(r2==r1) r2= random2.nextInt(3);
            while(r3==r1 || r3==r2) r3= random2.nextInt(3);

            //MISCHIA LE POSSIBILI RISPOSTE:
            String [] randomQuestion = new String[3];
            randomQuestion[r1]=correctAnswer[next];
            randomQuestion[r2]=answer2[next];
            randomQuestion[r3]=answer3[next];

            //CREA NUOVA DOMANDA:
            Question question = new Question(questions[next],correctAnswer[next],randomQuestion[0],
                                                randomQuestion[2],randomQuestion[1]);
            list.add(question);
        }

        return list;

    }


}