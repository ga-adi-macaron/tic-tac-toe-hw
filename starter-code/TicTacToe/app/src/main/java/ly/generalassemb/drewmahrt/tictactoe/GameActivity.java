package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;
    TextView mTextView7;
    TextView mTextView8;
    TextView mTextView9;
    int mTurn = 0;
    String mLetter = "";
    Boolean win = false;

    public void whoseTurn() {
        if (mTurn % 2 == 0) {
            mLetter = "X";
        } else mLetter = "O";
    }

    public void resultWin() {
        if (win == true) {
            Toast.makeText(this, "GAME WON!", Toast.LENGTH_SHORT).show();
        }
    }

    CountDownTimer timer = new CountDownTimer(10,10) {
        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            winCondition();
            Toast.makeText(GameActivity.this, "Result " + win, Toast.LENGTH_SHORT).show();
        }
    };


    public void winCondition() {
        //horizontalwins
        if( mTextView1.getText() == mTextView2.getText() &&
                mTextView2.getText() == mTextView3.getText() && mTextView1.getText() != ""){
            win = true;
        }
        else if(mTextView4.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView6.getText() && mTextView4.getText() != ""){
            win = true;
        }
        else if(mTextView7.getText() == mTextView8.getText() &&
                mTextView8.getText() == mTextView9.getText() && mTextView7.getText() != ""){
            win = true;
        }

        //verticle wins
        else if(mTextView1.getText() == mTextView4.getText() &&
                mTextView4.getText() == mTextView7.getText() && mTextView1.getText() != ""){
            win = true;
        }
        else if(mTextView2.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView8.getText() && mTextView2.getText() != ""){
            win = true;
        }
        else if(mTextView3.getText() == mTextView6.getText() &&
                mTextView6.getText() == mTextView9.getText() && mTextView3.getText() != ""){
            win = true;
        }

        //diagonal wins
        else if(mTextView1.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView9.getText() && mTextView1.getText() != ""){
            win = true;
        }
        else if(mTextView3.getText() == mTextView5.getText() &&
                mTextView5.getText() == mTextView7.getText() && mTextView3.getText() != ""){
            win = true;
        }
        else {
            win = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String userName1 = intent.getStringExtra("Username1");
        String userName2 = intent.getStringExtra("Username2");

        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mTextView5 = (TextView) findViewById(R.id.textView5);
        mTextView6 = (TextView) findViewById(R.id.textView6);
        mTextView7 = (TextView) findViewById(R.id.textView7);
        mTextView8 = (TextView) findViewById(R.id.textView8);
        mTextView9 = (TextView) findViewById(R.id.textView9);

        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
        mTextView5.setOnClickListener(this);
        mTextView6.setOnClickListener(this);
        mTextView7.setOnClickListener(this);
        mTextView8.setOnClickListener(this);
        mTextView9.setOnClickListener(this);

        whoseTurn();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView1:
                if (mTextView1.getText() == "") {
                    mTurn++;
                    mTextView1.setText(mLetter);
                    timer.start();
                }
                break;
            case R.id.textView2:
                if (mTextView2.getText() == "") {
                    mTurn++;
                    mTextView2.setText(mLetter);
                    timer.start();
                }
                break;
            case R.id.textView3:
                mTextView3.setText("X");
                timer.start();
                break;

        }

    }
}
