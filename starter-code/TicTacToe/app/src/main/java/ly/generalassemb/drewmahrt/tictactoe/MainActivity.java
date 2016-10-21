package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TicTacToe mTicTacToe;
    EditText mPlayer1, mPlayer2;
    Button mButton;
    public static final int REQUEST_CODE = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent myIntent = new Intent(MainActivity.this,GameActivity.class);

        mTicTacToe = TicTacToe.getInstance();
        mPlayer1 = (EditText) findViewById(R.id.player_one_name);
        mPlayer2 = (EditText) findViewById(R.id.player_two_name);
        mButton = (Button) findViewById(R.id.start_game_button);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = mPlayer1.getText().toString();
                String name2 = mPlayer2.getText().toString();
                if (name1.isEmpty()){
                    mPlayer1.setError("Field cannot be empty");
                }
                if (name2.isEmpty()){
                    mPlayer2.setError("Field cannot be empty");
                }
                if (!name1.isEmpty() && !name2.isEmpty()){
                    myIntent.putExtra("player 1",name1);
                    myIntent.putExtra("player 2", name2);
                    startActivityForResult(myIntent,REQUEST_CODE);
                }
            }
        };
    }
}
