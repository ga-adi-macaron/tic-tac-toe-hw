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
    Button button;
    EditText playerName, player2Name;
    TextView previousWinner;
    public static final int GAME_PAGE = 138;
    String winner = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.start_game_button);
        playerName = (EditText) findViewById(R.id.player_one_name);
        player2Name = (EditText) findViewById(R.id.player_two_name);
        previousWinner = (TextView) findViewById(R.id.last_winner_text);
        previousWinner.setText("Previous Winner: " + winner);
        final Intent intent = new Intent(MainActivity.this, GameActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String player1 = getPlayerName(playerName);
                    intent.putExtra("playerOne", player1);

                String player2 = getPlayerName(player2Name);
                    intent.putExtra("playerTwo", player2);

                startActivityForResult(intent, GAME_PAGE);

            }
        });

        previousWinner.setText("Previous Winner: " + winner);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GAME_PAGE) {
            if (resultCode == RESULT_OK) {
                winner = data.getStringExtra("winner");
                previousWinner.setText("Previous Winner :\n" + winner);
            }
        }
    }



    public String getPlayerName (EditText name) {
        return name.getText().toString();
    }
}
