package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_ONE_NAME_KEY = "playerOneNameKey";
    public static final String PLAYER_TWO_NAME_KEY = "playerTwoNameKey";
    public static final String RESULT_TEXT_KEY = "resultTextKey";

    private static final int GAME_REQUEST_CODE = 123;

    private ResultsHolder mResultsHolder;
    private RecyclerView.Adapter mResultsRecyclerViewAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNameInputsAndStartButton();

        setupResultsList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check if we have a valid result from the last game
        if (requestCode == GAME_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String lastGameResult = data.getStringExtra(RESULT_TEXT_KEY);
                if (lastGameResult != null) {

                    // Add it to the singleton
                    mResultsHolder.addResult(lastGameResult);

                    // Update the recycler view (new items are always added to the top)
                    mResultsRecyclerViewAdapter.notifyItemInserted(0);
                }
            }
        }
    }

    private void setupNameInputsAndStartButton() {
        final EditText playerOne = (EditText) findViewById(R.id.player_one_name);
        final EditText playerTwo = (EditText) findViewById(R.id.player_two_name);
        Button startButton = (Button) findViewById(R.id.start_game_button);

        // When button is clicked, start GameActivity for result and pass it the player names
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerOne.getText().toString().trim().isEmpty()) {
                    playerOne.setError("Name cannot be blank!");
                }
                else if (playerTwo.getText().toString().trim().isEmpty()) {
                    playerTwo.setError("Name cannot be blank!");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    intent.putExtra(PLAYER_ONE_NAME_KEY, playerOne.getText().toString());
                    intent.putExtra(PLAYER_TWO_NAME_KEY, playerTwo.getText().toString());
                    startActivityForResult(intent, GAME_REQUEST_CODE);
                }
            }
        });
    }

    private void setupResultsList() {
        mResultsHolder = ResultsHolder.getInstance();
        mResultsRecyclerViewAdapter = new ResultsRecyclerViewAdapter(mResultsHolder.getResults());

        RecyclerView resultsRecyclerView = (RecyclerView) findViewById(R.id.results_recycler_view);

        resultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        resultsRecyclerView.setAdapter(mResultsRecyclerViewAdapter);
    }
}
