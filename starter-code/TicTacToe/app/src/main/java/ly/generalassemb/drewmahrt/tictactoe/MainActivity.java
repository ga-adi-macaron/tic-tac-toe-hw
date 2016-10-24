package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    private static final int NAME_REQUEST = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.start_game_button);
        mTextView = (TextView) findViewById(R.id.last_winner_text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);

                EditText user1 = (EditText) findViewById(R.id.player_one_name);
                String userName1 = user1.getText().toString();
                if (userName1.isEmpty()) {
                    user1.setError("Can't be empty!");
                }

                EditText user2 = (EditText) findViewById(R.id.player_two_name);
                String userName2 = user2.getText().toString();
                if (userName2.isEmpty()) {
                    user2.setError("Can't be empty!");
                }

                intent.putExtra("Username1", userName1);
                intent.putExtra("Username2", userName2);

                if (!userName1.isEmpty() && !userName2.isEmpty()) {
                    startActivityForResult(intent, NAME_REQUEST);
                } else {
                    //Toast.makeText(MainActivity.this, "Please fill the username info first",
                    // Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NAME_REQUEST) {
            if (resultCode == RESULT_OK) {
                String winnerName = data.getStringExtra("Winner");
                mTextView.setText("Winner of Previous Game\n"+winnerName);
            }
        }
    }

}
