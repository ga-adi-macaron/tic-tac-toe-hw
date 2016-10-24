package ly.generalassemb.drewmahrt.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText p1EditText, p2EditText;
    Button startGameButton, clearHistButton;
    TextView lastWinText;
    public static final int OUTCOME_CODE = 2369;
    public static final int WINNER_CODE= 1337;
    public static final int DRAW_CODE = 424;
    public static SQLiteDatabase gameHistoryDB;
    public Cursor c;
    ArrayList<GameResult> gameResults;
    RecyclerView resultsRecycler;

    //ToDo: Add an activity to display gamestate results of previous games.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameResults = new ArrayList<>();

        gameHistoryDB = openOrCreateDatabase("Game_History", MODE_PRIVATE, null);
        gameHistoryDB.execSQL("CREATE TABLE IF NOT EXISTS game_history (gameID INTEGER PRIMARY KEY, p1Name VARCHAR, p2Name VARCHAR, winner VARCHAR, gameState VARCHAR)");
        //If game was draw winner var is "draw"
        c = gameHistoryDB.rawQuery("SELECT * FROM game_history", null);
        c.moveToFirst();

        //This gives Index of items when I'm looking for the data.
            int p1Index = c.getColumnIndex("p1Name");
            int p2Index = c.getColumnIndex("p2Name");
            int winnerIndex = c.getColumnIndex("winner");
            int gameStateIndex = c.getColumnIndex("gameState");
            int gameIDIndex = c.getColumnIndex("gameID");//Currently not using this, but might want to add gameIds to display game number.

        try {
            while (c != null) {
                gameResults.add(new GameResult(
                        c.getString(p1Index),
                        c.getString(p2Index),
                        c.getString(winnerIndex),
                        c.getString(gameStateIndex),
                        c.getInt(gameIDIndex)
                ));
                c.moveToNext();
            }
            ;
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Loaded data", Toast.LENGTH_SHORT).show();
        }
        c.close();


        p1EditText = (EditText)findViewById(R.id.player_one_name);
        p2EditText = (EditText)findViewById(R.id.player_two_name);

        lastWinText = (TextView)findViewById(R.id.last_winner_text);
        resultsRecycler = (RecyclerView)findViewById(R.id.resultsrecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,true);
        resultsRecycler.setLayoutManager(layoutManager);

        if (gameResults.size()>0){
            lastWinText.setText("Previous Winners:");
        }

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

        clearHistButton = (Button) findViewById(R.id.clear_history_butt);
        clearHistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Wipe all history?")
                        .setPositiveButton("Eradicate it all", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                gameHistoryDB.execSQL("DELETE FROM game_history");
                                gameHistoryDB.execSQL("VACUUM");
                                gameResults.clear();
                                resultsRecycler.getAdapter().notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Erasing history is a folly", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();
            }
        });

        resultsRecycler.setAdapter(new ResultsAdapter(gameResults));

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OUTCOME_CODE){

            String p1Name = data.getStringExtra("Player1Name");
            String p2Name = data.getStringExtra("Player2Name");
            String winner = data.getStringExtra("winner");
            int[] gameState = data.getIntArrayExtra("gamestate");
            String gameStateText="";

            for (Integer i:gameState) {
                gameStateText+=Integer.toString(i);
            }
            String sqlExecutionString = "INSERT INTO game_history (p1Name, p2Name, winner, gameState) VALUES ('"+p1Name+"', '"+p2Name+"', '"+ winner+"', '"+ gameStateText+"')";

            gameHistoryDB.execSQL(sqlExecutionString);
            gameResults.add(new GameResult(p1Name,p2Name,winner,gameStateText, gameResults.size()+1));

        }

    }
}
