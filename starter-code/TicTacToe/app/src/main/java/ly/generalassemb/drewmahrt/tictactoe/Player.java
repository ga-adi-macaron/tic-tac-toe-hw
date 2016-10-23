package ly.generalassemb.drewmahrt.tictactoe;

import java.util.LinkedList;

/**
 * Created by Joe on 10/21/16.
 */

public class Player {
    private String mName;
    private boolean isWinner;
    private int mGameNumber;
    private LinkedList<Coordinate> mItemPlaced;

    public Player(String name) {
        mName = name;
        isWinner =false;
        mItemPlaced = new LinkedList<>();
    }
    public void addItem(Coordinate coordinate){
        mItemPlaced.add(coordinate);
    }

    public LinkedList<Coordinate> getItemPlaced() {
        return mItemPlaced;
    }

    public int getGameNumber() {
        return mGameNumber;
    }

    public void setGameNumber(int gameNumber) {
        mGameNumber = gameNumber;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
