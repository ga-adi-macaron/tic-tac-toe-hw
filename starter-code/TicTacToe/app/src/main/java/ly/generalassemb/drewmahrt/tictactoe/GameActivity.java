package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {
    TicTacToe mTicTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTicTacToe = TicTacToe.getInstance();
        mTicTacToe.generateGrid();
        Intent gameIntent = getIntent();

        mTicTacToe.setPlayer1(gameIntent.getStringExtra("player 1"));
        mTicTacToe.setPlayer2(gameIntent.getStringExtra("player 2"));

    }
    public void changeIcon(Coordinate coordinate,Player player){
        if (coordinate.isEmpty()){
            
        }
    }
}
