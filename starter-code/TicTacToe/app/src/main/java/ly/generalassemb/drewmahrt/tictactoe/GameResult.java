package ly.generalassemb.drewmahrt.tictactoe;

/**
 * Created by NikitaShuvalov on 10/23/16.
 */

public class GameResult {
    private String mp1Name, mp2Name, mWinner;
    private int[] mGameState;

    public GameResult(String p1Name, String p2Name, String winner, String gameStateText){
        mp1Name = p1Name;
        mp2Name = p2Name;
        mWinner = winner;
        mGameState = stringIntToIntArray(gameStateText);
    }

    public int[] stringIntToIntArray(String stringInt){
        int[] intArray = new int[9];
        char[] charArray = stringInt.toCharArray();
        for (int i =0; i<9; i++) {
            intArray[i]= Integer.valueOf(charArray[i]);
        }
        return intArray;
    }

    public String getp1Name() {
        return mp1Name;
    }

    public String getp2Name() {
        return mp2Name;
    }

    public String getWinner() {
        return mWinner;
    }

    public int[] getGameState() {
        return mGameState;
    }

}
