package ly.generalassemb.drewmahrt.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    String winner, player1, player2;
    int turn = 1;
    TextView a1, b1, c1, a2, b2, c2, a3, b3, c3, playerTurn;
    public String lastPlayedLetter = " ";
    public String lastPlayedPos = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        View.OnClickListener marker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.textView:
                        a1.setText(xOrY());
                        setLastPlayedLetter(a1.getText().toString());
                        setLastPlayedPos("al");
                        break;

                    case R.id.textView2:
                        a2.setText(xOrY());
                        setLastPlayedLetter(a2.getText().toString());
                        setLastPlayedPos("a2");
                        break;

                    case R.id.textView3:
                        a3.setText(xOrY());
                        setLastPlayedLetter(a3.getText().toString());
                        setLastPlayedPos("a3");
                        break;

                    case R.id.textView4:
                        b1.setText(xOrY());
                        setLastPlayedLetter(b1.getText().toString());
                        setLastPlayedPos("b1");
                        break;

                    case R.id.textView5:
                        b2.setText(xOrY());
                        setLastPlayedLetter(b2.getText().toString());
                        setLastPlayedPos("b2");
                        break;

                    case R.id.textView6:
                        b3.setText(xOrY());
                        setLastPlayedLetter(b3.getText().toString());
                        setLastPlayedPos("b3");
                        break;

                    case R.id.textView7:
                        c1.setText(xOrY());
                        setLastPlayedLetter(c1.getText().toString());
                        setLastPlayedPos("c1");
                        break;

                    case R.id.textView8:
                        c2.setText(xOrY());
                        setLastPlayedLetter(c2.getText().toString());
                        setLastPlayedPos("c2");
                        break;

                    case R.id.textView9:
                        c3.setText(xOrY());
                        setLastPlayedLetter(c3.getText().toString());
                        setLastPlayedPos("c3");
                        break;

                }

                if (gameWon() || turn == 10) {

                    winner = getWinner();
                    announceWinner (winner);

                }

                setTurnText();
            }
        };

        a1 =(TextView) findViewById(R.id.textView);
            a1.setOnClickListener(marker);
        a2=(TextView) findViewById(R.id.textView2);
            a2.setOnClickListener(marker);
        a3=(TextView) findViewById(R.id.textView3);
            a3.setOnClickListener(marker);

        b1 =(TextView) findViewById(R.id.textView4);
            b1.setOnClickListener(marker);
        b2=(TextView) findViewById(R.id.textView5);
            b2.setOnClickListener(marker);
        b3=(TextView) findViewById(R.id.textView6);
            b3.setOnClickListener(marker);

        c1 =(TextView) findViewById(R.id.textView7);
            c1.setOnClickListener(marker);
        c2=(TextView) findViewById(R.id.textView8);
            c2.setOnClickListener(marker);
        c3=(TextView) findViewById(R.id.textView9);
            c3.setOnClickListener(marker);

        player1 = getIntent().getStringExtra("playerOne");
        player2 = getIntent().getStringExtra("playerTwo");

        playerTurn =(TextView) findViewById(R.id.game_message_text);
        setTurnText();



    }

    public boolean gameWon () {
        if (lastPlayedPos.equals("b2") ){
            return checkB2();
        }
        else if (lastPlayedPos.equals("a1")){
            return checkA1();
        }
        else if (lastPlayedPos.equals("a2")){
            return checkA2();
        }
        else if (lastPlayedPos.equals("a3")){
            return checkA3();
        }
        else if (lastPlayedPos.equals("b1")){
            return checkB1();
        }
        else if (lastPlayedPos.equals("b3")){
            return checkB3();
        }
        else if (lastPlayedPos.equals("c1")){
            return checkC1();
        }
        else if (lastPlayedPos.equals("c2")){
            return checkC2();
        }
        else if (lastPlayedPos.equals("c3")){
            return checkC3();
        }
        return false;
    }

    public String xOrY () {

        if (turn % 2 == 0) {
            turn++;
            return "O";
        }
        turn++;
        return "X";

    }

    public void setLastPlayedLetter (String last) {
        lastPlayedLetter = last;
    }

    public void setLastPlayedPos (String last) {
        lastPlayedPos = last;
    }

    public void setTurnText () {
        String player;

        if (turn % 2 == 0) {
            player = player2;
        }

        else {
            player = player1;
        }

        playerTurn.setText(player + "'s turn!");
    }

    public boolean checkA1 () {
        if (lastPlayedLetter.equals(a2.getText().toString())) {
            if (lastPlayedLetter.equals(a3.getText().toString())){
                return true;
            }
        }

        else if (lastPlayedLetter.equals(b1.getText().toString())) {
            if (lastPlayedLetter.equals(c1.getText().toString())){
                return true;
            }
        }

        else if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(c3.getText().toString())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkA2 () {
        if (lastPlayedLetter.equals(a1.getText().toString())) {
            if (lastPlayedLetter.equals(a3.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(c2.getText().toString())) {
                return true;
            }
        }


        return false;
    }

    public boolean checkA3 () {
        if (lastPlayedLetter.equals(a2.getText().toString())) {
            if (lastPlayedLetter.equals(a1.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b3.getText().toString())) {
            if (lastPlayedLetter.equals(c3.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(c1.getText().toString())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkB1 () {
        if (lastPlayedLetter.equals(a1.getText().toString())) {
            if (lastPlayedLetter.equals(c1.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b3.getText().toString())) {
            if (lastPlayedLetter.equals(b2.getText().toString())) {
                return true;
            }
        }


        return false;
    }

    public boolean checkB2 () {
        if (lastPlayedLetter.equals(a1.getText().toString())) {
            if (lastPlayedLetter.equals(b3.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(a3.getText().toString())) {
            if (lastPlayedLetter.equals(c1.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(a2.getText().toString())) {
            if (lastPlayedLetter.equals(c2.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b1.getText().toString())){
            if (lastPlayedLetter.equals(b3.getText().toString())){
                return true;
            }
        }

        return false;
    }

    public boolean checkB3 () {
        if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(b1.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(a3.getText().toString())) {
            if (lastPlayedLetter.equals(c3.getText().toString())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkC1 () {
        if (lastPlayedLetter.equals(b1.getText().toString())) {
            if (lastPlayedLetter.equals(a1.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(c2.getText().toString())) {
            if (lastPlayedLetter.equals(c3.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(a3.getText().toString())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkC2 () {
        if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(a2.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(c1.getText().toString())) {
            if (lastPlayedLetter.equals(c3.getText().toString())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkC3 () {
        if (lastPlayedLetter.equals(c2.getText().toString())) {
            if (lastPlayedLetter.equals(c1.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b3.getText().toString())) {
            if (lastPlayedLetter.equals(a3.getText().toString())) {
                return true;
            }
        } else if (lastPlayedLetter.equals(b2.getText().toString())) {
            if (lastPlayedLetter.equals(a1.getText().toString())) {
                return true;
            }
        }

        return false;
    }

    public String getWinner (){
        if (turn == 10) {
            return "DRAW";
        }
        else if (lastPlayedLetter.equals("X")) {
            return player1;
        }

        return player2;
    }

    public void announceWinner (final String winner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (winner.equals("DRAW")) {
            builder.setTitle("GAME IS A DRAW");
        }

        else {
            builder.setTitle(winner + " wins!!");
        }

        builder.setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("winner", winner);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        AlertDialog announcement = builder.create();
        announcement.show();
    }

    


}
