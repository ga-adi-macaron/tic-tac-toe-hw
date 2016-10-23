package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mPlayer1Name;

    private EditText mPlayer2Name;

    private Button mStartButton;

    public static final int REQUEST = 61;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer1Name = (EditText) findViewById(R.id.player_one_name);
        mPlayer2Name = (EditText) findViewById(R.id.player_two_name);
        mStartButton = (Button) findViewById(R.id.start_game_button);


        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayer1Name.getText().toString().isEmpty()) {
                    mPlayer1Name.setError("Please Enter Name for Player 1");
                }
                else if (mPlayer2Name.getText().toString().isEmpty()){
                    mPlayer2Name.setError("Please Enter Name for Player 2");
                }
                else{
                    Intent startGameIntent = new Intent(MainActivity.this, GameActivity.class);
                    startGameIntent.putExtra("P1Name", mPlayer1Name.getText().toString());
                    startGameIntent.putExtra("P2Name", mPlayer2Name.getText().toString());
                    startActivityForResult(startGameIntent, REQUEST);
                }
            }
        });
    }
}
