package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    Intent gameIntent;
    TicTacToe mTicTacToe;
    int mTurn =1;
    boolean mIsFinished = false;
    TextView mTurnText,mCurrentWinner;
    ImageView mSlot0_0,mSlot0_1,mSlot0_2,mSlot1_0,mSlot1_1,mSlot1_2,mSlot2_0,mSlot2_1,mSlot2_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTicTacToe = TicTacToe.getInstance();
        gameIntent = getIntent();

        //Get player name and generate new players and game
        if (mTurn==1) {
            mTicTacToe.setPlayer1(gameIntent.getStringExtra("player 1"));
            mTicTacToe.setPlayer2(gameIntent.getStringExtra("player 2"));
            mTicTacToe.generateNewGridAndPlayer();
        }

        //Reference
        mTurnText = (TextView) findViewById(R.id.turn_text);
        mCurrentWinner = (TextView) findViewById(R.id.current_winner);
        mSlot0_0 = (ImageView) findViewById(R.id.grid_0_0);
        mSlot0_1 = (ImageView) findViewById(R.id.grid_0_1);
        mSlot0_2 = (ImageView) findViewById(R.id.grid_0_2);
        mSlot1_0 = (ImageView) findViewById(R.id.grid_1_0);
        mSlot1_1 = (ImageView) findViewById(R.id.grid_1_1);
        mSlot1_2 = (ImageView) findViewById(R.id.grid_1_2);
        mSlot2_0 = (ImageView) findViewById(R.id.grid_2_0);
        mSlot2_1 = (ImageView) findViewById(R.id.grid_2_1);
        mSlot2_2 = (ImageView) findViewById(R.id.grid_2_2);

        if (mTurn%2==1){
            mTurnText.setText(mTicTacToe.getPlayer1().getName()+"'s Turn.");
        }

        //GridListener
        mSlot0_0.setOnClickListener(gridListener(mTicTacToe.getCoordinate(0)));
        mSlot0_1.setOnClickListener(gridListener(mTicTacToe.getCoordinate(1)));
        mSlot0_2.setOnClickListener(gridListener(mTicTacToe.getCoordinate(2)));
        mSlot1_0.setOnClickListener(gridListener(mTicTacToe.getCoordinate(3)));
        mSlot1_1.setOnClickListener(gridListener(mTicTacToe.getCoordinate(4)));
        mSlot1_2.setOnClickListener(gridListener(mTicTacToe.getCoordinate(5)));
        mSlot2_0.setOnClickListener(gridListener(mTicTacToe.getCoordinate(6)));
        mSlot2_1.setOnClickListener(gridListener(mTicTacToe.getCoordinate(7)));
        mSlot2_2.setOnClickListener(gridListener(mTicTacToe.getCoordinate(8)));
    }

    public void changeIcon(Coordinate coordinate,ImageView imageView, int turn) {
        if (coordinate.isEmpty()) {

            if ( !(mTicTacToe.isWinner(mTicTacToe.getPlayer1())
                    || mTicTacToe.isWinner(mTicTacToe.getPlayer2()) )
                    ) {
                if (turn % 2 == 1) {
                    imageView.setImageResource(R.drawable.ic_o);
                    coordinate.setStatus(1);
                    mTicTacToe.getPlayer1().addItem(coordinate);
                    mTurnText.setText(mTicTacToe.getPlayer2().getName() + "'s Turn.");
                    mTurn++;
                } else {
                    imageView.setImageResource(R.drawable.ic_x);
                    coordinate.setStatus(2);
                    mTicTacToe.getPlayer2().addItem(coordinate);
                    mTurnText.setText(mTicTacToe.getPlayer1().getName() + "'s Turn.");
                    mTurn++;
                }
            }
        }
    }

    //Use changeIcon for the listener
    public View.OnClickListener gridListener (final Coordinate coordinate){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.grid_0_0:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_0_1:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_0_2:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_1_0:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_1_1:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_1_2:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_2_0:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_2_1:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                    case R.id.grid_2_2:
                        changeIcon(coordinate,(ImageView)v, mTurn);
                        break;
                }
                if (!mIsFinished) {
                    mIsFinished = checkWinner();
                }
            }
        };
        return onClickListener;
    }

    public boolean checkWinner(){
    //Check for win condition or game is done
        if (mTicTacToe.isWinner(mTicTacToe.getPlayer1())) {
            TicTacToe.addPlayerWon(mTicTacToe.getPlayer1());
            mCurrentWinner.setText(mTicTacToe.getPlayer1().getName() + " is the WINNER!!");
            gameIntent.putExtra("winner", mTicTacToe.getPlayer1().getName());
            setResult(RESULT_OK, gameIntent);

        } else if (mTicTacToe.isWinner(mTicTacToe.getPlayer2())) {
            TicTacToe.addPlayerWon(mTicTacToe.getPlayer2());
            mCurrentWinner.setText(mTicTacToe.getPlayer2().getName() + " is the WINNER!!");
            gameIntent.putExtra("winner", mTicTacToe.getPlayer1().getName());
            setResult(RESULT_OK, gameIntent);

        } else if (mTurn==10) {
            mCurrentWinner.setText("It's a TIE.");
        }else{
            return false;
        }
        return true;
    }
}
