package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String PLAYER_ONE_MARK = "X";
    private static final String PLAYER_TWO_MARK = "O";

    private boolean mIsPlayerOnesTurn = true;
    private boolean mGameIsOver = false;

    private String mPlayerOneName, mPlayerTwoName, mResult;

    private TextView mGameMessage;
    private TextView mRow1Cell1, mRow1Cell2, mRow1Cell3;
    private TextView mRow2Cell1, mRow2Cell2, mRow2Cell3;
    private TextView mRow3Cell1, mRow3Cell2, mRow3Cell3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get player names that were sent over from MainActivity
        Intent intent = getIntent();
        mPlayerOneName = intent.getStringExtra(MainActivity.PLAYER_ONE_NAME_KEY);
        mPlayerTwoName = intent.getStringExtra(MainActivity.PLAYER_TWO_NAME_KEY);

        // Can't play game if either player name is null
        if (mPlayerOneName == null) {
            Log.e("GameActivity", "onCreate: player one name is null");
            finish();
        }
        else if (mPlayerTwoName == null) {
            Log.e("GameActivity", "onCreate: player two name is null");
            finish();
        }

        // Initialize TextView references
        mGameMessage = (TextView) findViewById(R.id.game_message_text);
        mRow1Cell1 = (TextView) findViewById(R.id.textView);
        mRow1Cell2 = (TextView) findViewById(R.id.textView2);
        mRow1Cell3 = (TextView) findViewById(R.id.textView3);
        mRow2Cell1 = (TextView) findViewById(R.id.textView4);
        mRow2Cell2 = (TextView) findViewById(R.id.textView5);
        mRow2Cell3 = (TextView) findViewById(R.id.textView6);
        mRow3Cell1 = (TextView) findViewById(R.id.textView7);
        mRow3Cell2 = (TextView) findViewById(R.id.textView8);
        mRow3Cell3 = (TextView) findViewById(R.id.textView9);

        // Use this class as the on-click listener
        mRow1Cell1.setOnClickListener(this);
        mRow1Cell2.setOnClickListener(this);
        mRow1Cell3.setOnClickListener(this);
        mRow2Cell1.setOnClickListener(this);
        mRow2Cell2.setOnClickListener(this);
        mRow2Cell3.setOnClickListener(this);
        mRow3Cell1.setOnClickListener(this);
        mRow3Cell2.setOnClickListener(this);
        mRow3Cell3.setOnClickListener(this);

        // Start out with player one
        mIsPlayerOnesTurn = true;
        setTurnMessage();
    }

    @Override
    public void onClick(View v) {
        // Use a switch in case we ever want to add this as a click listener for any other views
        switch (v.getId()) {
            case R.id.textView:
            case R.id.textView2:
            case R.id.textView3:
            case R.id.textView4:
            case R.id.textView5:
            case R.id.textView6:
            case R.id.textView7:
            case R.id.textView8:
            case R.id.textView9:
                // Cast v to TextView (since we know it is one) and pass it to a helper method
                handleGameCellClick( (TextView) v );
                break;
            default:
                break;
        }
    }

    private void handleGameCellClick(TextView cell) {
        // Only proceed if the cell isn't already populated, and the game isn't already over
        if (isEmpty(cell) && !mGameIsOver) {

            // Populate the cell with the appropriate mark
            cell.setText(mIsPlayerOnesTurn ? PLAYER_ONE_MARK : PLAYER_TWO_MARK);

            // Check if we have a winner
            if (didSomebodyWin()) {
                mGameIsOver = true;
                if (mIsPlayerOnesTurn) {
                    mResult = mPlayerOneName + " beat " + mPlayerTwoName + "!";
                }
                else {
                    mResult = mPlayerTwoName + " beat " + mPlayerOneName + "!";
                }
            }
            // or if we have a tie
            else if (areAllCellsFull()) {
                mGameIsOver = true;
                mResult = mPlayerOneName + " and " + mPlayerTwoName + " tied";
            }
            // otherwise it's the next player's turn
            else {
                mIsPlayerOnesTurn = !mIsPlayerOnesTurn;
            }

            // Update the message at the top, and set the result if the game is over
            if (mGameIsOver) {
                mGameMessage.setText(mResult);

                Intent intent = new Intent();
                intent.putExtra(MainActivity.RESULT_TEXT_KEY, mResult);
                setResult(RESULT_OK, intent);
            }
            else {
                setTurnMessage();
            }
        }
    }

    private boolean isEmpty(TextView tv) {
        return tv.getText().toString().trim().isEmpty();
    }

    private boolean didSomebodyWin() {
        // Check each row
        boolean gameOver = doThreeCellsMatch(mRow1Cell1, mRow1Cell2, mRow1Cell3);
        gameOver = gameOver || doThreeCellsMatch(mRow2Cell1, mRow2Cell2, mRow2Cell3);
        gameOver = gameOver || doThreeCellsMatch(mRow3Cell1, mRow3Cell2, mRow3Cell3);

        // Check each column
        gameOver = gameOver || doThreeCellsMatch(mRow1Cell1, mRow2Cell1, mRow3Cell1);
        gameOver = gameOver || doThreeCellsMatch(mRow1Cell2, mRow2Cell2, mRow3Cell2);
        gameOver = gameOver || doThreeCellsMatch(mRow1Cell3, mRow2Cell3, mRow3Cell3);

        // Check diagonals
        gameOver = gameOver || doThreeCellsMatch(mRow1Cell1, mRow2Cell2, mRow3Cell3);
        gameOver = gameOver || doThreeCellsMatch(mRow1Cell3, mRow2Cell2, mRow3Cell1);

        return gameOver;
    }

    private boolean doThreeCellsMatch(TextView tv1, TextView tv2, TextView tv3) {
        return !isEmpty(tv1)
                && tv1.getText().equals(tv2.getText())
                && tv2.getText().equals(tv3.getText());
    }

    private boolean areAllCellsFull() {
        return !isEmpty(mRow1Cell1) && !isEmpty(mRow1Cell2) && !isEmpty(mRow1Cell3)
                && !isEmpty(mRow2Cell1) && !isEmpty(mRow2Cell2) && !isEmpty(mRow2Cell3)
                && !isEmpty(mRow3Cell1) && !isEmpty(mRow3Cell2) && !isEmpty(mRow3Cell3);
    }

    private void setTurnMessage() {
        String turnMessage = (mIsPlayerOnesTurn ? mPlayerOneName : mPlayerTwoName) + "'s turn";
        mGameMessage.setText(turnMessage);
    }
}
