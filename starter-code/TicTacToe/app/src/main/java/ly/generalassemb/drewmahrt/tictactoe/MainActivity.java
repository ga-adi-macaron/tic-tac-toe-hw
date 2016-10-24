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
    private EditText player1, player2;
    Button start;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = (EditText)findViewById(R.id.player_one_name);
        player2 = (EditText)findViewById(R.id.player_two_name);

        start = (Button)findViewById(R.id.start_game_button);

        final Intent intent = new Intent(MainActivity.this, GameActivity.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName1 = player1.getText().toString();
                String playerName2 = player2.getText().toString();
                if(playerName1.length() > 0 && playerName2.length() > 0) {
                    intent.putExtra("PlayerOne", playerName1);
                    intent.putExtra("PlayerTwo", playerName2);
                    startActivityForResult(intent, 5);
                } else {
                    if(playerName1.length() == 0) {
                        player1.setError("required");
                    }
                    if(playerName2.length() == 0) {
                        player2.setError("required");
                    }
                }
            }
        });

        result = (TextView)findViewById(R.id.last_winner_text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 5) {
            if(resultCode == RESULT_OK) {
                result.setText("Previous Winner:\n" + data.getStringExtra("WINNER"));
            }
        }
    }
}
