package ly.generalassemb.drewmahrt.tictactoe;

/**
 * Created by Joe on 10/21/16.
 */

public class Player {
    private String mName;
    private boolean isWinnter;
    private int mGameNumber,mPlayerNumber;

    public Player(String name, int gameNumber) {
        mName = name;
        isWinnter=false;
        mGameNumber = gameNumber;
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

    public boolean isWinnter() {
        return isWinnter;
    }

    public void setWinnter(boolean winnter) {
        isWinnter = winnter;
    }
}
