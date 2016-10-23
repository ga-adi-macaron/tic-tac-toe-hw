package ly.generalassemb.drewmahrt.tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Joe on 10/21/16.
 */
public class TicTacToe {
    private static TicTacToe ourInstance = new TicTacToe();
    private static ArrayList<Coordinate> mCoordinate;
    private static LinkedList<Player> mPlayerWon;
    private static Player mPlayer1,mPlayer2;

    public static TicTacToe getInstance() {
        return ourInstance;
    }

    private TicTacToe() {
        mCoordinate = new ArrayList<>();
        mPlayerWon= new LinkedList<>();
    }

    public static void addPlayerWon(Player player){
        mPlayerWon.add(0,player);
    }
    public static LinkedList<Player> getmPlayerWon() {
        return mPlayerWon;
    }

    public Coordinate getCoordinate(int loc){
        return mCoordinate.get(loc);
    }

    public Player getPlayer1() {
        return mPlayer1;
    }

    public void setPlayer1(String name) {
        mPlayer1 = new Player(name);
    }

    public Player getPlayer2() {
        return mPlayer2;
    }

    public void setPlayer2(String name) {
        mPlayer2 = new Player(name);
    }

    /**
     * Check all the possible win condition
     * @return if player won or lose
     */
    public boolean isWinner(Player player){
        LinkedList<Coordinate> coordinates = player.getItemPlaced();
                //Row 1
            if  ( (coordinates.contains(mCoordinate.get(0)) &&
                    coordinates.contains(mCoordinate.get(1)) &&
                    coordinates.contains(mCoordinate.get(2)) ) ||
                //Row 2
                ( coordinates.contains(mCoordinate.get(3)) &&
                        coordinates.contains(mCoordinate.get(4)) &&
                        coordinates.contains(mCoordinate.get(5)) ) ||
                //Row 3
                ( coordinates.contains(mCoordinate.get(6)) &&
                        coordinates.contains(mCoordinate.get(7)) &&
                        coordinates.contains(mCoordinate.get(8)) ) ||
                //Column 1
                ( coordinates.contains(mCoordinate.get(0)) &&
                        coordinates.contains(mCoordinate.get(3)) &&
                        coordinates.contains(mCoordinate.get(6)) ) ||
                //Column 2
                ( coordinates.contains(mCoordinate.get(1)) &&
                        coordinates.contains(mCoordinate.get(4)) &&
                        coordinates.contains(mCoordinate.get(7)) ) ||
                //Column 3
                ( coordinates.contains(mCoordinate.get(2)) &&
                        coordinates.contains(mCoordinate.get(5)) &&
                        coordinates.contains(mCoordinate.get(8)) ) ||
                //Diagonal 1
                ( coordinates.contains(mCoordinate.get(0)) &&
                        coordinates.contains(mCoordinate.get(4)) &&
                        coordinates.contains(mCoordinate.get(8)) ) ||
                //Diagonal 2
                ( coordinates.contains(mCoordinate.get(2)) &&
                        coordinates.contains(mCoordinate.get(4)) &&
                        coordinates.contains(mCoordinate.get(6)) )
                ) {
                return true;
            }
        return false;
    }

    /**
     * Generate new set of grid and players
     */
    public void generateNewGridAndPlayer(){
        mCoordinate.clear();
        mPlayer1.getItemPlaced().clear();
        mPlayer2.getItemPlaced().clear();
        for (int i = 0; i < 30; i+=10) {
            for (int j = 0; j < 3; j++) {
                mCoordinate.add(new Coordinate(i+j));
            }
        }
    }
}
