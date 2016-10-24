package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;
    TextView mTextView7;
    TextView mTextView8;
    TextView mTextView9;
    TextView mGameMessage;
    Button mBackButton;
    int mTurn = 1;
    String mLetter = "";
    String mUserName1;
    String mUsername2;
    Boolean win = false;
    String mWinner = "";

    public void whoseTurn() {
        if (mTurn % 2 == 0) {
            mLetter = "X";
            mGameMessage.setText(mUsername2 + "'s Turn");
        } else {
            mLetter = "O";
            mGameMessage.setText(mUserName1 +"'s Turn");
        }
    }

    public void resultWin() {
        if (win == true) {
            if (mTurn % 2 == 0) {
                mGameMessage.setText(mUserName1 +" WON!");
                mWinner = mUserName1;
                mBackButton.setVisibility(View.VISIBLE);
            } else {
                mGameMessage.setText(mUsername2 +" WON!");
                mWinner = mUsername2;
                mBackButton.setVisibility(View.VISIBLE);
            }
        } else if (mTurn == 10){
            mGameMessage.setText("Round Tie!");
            mWinner = "Round Tie!";
            mBackButton.setVisibility(View.VISIBLE);
        }
    }

    CountDownTimer timer = new CountDownTimer(1, 1) {
        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            winCondition();
            resultWin();
        }
    };

    public void winCondition() {
        //horizontalwins
        if (mTextView1.getText() == mTextView2.getText() &&
                mTextView2.getText() == mTextView3.getText() && mTextView1.getText() != "") {
            win = true;
        } else if (mTextView4.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView6.getText() && mTextView4.getText() != "") {
            win = true;
        } else if (mTextView7.getText() == mTextView8.getText() &&
                mTextView8.getText() == mTextView9.getText() && mTextView7.getText() != "") {
            win = true;
        }

        //verticle wins
        else if (mTextView1.getText() == mTextView4.getText() &&
                mTextView4.getText() == mTextView7.getText() && mTextView1.getText() != "") {
            win = true;
        } else if (mTextView2.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView8.getText() && mTextView2.getText() != "") {
            win = true;
        } else if (mTextView3.getText() == mTextView6.getText() &&
                mTextView6.getText() == mTextView9.getText() && mTextView3.getText() != "") {
            win = true;
        }

        //diagonal wins
        else if (mTextView1.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView9.getText() && mTextView1.getText() != "") {
            win = true;
        } else if (mTextView3.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView7.getText() && mTextView3.getText() != "") {
            win = true;
        } else {
            win = false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        mUserName1 = intent.getStringExtra("Username1");
        mUsername2 = intent.getStringExtra("Username2");

        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mTextView5 = (TextView) findViewById(R.id.textView5);
        mTextView6 = (TextView) findViewById(R.id.textView6);
        mTextView7 = (TextView) findViewById(R.id.textView7);
        mTextView8 = (TextView) findViewById(R.id.textView8);
        mTextView9 = (TextView) findViewById(R.id.textView9);
        mGameMessage = (TextView) findViewById(R.id.game_message_text);
        mBackButton = (Button) findViewById(R.id.backbutton);

        mGameMessage.setText(mUserName1 +"'s Turn");

        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
        mTextView5.setOnClickListener(this);
        mTextView6.setOnClickListener(this);
        mTextView7.setOnClickListener(this);
        mTextView8.setOnClickListener(this);
        mTextView9.setOnClickListener(this);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Winner", mWinner);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (win == false) {
        switch (view.getId()) {
                case R.id.textView1:
                    if (mTextView1.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView1.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView2:
                    if (mTextView2.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView2.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView3:
                    if (mTextView3.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView3.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView4:
                    if (mTextView4.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView4.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView5:
                    if (mTextView5.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView5.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView6:
                    if (mTextView6.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView6.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView7:
                    if (mTextView7.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView7.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView8:
                    if (mTextView8.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView8.setText(mLetter);
                        timer.start();
                    }
                    break;
                case R.id.textView9:
                    if (mTextView9.getText() == "") {
                        mTurn++;
                        whoseTurn();
                        mTextView9.setText(mLetter);
                        timer.start();
                    }
                    break;
            }
        }
    }
}
