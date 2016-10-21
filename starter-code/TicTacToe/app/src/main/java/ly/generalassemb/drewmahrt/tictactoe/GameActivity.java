package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import static ly.generalassemb.drewmahrt.tictactoe.MainActivity.PLAYER_ONE_KEY;
import static ly.generalassemb.drewmahrt.tictactoe.MainActivity.PLAYER_TWO_KEY;
import static ly.generalassemb.drewmahrt.tictactoe.MainActivity.WINNER_RESULT_KEY;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mTopText;
    private String mPlayer1Name;
    private String mPlayer2Name;
    private boolean mIsPlayerOneTurn;
    private ArrayList<Integer> mPlayer1Choices;
    private ArrayList<Integer> mPlayer2Choices;
    private final int[][] mWinningCombinations = {
            {1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}
    };

    @Override
    public void onClick(View view) {
        TextView selectedView = (TextView) view;
        if(mIsPlayerOneTurn){
            selectedView.setText("X");
            mPlayer1Choices.add((Integer) view.getTag());
            mIsPlayerOneTurn = false;
            mTopText.setText(mPlayer2Name+"'s turn");
        }else{
            selectedView.setText("O");
            mPlayer2Choices.add((Integer) view.getTag());
            mIsPlayerOneTurn = true;
            mTopText.setText(mPlayer2Name+"'s turn");
        }

        if(checkForWin()){

        }

        selectedView.setClickable(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent receivedIntent = getIntent();
        mPlayer1Name = receivedIntent.getStringExtra(PLAYER_ONE_KEY);
        mPlayer2Name = receivedIntent.getStringExtra(PLAYER_TWO_KEY);

        mTopText = (TextView)findViewById(R.id.game_message_text);
        mTopText.setText(mPlayer1Name+"'s turn");

        mIsPlayerOneTurn = true;
        mPlayer1Choices = new ArrayList<>();
        mPlayer2Choices = new ArrayList<>();


    }

    public boolean checkForWin(){
        for (int i=0; i<mWinningCombinations.length; i++){
            if(mPlayer1Choices.contains(mWinningCombinations[i][0])
                &&mPlayer1Choices.contains(mWinningCombinations[i][1])
                &&mPlayer1Choices.contains(mWinningCombinations[i][2])){
                Intent resultIntent = new Intent();
                resultIntent.putExtra(WINNER_RESULT_KEY, mPlayer1Name);
                setResult(RESULT_OK, resultIntent);

                mTopText.setText(mPlayer1Name+" wins!");
                return true;
            }else if(mPlayer2Choices.contains(mWinningCombinations[i][0])
                    &&mPlayer2Choices.contains(mWinningCombinations[i][1])
                    &&mPlayer2Choices.contains(mWinningCombinations[i][2])){
                Intent resultIntent = new Intent();
                resultIntent.putExtra(WINNER_RESULT_KEY, mPlayer2Name);
                setResult(RESULT_OK, resultIntent);

                mTopText.setText(mPlayer2Name+" wins!");
                return true;
            }
        }
        return false;
    }
}
