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

    /**
     * Check all the possible win condition
     * @return if someone won or lose
     */
    public boolean isWinner() {

        //Row 1
        if ((mItemPlaced.contains(new Coordinate(0))&&
                mItemPlaced.contains(new Coordinate(1))&&
                mItemPlaced.contains(new Coordinate(2))) ||
        //Row 2
        (mItemPlaced.contains(new Coordinate(10))&&
                mItemPlaced.contains(new Coordinate(11))&&
                mItemPlaced.contains(new Coordinate(12))) ||
        //Row 3
        (mItemPlaced.contains(new Coordinate(2))&&
                mItemPlaced.contains(new Coordinate(21))&&
                mItemPlaced.contains(new Coordinate(22))) ||
        //Column 1
        (mItemPlaced.contains(new Coordinate(0))&&
                mItemPlaced.contains(new Coordinate(10))&&
                mItemPlaced.contains(new Coordinate(20))) ||
        //Column 2
        (mItemPlaced.contains(new Coordinate(1))&&
                mItemPlaced.contains(new Coordinate(11))&&
                mItemPlaced.contains(new Coordinate(21))) ||
        //Column 3
        (mItemPlaced.contains(new Coordinate(2))&&
                mItemPlaced.contains(new Coordinate(12))&&
                mItemPlaced.contains(new Coordinate(22))) ||
        //Diagonal 1
        (mItemPlaced.contains(new Coordinate(0))&&
                mItemPlaced.contains(new Coordinate(11))&&
                mItemPlaced.contains(new Coordinate(22))) ||
        //Diagonal 2
        (mItemPlaced.contains(new Coordinate(2))&&
                mItemPlaced.contains(new Coordinate(11))&&
                mItemPlaced.contains(new Coordinate(20)))) {
            return true;
        }
        return false;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
