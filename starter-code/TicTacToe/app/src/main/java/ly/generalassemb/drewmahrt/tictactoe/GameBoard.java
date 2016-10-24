package ly.generalassemb.drewmahrt.tictactoe;

import android.widget.TextView;

/**
 * Created by jonlieblich on 10/22/16.
 */

public class GameBoard {
    private String player1Name, player2Name;
    private int[] row1, row2, row3;
    private int turnNumber;
    private boolean gameOver;

    public GameBoard(String p1, String p2) {
        player1Name = p1;
        player2Name = p2;
        turnNumber = 0;
        row1 = new int[]{0, 0, 0};
        row2 = new int[]{0, 0, 0};
        row3 = new int[]{0, 0, 0};
        gameOver = false;
    }

    public String currentPlayer() {
        if(turnNumber%2==0) {
            return player2Name;
        }
        return player1Name;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            row1[i] = 0;
            row2[i] = 0;
            row3[i] = 0;
        }
        turnNumber = 0;
        gameOver = false;
    }

    public void addMove(int x, int y, TextView box) {
        if(turnNumber%2 == 1) {
            switch(y) {
                case 1:
                    row1[x] = 1;
                    break;
                case 2:
                    row2[x] = 1;
                    break;
                case 3:
                    row3[x] = 1;
                    break;
            }
            box.setText("X");
            gameWon();
            turnNumber++;
        } else {
            switch(y) {
                case 1:
                    row1[x] = 2;
                    break;
                case 2:
                    row2[x] = 2;
                    break;
                case 3:
                    row3[x] = 2;
                    break;
            }
            box.setText("O");
            gameWon();
            turnNumber++;
        }
    }

    public void gameWon() {
        if(row1[0] == 1) {
            if(row1[1] == 1&&row1[2] == 1) {
                gameOver = true;
            } else if(row2[0]==1&&row3[0]==1) {
                gameOver = true;
            } else if(row2[1]==1&&row3[2]==1) {
                gameOver = true;
            }
        }
        if(row1[0] == 2) {
            if(row1[1]==2&&row1[2]==2) {
                gameOver = true;
            } else if(row2[0]==2&&row3[0]==2) {
                gameOver = true;
            } else if(row2[1]==2&&row3[2]==2) {
                gameOver = true;
            }
        }
        if(row2[1] == 1) {
            if(row1[1]==1&&row3[1]==1) {
                gameOver = true;
            } else if(row1[2]==1&&row3[0]==1) {
                gameOver = true;
            } else if(row2[0]==1&&row2[2]==1) {
                gameOver = true;
            }
        }
        if(row2[1] == 2) {
            if(row1[1]==2&&row3[1]==2) {
                gameOver = true;
            } else if(row1[2]==2&&row3[0]==2) {
                gameOver = true;
            } else if(row2[0]==2&&row2[2]==2) {
                gameOver = true;
            }
        }
        if(row3[2] == 1) {
            if(row1[2]==1&&row2[2]==1) {
                gameOver = true;
            } else if(row3[0]==1&&row3[1]==1) {
                gameOver = true;
            }
        }
        if(row3[2] == 2) {
            if(row1[2]==2&&row2[2]==2) {
                gameOver = true;
            } else if(row3[0]==2&&row3[1]==2) {
                gameOver = true;
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void stopGame() {
        gameOver = false;
    }
}
