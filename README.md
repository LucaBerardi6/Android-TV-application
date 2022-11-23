# Android-TV-application
Prototype of an application based on the Android TV platform.

## Abstract
The prototype created is a quiz game, in which questions are asked to be answered correctly. The user can choose one of the following two game modes:

•  <strong>Single player:</strong> You can play alone on your TV. The user is asked a series of questions and, for each of them, he must select, among the three options proposed, the one he deems correct. Only at the end of the game, after having answered all the questions, the user gets a score based on the correct answers given during the game.

•  <strong>Two Players:</strong>  You can play on the same TV with someone else. Players are asked the same number of questions and, as with the previous mode, the answer options are three, but the right one is only one.

For each of the two modes there are three types of challenges:

• game with five questions <br>
• game with ten questions <br>
• game with fifteen questions <br>

## Development
The application was developed using four Activities:

• [MainActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/MainActivity.java): the launch Activity which represents the main screen of the application where it is possible to choose the game mode and the type of challenge.
The [MainFragment](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/MainFragment.java) class is used to create the layout.
The [CardPresenter](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/CardPresenter.java) class was used to create each of the home cards. With this class it is possible to create a View associated with the game mode.

• [GameActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/GameActivity.java): the Activity that represents the game screen. The user interacts with the application by answering the questions, selecting the option he deems correct.

• [NextActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/NextActivity.java): the Activity used when the challenge between two players is chosen. The second player is invited to prepare, as he is about to start his turn.

• [EndActivity](https://github.com/LucaBerardi6/Android-TV-application/blob/main/AndroidTVApp/app/src/main/java/com/example/lucaberardi/EndActivity.java): the Activity used at the end of each game. The outcome of the game is displayed on the user interface and it is possible to start the MainActivity to play a new game.


## Screenshots of the app
Some screenshots from the app (to see other screenshots go to the dir [Images](https://github.com/LucaBerardi6/Android-TV-application/tree/main/Images)):
<p align="center">
  <img  height="500" width="800" alt="GIF" src="https://github.com/LucaBerardi6/Android-TV-application/blob/main/Images/video.gif">
  </p>
  </br> 
<p align="center">
  <img src="Images/home.png" style="width:800px;height:500px" > 
  </p>
  </br> 
  <p align="center">
   <img src="Images/game.png" style="width:800px;height:500px"> 
</p>
  </br> 
  <p align="center">
  <img src="Images/SinglePlayer.png" style="width:800px;height:500px"> 
 </p>
  </br>
 <p align="center">
  <img src="Images/2Players.png" style="width:800px;height:500px"> 
</p>



