package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    ImageView imageView0, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6,
    imageView7,imageView8;
    ArrayList<ImageView> allImageViews;
    boolean p1Turn;
    TextView gameText;
    boolean gameActive;

    ArrayList<Integer> p1Moves, p2Moves;

    //2 is an unplayed spot, 0 is held by player1, 1 is held by player 2.
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        allImageViews = new ArrayList<>();

        gameActive=true;
        Intent gameIntent =getIntent();
        String p1Name = gameIntent.getStringExtra("Player1Name");
        String p2Name = gameIntent.getStringExtra("Player2Name");

        gameText = (TextView)findViewById(R.id.game_message_text);

        if (Math.random()<.5){
            p1Turn=true;
            gameText.setText(p1Name+"'s turn");
        }else{
            p1Turn=false;
            gameText.setText(p2Name+"'s turn");
        }

        imageView0 = (ImageView)findViewById(R.id.imageView);
        imageView1 = (ImageView)findViewById(R.id.imageView2);
        imageView2 = (ImageView)findViewById(R.id.imageView3);
        imageView3 = (ImageView)findViewById(R.id.imageView4);
        imageView4 = (ImageView)findViewById(R.id.imageView5);
        imageView5 = (ImageView)findViewById(R.id.imageView6);
        imageView6 = (ImageView)findViewById(R.id.imageView7);
        imageView7 = (ImageView)findViewById(R.id.imageView8);
        imageView8 = (ImageView)findViewById(R.id.imageView9);

        allImageViews.add(imageView0);
        allImageViews.add(imageView1);
        allImageViews.add(imageView2);
        allImageViews.add(imageView3);
        allImageViews.add(imageView4);
        allImageViews.add(imageView5);
        allImageViews.add(imageView6);
        allImageViews.add(imageView7);
        allImageViews.add(imageView8);

        View.OnClickListener selectArea = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameActive) {
                    String tag = view.getTag().toString();
                    int tagNum = Integer.valueOf(tag);
                    if (gameState[tagNum] != 2) {
                        Toast.makeText(GameActivity.this, "You can't place there", Toast.LENGTH_SHORT).show();
                    } else {

                        ImageView iView = (ImageView) view;
                        if (p1Turn) {
                            iView.setImageResource(R.drawable.tictac);
                            p1Turn = !p1Turn;
                            gameState[tagNum] = 0;
                        } else {
                            iView.setImageResource(R.drawable.toe);
                            p1Turn = !p1Turn;
                            gameState[tagNum] = 1;
                        }
                    }
                    checkForWinner();
                }
            }
        };




        boolean light = true;
        for (ImageView view:allImageViews) {//Sets checkered background
            if(light){
                view.setBackgroundResource(R.drawable.wood_bg_light);
                view.setOnClickListener(selectArea);
                light=!light;
            }else{
                view.setBackgroundResource(R.drawable.wood_bg_dark);
                view.setOnClickListener(selectArea);
                light =!light;
            }

        }
    }
    public void checkForWinner(){
        for (int[] winningPosition:winningPositions) {
            if(gameState[winningPosition[0]]==gameState[winningPosition[1]] //If there's the same value in 3 positions, and that value isn't 2 then someone got 3 in a row.
                    && gameState[winningPosition[1]]==gameState[winningPosition[2]]
                    && gameState[winningPosition[0]]!=2){
                if(gameState[winningPosition[0]]==0){
                    Toast.makeText(this, "Player 1 wins. Change this", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Player 2 wins. Change this", Toast.LENGTH_LONG).show();
                }
                gameActive=false;
            }

        }
    }
}
