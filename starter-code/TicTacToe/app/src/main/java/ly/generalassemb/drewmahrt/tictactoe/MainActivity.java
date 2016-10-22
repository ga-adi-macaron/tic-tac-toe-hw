package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p1EditText, p2EditText;
    Button startGameButton;
    public static final int OUTCOME_CODE = 2369;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1EditText = (EditText)findViewById(R.id.player_one_name);
        p2EditText = (EditText)findViewById(R.id.player_two_name);

        startGameButton = (Button) findViewById(R.id.start_game_button);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1EditText.getText().toString().equals("")){
                    p1EditText.setError("Please input name");
                }
                if(p2EditText.getText().toString().equals("")){
                    p2EditText.setError("Please input name");
                }
                Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
                gameIntent.putExtra("Player1Name", p1EditText.getText().toString());
                gameIntent.putExtra("Player2Name", p2EditText.getText().toString());
                startActivityForResult(gameIntent, OUTCOME_CODE);
            }
        });



    }
}
