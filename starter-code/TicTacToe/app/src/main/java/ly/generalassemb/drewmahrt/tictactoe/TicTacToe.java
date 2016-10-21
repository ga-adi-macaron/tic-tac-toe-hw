package ly.generalassemb.drewmahrt.tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Joe on 10/21/16.
 */
public class TicTacToe {
    private static TicTacToe ourInstance = new TicTacToe();
    private boolean isFinished;
    private static ArrayList<Coordinate> mCoordinate;
    private static LinkedList<Player> mPlayerWon;
    private String mPlayer1,mPlayer2;

    public static TicTacToe getInstance() {
        return ourInstance;
    }

    private TicTacToe() {
        mCoordinate = new ArrayList<>();
        mPlayerWon= new LinkedList<>();
        isFinished = false;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public static LinkedList<Player> getmPlayerWon() {
        return mPlayerWon;
    }

    public String getPlayer1() {
        return mPlayer1;
    }

    public void setPlayer1(String player1) {
        mPlayer1 = player1;
    }

    public String getPlayer2() {
        return mPlayer2;
    }

    public void setPlayer2(String player2) {
        mPlayer2 = player2;
    }

    public void generateGrid(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mCoordinate.add(new Coordinate(i,j));
            }
        }
    }
    public void clearGrid(){
        mCoordinate.clear();
    }
}
