package ly.generalassemb.drewmahrt.tictactoe;

/**
 * Created by Joe on 10/21/16.
 */

public class Coordinate {
    private int mStatus;
    private int mRowColumn;

    public Coordinate(int rowColumn) {
        mRowColumn = rowColumn;
        mStatus = 0;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getRowColumn() {
        return mRowColumn;
    }

    public void setRowColumn(int rowColumn) {
        mRowColumn = rowColumn;
    }

    public boolean isEmpty(){
        return mStatus==0;
    }
}
