package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView mMessage;
    //TextView q1,q2,q3,q4,q5,q6,q7,q8,q9;
    //ArrayList<TextView> mSquares;
    int i;
    String p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        i = 0;

        Intent iFrom = getIntent();
        p1 = iFrom.getStringExtra("1");
        p2 = iFrom.getStringExtra("2");

//        mSquares.add((TextView) findViewById(R.id.textView));
//        mSquares.add((TextView) findViewById(R.id.textView2));
//        mSquares.add((TextView) findViewById(R.id.textView3));
//        mSquares.add((TextView) findViewById(R.id.textView4));
//        mSquares.add((TextView) findViewById(R.id.textView5));
//        mSquares.add((TextView) findViewById(R.id.textView6));
//        mSquares.add((TextView) findViewById(R.id.textView7));
//        mSquares.add((TextView) findViewById(R.id.textView8));
//        mSquares.add((TextView) findViewById(R.id.textView9));

        mMessage = (TextView)findViewById(R.id.game_message_text);
        mMessage.setText("It is " + p1 + "'s turn! (X)");

    }

    public void clickThatButton(View v){
        if(i % 2 == 0){
            if(   ((TextView)findViewById(v.getId())).getText().toString().equals("")  ) {


                ((TextView) findViewById(v.getId())).setText("X");
                mMessage.setText("It is " + p2 + "'s turn! (O)");
                i++;
            }
        }
        else{
            if(  ((TextView)findViewById(v.getId())).getText().toString().equals("")   ){
                ((TextView)findViewById(v.getId())).setText("O");
                mMessage.setText("It is " + p1 + "'s turn! (X)");
                i++;
            }


            }

    }
}


//        q1 = (TextView)findViewById(R.id.textView);
//        q2 = (TextView)findViewById(R.id.textView2);
//        q3 = (TextView)findViewById(R.id.textView3);
//        q4 = (TextView)findViewById(R.id.textView4);
//        q5 = (TextView)findViewById(R.id.textView5);
//        q6 = (TextView)findViewById(R.id.textView6);
//        q7 = (TextView)findViewById(R.id.textView7);
//        q8 = (TextView)findViewById(R.id.textView8);
//        q9 = (TextView)findViewById(R.id.textView9);