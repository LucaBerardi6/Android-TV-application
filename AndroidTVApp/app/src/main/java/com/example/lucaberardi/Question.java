 package com.example.lucaberardi;

 /**
  * With the Question class it is possible to associate a question with
  * its correct answer and its incorrect answers.
  * A Question object consists of five variables with their respective Get methods:
  * the question, the correct answer, and the three possible answers.
  */
 public class Question {

    private String question;
    private String correctAnswer;
    private String answer1;
    private String answer2;
    private String answer3;

    public Question(String question, String correctAnswer, String answer1, String answer2, String answer3)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    //--------------GET METHODS:-----------------------

    /** Returns the question. */
    public String getQuestion() {
        return question;
    }

    /** Returns the Correct Answer. */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /** Returns the first answer. */
    public String getAnswer1() {
        return answer1;
    }

    /** Returns the second answer. */
    public String getAnswer2() {
        return answer2;
    }

    /** Returns the third answer. */
    public String getAnswer3() {
        return answer3;
    }

}
