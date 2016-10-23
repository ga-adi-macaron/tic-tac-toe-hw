package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity  {

    private TextView mWhosTurn;

    private String mP1Name;

    private String mP2Name;

 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent recieveNameIntent = getIntent();
        mP1Name = recieveNameIntent.getStringExtra("P1Name");
        mP2Name = recieveNameIntent.getStringExtra("P2Name");

    }

}
