package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText mPlayerOneEdit, mPlayerTwoEdit;
    Button mPlay;
    TextView mLastWinnter;
    String mP1, mP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference
        mPlayerOneEdit = (EditText) findViewById(R.id.player_one_name);
        mPlayerTwoEdit = (EditText) findViewById(R.id.player_two_name);
        mPlay = (Button) findViewById(R.id.start_game_button);
        mLastWinnter = (TextView) findViewById(R.id.last_winner_text);



        //Clicking button, get text from EditTexts if they're not blank
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mP1 = mPlayerOneEdit.getText().toString();
                mP2 = mPlayerTwoEdit.getText().toString();

                if(mP1.trim().equals("")) {
                    mPlayerOneEdit.setError("HI");
                }
                if(mP2.trim().equals("")) {
                    mPlayerTwoEdit.setError("Hello");
                }

                if(mP1.trim().equals("")||mP2.trim().equals("")) {

                }
                else{
                    Intent i = new Intent(MainActivity.this, GameActivity.class);
                    i.putExtra("1", mP1);
                    i.putExtra("2", mP2);
                    startActivityForResult(i,1);
                    }
                }
            });


            //Recieve data from the game after it's over
        onActivityResult();


        }
}
