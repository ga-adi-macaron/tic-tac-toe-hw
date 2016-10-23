package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView mMessage;
    ArrayList<TextView> mSq = new ArrayList<>();
    int i;
    String p1, p2;
    String x;
    String o;
    String mWinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        x = "X";
        o = "O";
        i = 0;

        Intent iFrom = getIntent();
        p1 = iFrom.getStringExtra("1");
        p2 = iFrom.getStringExtra("2");

        mSq.add((TextView) findViewById(R.id.textView));
        mSq.add((TextView) findViewById(R.id.textView2));
        mSq.add((TextView) findViewById(R.id.textView3));
        mSq.add((TextView) findViewById(R.id.textView4));
        mSq.add((TextView) findViewById(R.id.textView5));
        mSq.add((TextView) findViewById(R.id.textView6));
        mSq.add((TextView) findViewById(R.id.textView7));
        mSq.add((TextView) findViewById(R.id.textView8));
        mSq.add((TextView) findViewById(R.id.textView9));

        mMessage = (TextView)findViewById(R.id.game_message_text);
        mMessage.setText("It is " + p1 + "'s turn! (X)");

        mWinner = p1;

        Intent sendBack = new Intent();

    }



    public void clickThatButton(View v){
        if(i % 2 == 0){
            if(((TextView)findViewById(v.getId())).getText().toString().equals("")) {
                ((TextView) findViewById(v.getId())).setText(x);
                checkForWinner();
                mMessage.setText("It is " + p2 + "'s turn! (O)");
                i++;

            }
        }
        else{
            if(((TextView)findViewById(v.getId())).getText().toString().equals("")){
                ((TextView)findViewById(v.getId())).setText(o);
                checkForWinner();
                mMessage.setText("It is " + p1 + "'s turn! (X)");
                i++;
            }
        }
    }

    public void checkForWinner(){
          if(getMove(0,1,2,x)){
            xWin();
        } if(getMove(3,4,5,x)){
            xWin();
        } if(getMove(6,7,8,x)){
            xWin();
        } if(getMove(0,3,6,x)){
            xWin();
        } if(getMove(1,4,7,x)){
            xWin();
        } if(getMove(2,5,8,x)){
            xWin();
        } if(getMove(0,4,8,x)){
            xWin();
        } if(getMove(6,4,2,x)){
            xWin();
        } if(getMove(0,1,2,o)){
            oWin();
        } if(getMove(3,4,5,o)){
            oWin();
        } if(getMove(6,7,8,o)){
            oWin();
        } if(getMove(0,3,6,o)){
            oWin();
        } if(getMove(1,4,7,o)){
            oWin();
        } if(getMove(2,5,8,o)){
            oWin();
        } if(getMove(0,4,8,o)){
            oWin();
        } if(getMove(6,4,2,o)){
            oWin();
        }

        checkForTie();

        }


    public void checkForTie() {
        for (int j = 0; j < 9; j++) {
            if (mSq.get(j).getText().toString().equals("")) {
                return;
            }
        }
        tie();
    }


    public boolean getMove(int p, int q, int r, String s){
        if(mSq.get(p).getText().toString().equals(s)
                && mSq.get(q).getText().toString().equals(s)
                && mSq.get(r).getText().toString().equals(s)){
            Toast.makeText(this, "GAME DONE", Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            return false;
        }
    }

    public void oWin(){
        mWinner = p2;
        finish();
    }

    public void xWin(){
        mWinner = p1;
        finish();
    }
    public void tie(){
        mWinner = "IT WAS A TIE!";
        finish();
    }
}









