package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EditText mPlayerOneField;
    private EditText mPlayerTwoField;
    private Button mPlayButton;
    private ArrayList<String> mWinners;
    public static final String PLAYER_ONE_KEY = "playerOne";
    public static final String PLAYER_TWO_KEY = "playerTwo";
    public static final String WINNER_RESULT_KEY = "winnerResult";
    public static final int REQUEST_CODE = 88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWinners = new ArrayList<>();

        initializeReferenceVariables();

        setUpRecyclerView();

        setUpButtonClick();
    }

    public void initializeReferenceVariables(){
        mPlayButton = (Button)findViewById(R.id.start_game_button);
        mPlayerOneField = (EditText)findViewById(R.id.player_one_name);
        mPlayerTwoField =(EditText)findViewById(R.id.player_two_name);
    }

    public void setUpRecyclerView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.winner_list_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.VERTICAL,true);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new MainActivityRecyclerAdapter(mWinners));
    }

    public void setUpButtonClick(){
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayerOneField.getText().toString().equals("")) {
                    mPlayerOneField.setError("Player one needs a name");
                } else if (mPlayerTwoField.getText().toString().equals("")) {
                    mPlayerTwoField.setError("Player two needs a name");
                } else {
                    Intent toGameIntent = new Intent(MainActivity.this, GameActivity.class);
                    toGameIntent.putExtra(PLAYER_ONE_KEY, mPlayerOneField.getText().toString());
                    toGameIntent.putExtra(PLAYER_TWO_KEY, mPlayerTwoField.getText().toString());

                    startActivityForResult(toGameIntent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE){
            String winnerName = data.getStringExtra(WINNER_RESULT_KEY);
            if(winnerName.equals("Tie")){
                mWinners.add("Tie");
            }else{
                mWinners.add(winnerName+" won");
            }
            mRecyclerView.getAdapter().notifyItemInserted(mWinners.size()-1);
        }
    }
}
