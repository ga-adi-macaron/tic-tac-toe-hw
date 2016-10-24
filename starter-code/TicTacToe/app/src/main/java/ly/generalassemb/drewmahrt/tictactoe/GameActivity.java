package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity{

    private TextView mWhosTurn;

    private TextView mBox1, mBox2, mBox3, mBox4, mBox5, mBox6, mBox7, mBox8, mBox9;

    private GridLayout mGameBoard;

    private Button mBackButton;

    private String mP1Name;

    private String mP2Name;

    private boolean mP1Turn;

    private ArrayList<Integer> mTestingTurnsChange;

    private ArrayList<Integer> mP1Picks;

    private ArrayList<Integer> mP2Picks;

    private final int[][] mCombosToWin = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent recieveNameIntent = getIntent();
        mP1Name = recieveNameIntent.getStringExtra("P1Name");
        mP2Name = recieveNameIntent.getStringExtra("P2Name");

        mWhosTurn = (TextView) findViewById(R.id.game_message_text);
        mWhosTurn.setText(mP1Name + "'s turn");

        mP2Picks = new ArrayList<>();
        mP1Picks = new ArrayList<>();

        mGameBoard = (GridLayout) findViewById(R.id.game_board);
        mBox1 = (TextView)findViewById(R.id.textView);
        mBox2 = (TextView)findViewById(R.id.textView2);
        mBox3 = (TextView)findViewById(R.id.textView3);
        mBox4 = (TextView)findViewById(R.id.textView4);
        mBox5 = (TextView)findViewById(R.id.textView5);
        mBox6 = (TextView)findViewById(R.id.textView6);
        mBox7 = (TextView)findViewById(R.id.textView7);
        mBox8 = (TextView)findViewById(R.id.textView8);
        mBox9 = (TextView)findViewById(R.id.textView9);

        mBackButton = (Button)findViewById(R.id.backButton);



        mTestingTurnsChange = new ArrayList<>();

        mBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox1.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox1.setText("X");
                        mP1Picks.add(1);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox1.setText("O");
                        mP2Picks.add(1);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox2.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox2.setText("X");
                        mP1Picks.add(2);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox2.setText("O");
                        mP2Picks.add(2);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox3.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox3.setText("X");
                        mP1Picks.add(3);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox3.setText("O");
                        mP2Picks.add(3);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox4.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox4.setText("X");
                        mP1Picks.add(4);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox4.setText("O");
                        mP2Picks.add(4);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox5.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox5.setText("X");
                        mP1Picks.add(5);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox5.setText("O");
                        mP2Picks.add(5);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox6.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox6.setText("X");
                        mP1Picks.add(6);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox6.setText("O");
                        mP2Picks.add(6);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox7.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox7.setText("X");
                        mP1Picks.add(7);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox7.setText("O");
                        mP2Picks.add(7);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox8.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox8.setText("X");
                        mP1Picks.add(8);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox8.setText("O");
                        mP2Picks.add(8);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBox9.getText().toString().isEmpty()) {
                    if (mTestingTurnsChange.size() % 2 == 0) {
                        mBox9.setText("X");
                        mP1Picks.add(9);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP2Name + "'s turn");
                    } else {
                        mBox9.setText("O");
                        mP2Picks.add(9);
                        mTestingTurnsChange.add(1);
                        mWhosTurn.setText(mP1Name + "'s turn");
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Please pick a box that has not been picked yet", Toast.LENGTH_SHORT).show();
                }
                checkWin();
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkWin() == false){
                    Toast.makeText(GameActivity.this, "NO GIVING UP...FIGHT TO THE DEATH!!!", Toast.LENGTH_SHORT).show();
                }else if(mWhosTurn.getText().toString().equals(mP1Name + " WINS!!!")){
                    Intent test = new Intent(GameActivity.this, MainActivity.class);
                    test.putExtra("WIN", mP1Name);
                    startActivity(test);
                }else if (mWhosTurn.getText().toString().equals(mP2Name + " WINS!!!")){
                    Intent test = new Intent(GameActivity.this, MainActivity.class);
                    test.putExtra("WIN",mP2Name);
                    startActivity(test);
                }

            }
        });
    }
    

    public boolean checkWin(){
        for (int i = 0; i < mCombosToWin.length; i++){
            if (mP1Picks.contains(mCombosToWin[i][0]) && mP1Picks.contains(mCombosToWin[i][1]) && mP1Picks.contains(mCombosToWin[i][2])){
                mWhosTurn.setText(mP1Name + " WINS!!!");
                return true;
            }
            else if (mP2Picks.contains(mCombosToWin[i][0]) && mP2Picks.contains(mCombosToWin[i][1]) && mP2Picks.contains(mCombosToWin[i][2])){
                mWhosTurn.setText(mP2Name + " WINS!!!");
                return true;
            }

        }
        return false;
    }




}
