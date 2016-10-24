package ly.generalassemb.drewmahrt.tictactoe;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay);

        ImageView replayImageView0 = (ImageView)findViewById(R.id.replayImageView);
        ImageView replayImageView1 = (ImageView)findViewById(R.id.replayImageView2);
        ImageView replayImageView2 = (ImageView)findViewById(R.id.replayImageView3);
        ImageView replayImageView3 = (ImageView)findViewById(R.id.replayImageView4);
        ImageView replayImageView4 = (ImageView)findViewById(R.id.replayImageView5);
        ImageView replayImageView5 = (ImageView)findViewById(R.id.replayImageView6);
        ImageView replayImageView6 = (ImageView)findViewById(R.id.replayImageView7);
        ImageView replayImageView7 = (ImageView)findViewById(R.id.replayImageView8);
        ImageView replayImageView8 = (ImageView)findViewById(R.id.replayImageView9);
        ArrayList<ImageView> allImageViews = new ArrayList<>();

        allImageViews.add(replayImageView0);
        allImageViews.add(replayImageView1);
        allImageViews.add(replayImageView2);
        allImageViews.add(replayImageView3);
        allImageViews.add(replayImageView4);
        allImageViews.add(replayImageView5);
        allImageViews.add(replayImageView6);
        allImageViews.add(replayImageView7);
        allImageViews.add(replayImageView8);

        TextView winnerText = (TextView)findViewById(R.id.replay_winner_text);

        Intent replayIntent = getIntent();
        Cursor c = MainActivity.gameHistoryDB.rawQuery("SELECT * FROM game_history WHERE gameID = "+ replayIntent.getStringExtra("gameID"), null);
        c.moveToFirst();
        String gameState = c.getString(c.getColumnIndex("gameState"));
        winnerText.setText(c.getString(c.getColumnIndex("winner")));
        c.close();

        Log.d("GameState: ", gameState);

        int[] endGameState = GameResult.stringIntToIntArray(gameState);

        boolean lightBoard= true;
        for (int i = 0; i < 9; i++) {
            Log.d("gamestate: ", String.valueOf(endGameState[i]));
            if(endGameState[i]==0){
                allImageViews.get(i).setImageResource(R.drawable.toe);
            }else if (endGameState[i]==1){
                allImageViews.get(i).setImageResource(R.drawable.tictac);
            }else{
                if(lightBoard){
                    allImageViews.get(i).setBackgroundResource(R.drawable.wood_bg_light);
                }else{
                    allImageViews.get(i).setBackgroundResource(R.drawable.wood_bg_dark);
                }
            }
            lightBoard=!lightBoard;
        }
        Button backButton = (Button)findViewById(R.id.replaybackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
