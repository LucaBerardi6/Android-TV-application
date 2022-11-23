# Android-TV-application
Prototype of an application based on the Android TV platform.

## Abstract
The prototype created is a quiz game, in which questions are asked to be answered correctly. The user can choose one of the following two game modes:

•  <strong>Single player:</strong> You can play alone on your TV. The user is asked a series of questions and, for each of them, he must select, among the three options proposed, the one he deems correct. Only at the end of the game, after having answered all the questions, the user gets a score based on the correct answers given during the game.

•  <strong>Two Players:</strong>  You can play on the same TV with someone else. Players are asked the same number of questions and, as with the previous mode, the answer options are three, but the right one is only one.

For each of the two modes there are three types of challenges:

• game with five questions
• game with ten questions
• game with fifteen questions

## Development
The application was developed using four Activities:

• [MainActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/MainActivity.java): the launch Activity which represents the main screen of the application where it is possible to choose the game mode and the type of challenge.

• [GameActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/GameActivity.java): the Activity that represents the game screen. The user interacts with the application by answering the questions, selecting the option he deems correct.

• [NextActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/NextActivity.java): the Activity used when the challenge between two players is chosen. The second player is invited to prepare, as he is about to start his turn.

• [EndActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/EndActivity.java): the Activity used at the end of each game. The outcome of the game is displayed on the user interface and it is possible to start the MainActivity to play a new game.
