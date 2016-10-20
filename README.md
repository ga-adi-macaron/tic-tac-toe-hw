---
title: Tic-Tac-Toe
type: Homework
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Tic-Tac-Toe

> ***Note:*** _You can help each other, but everyone must submit their own code._

## Exercise

In this exercise, you will be creating [tic-tac-toe](https://en.wikipedia.org/wiki/Tic-tac-toe)! The app will consist of two activities. The first activity is the main menu where both players enter their names, and the winner of the last game is displayed.

The second activity is the game itself. It has text that displays whose turn it currently is, and who the winner is once the game is over. Below that is the game board, where each player touches a square to place their letter.

You'll need to send data via an Intent, and pass data back as a result. Please review the [Activities & Intents lesson](https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activities-and-intents-lesson) for a reminder of how to accomplish these two tasks. The sample code there will be a good example for how to pass data around in this app.

#### Requirements

- Pass the player names from `MainActivity` to `GameActivity` in an Intent.
- Add logic to control the game play in `GameActivity`:
  - For each turn, show at the top of the screen whose turn it is.
  - When a player selects a square, populate it with an "X" or "O" as appropriate.
  - After each turn, check if either player has won.
- When the game is over, display the winner at the top of the screen.
- When the user navigates back to the `MainActivity` by hitting the back button, pass the winner of the game from `GameActivity` to `MainActivity` as a _result_. (You might want to override the `onBackPressed()` method of the activity, but you can do it other ways too.)
- Back in `MainActivity`, retrieve the _result_ in the `onActivityResult()` method, and display it.

**Bonus:**
- Rather than just the one winner of the previous game, show a list of previous winners in a RecyclerView in `MainActivity`, with the most recent winner at the top.


#### Starter code

[Starter code](starter-code) is provided which has the layouts for the two activities completed. The focus of this exercise is on the Java code.

#### Deliverable

Complete the tic-tac-toe game similar to the screenshots below:

<img src="./screenshots/tictactoe1.png" width="300"/>
<img src="./screenshots/tictactoe2.png" width="300"/>
<img src="./screenshots/tictactoe3.png" width="300"/>

## Additional Resources

- [Passing Data with an Intent](https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activities-and-intents-lesson#introduction-sending-data-from-one-activity-to-another-activity-10-mins)
- [Passing Data Back as a Result](https://github.com/ga-adi-macaron/Course-Materials/tree/master/lessons/activities-and-fragments/activities-and-intents-lesson#demo-passing-data-back-in-the-result-20-mins)

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
