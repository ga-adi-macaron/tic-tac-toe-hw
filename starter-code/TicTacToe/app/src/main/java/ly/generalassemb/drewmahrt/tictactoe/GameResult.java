package ly.generalassemb.drewmahrt.tictactoe;

import android.util.Log;

/**
 * Created by NikitaShuvalov on 10/23/16.
 */

public class GameResult {
    private String mp1Name, mp2Name, mWinner;
    private int[] mGameState;
    private int mGameID;

    public GameResult(String p1Name, String p2Name, String winner, String gameStateText, int gameID){
        mp1Name = p1Name;
        mp2Name = p2Name;
        mWinner = winner;
        mGameState = stringIntToIntArray(gameStateText);
        mGameID = gameID;
    }

    //Changes gamestate from text to int array. Since SQL can't hold arrays,
    //I held the array as an int string. This changes it back to an array.
    public static int[] stringIntToIntArray(String stringInt){
        int[] intArray = new int[9];
        char[] charArray = stringInt.toCharArray();
        for (int i =0; i<9; i++) {
            intArray[i]= Integer.valueOf(charArray[i])-48;
            //Thought that I could just change a char '0' to int 0, but I found that's not exactly how it works.
            // Subtracted 48 from the resulting value to get the intended value.
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
    public int getGameID(){
        return mGameID;
    }

}
