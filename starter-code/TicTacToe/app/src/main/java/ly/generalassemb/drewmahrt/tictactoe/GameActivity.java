package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    TextView mTurn;
    TextView mBox, mBox2, mBox3, mBox4,
            mBox5, mBox6, mBox7, mBox8, mBox9;
    String mPlayer1, mPlayer2;
    boolean mNextTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTurn = (TextView) findViewById(R.id.game_message_text);
        mBox = (TextView) findViewById(R.id.textView);
        mBox2 = (TextView) findViewById(R.id.textView2);
        mBox3 = (TextView) findViewById(R.id.textView3);
        mBox4 = (TextView) findViewById(R.id.textView4);
        mBox5 = (TextView) findViewById(R.id.textView5);
        mBox6 = (TextView) findViewById(R.id.textView6);
        mBox7 = (TextView) findViewById(R.id.textView7);
        mBox8 = (TextView) findViewById(R.id.textView8);
        mBox9 = (TextView) findViewById(R.id.textView9);

        // Get the Intent from MainActivity
        Intent intent = getIntent();
        mPlayer1 = intent.getStringExtra("Player1");
        mPlayer2 = intent.getStringExtra("Player2");
        mTurn.setText(mPlayer1 + "'s Turn");

        // OnClickListener for each Box
        mNextTurn = true;
        View.OnClickListener onClickListener = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pick = (TextView) v;
                if (pick.getText().toString().isEmpty()){
                    if (mNextTurn){
                        pick.setText("X");
                        mNextTurn = false;
                        mTurn.setText(mPlayer2 + "'s Turn");
                    } else {
                        pick.setText("O");
                        mNextTurn = true;
                        mTurn.setText(mPlayer1 + "'s Turn");
                    }
                } else {
                    Toast.makeText(GameActivity.this, "This spot has already been filled!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBox.setOnClickListener(onClickListener);
        mBox2.setOnClickListener(onClickListener);
        mBox3.setOnClickListener(onClickListener);
        mBox4.setOnClickListener(onClickListener);
        mBox5.setOnClickListener(onClickListener);
        mBox6.setOnClickListener(onClickListener);
        mBox7.setOnClickListener(onClickListener);
        mBox8.setOnClickListener(onClickListener);
        mBox9.setOnClickListener(onClickListener);

    }
}
