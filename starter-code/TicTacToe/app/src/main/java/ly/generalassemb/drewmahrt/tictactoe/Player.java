package ly.generalassemb.drewmahrt.tictactoe;

import java.util.LinkedList;

/**
 * Created by Joe on 10/21/16.
 */

public class Player {
    private String mName;
    private LinkedList<Coordinate> mItemPlaced;

    public Player(String name) {
        mName = name;
        mItemPlaced = new LinkedList<>();
    }

    public void addItem(Coordinate coordinate){
        mItemPlaced.add(coordinate);
    }

    public LinkedList<Coordinate> getItemPlaced() {
        return mItemPlaced;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
