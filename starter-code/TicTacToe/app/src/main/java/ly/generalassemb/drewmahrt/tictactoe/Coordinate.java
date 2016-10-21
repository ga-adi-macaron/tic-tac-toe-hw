package ly.generalassemb.drewmahrt.tictactoe;

/**
 * Created by Joe on 10/21/16.
 */

public class Coordinate {
    private String mStatus;
    private int mRow, mColumn;

    public Coordinate(int row, int column) {
        mRow = row;
        mColumn = column;
        mStatus = "";
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public int getRow() {
        return mRow;
    }

    public void setRow(int row) {
        mRow = row;
    }

    public int getColumn() {
        return mColumn;
    }

    public boolean isEmpty(){
        return mStatus.isEmpty();
    }

    private String setStatus(int playerNum){
        switch (playerNum){
            case 1:
                return "Circle";
            case 2:
                return "Cross";
            default:
                return "";
        }
    }
}
