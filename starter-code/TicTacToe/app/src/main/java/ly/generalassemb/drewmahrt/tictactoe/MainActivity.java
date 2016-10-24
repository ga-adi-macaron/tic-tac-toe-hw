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
    EditText mPlayer1, mPlayer2;
    Button mButton;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer1 = (EditText) findViewById(R.id.player_one_name);
        mPlayer2 = (EditText) findViewById(R.id.player_two_name);
        mButton = (Button) findViewById(R.id.start_game_button);
        mTextView = (TextView) findViewById(R.id.last_winner_text);

        // OnClick Button to create an Intent from MainActivity to GameActivity
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(MainActivity.this, GameActivity.class);
                game.putExtra("Player1", mPlayer1.getText().toString());
                game.putExtra("Player2", mPlayer2.getText().toString());
                startActivity(game);
            }
        });
    }
}
