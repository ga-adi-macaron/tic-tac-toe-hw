package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private TextView gameMessage;
    private TextView box1, box2, box3, box4, box5, box6, box7, box8, box9;
    private RelativeLayout gameScreen;
    private Button resetBoard;
    private GameBoard game;
    int turnNumber = 0;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        resetBoard = (Button)findViewById(R.id.clear_board);
        back = (Button)findViewById(R.id.back);

        box1 = (TextView)findViewById(R.id.textView);
        box2 = (TextView)findViewById(R.id.textView2);
        box3 = (TextView)findViewById(R.id.textView3);
        box4 = (TextView)findViewById(R.id.textView4);
        box5 = (TextView)findViewById(R.id.textView5);
        box6 = (TextView)findViewById(R.id.textView6);
        box7 = (TextView)findViewById(R.id.textView7);
        box8 = (TextView)findViewById(R.id.textView8);
        box9 = (TextView)findViewById(R.id.textView9);

        gameScreen = (RelativeLayout)findViewById(R.id.game_screen);

        gameMessage = (TextView)findViewById(R.id.game_message_text);
        final String playerName1 = intent.getStringExtra("PlayerOne");
        final String playerName2 = intent.getStringExtra("PlayerTwo");
        game = new GameBoard(playerName1, playerName2);
        gameMessage.setText(playerName1+"'s Turn");

        View.OnClickListener gameClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turnNumber == 10) {
                    gameMessage.setText("Reset to play again");
                }
                if(turnNumber == 9) {
                    gameMessage.setText("It's a tie!");
                    turnNumber++;
                } else {
                    switch(v.getId()) {
                        case R.id.textView:
                            if (box1.getText().equals(" ")) {
                                game.addMove(0, 0, box1);
                                if (game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer() + " Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView2:
                            if (box2.getText().equals(" ")) {
                                game.addMove(1, 0, box2);
                                if (game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer() + " Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView3:
                            if (box3.getText().equals(" ")) {
                                game.addMove(2, 0, box3);
                                if (game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer() + " Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView4:
                            if (box4.getText().equals(" ")) {
                                game.addMove(0, 1, box4);
                                if (game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer() + " Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView5:
                            if(box5.getText().equals(" ")) {
                                game.addMove(1, 1, box5);
                                if(game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer()+" Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView6:
                            if(box6.getText().equals(" ")) {
                                game.addMove(2, 1, box6);
                                if(game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer()+" Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView7:
                            if(box7.getText().equals(" ")) {
                                game.addMove(0, 2, box7);
                                if(game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer()+" Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView8:
                            if(box8.getText().equals(" ")) {
                                game.addMove(1, 2, box8);
                                if(game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer()+" Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                        case R.id.textView9:
                            if(box9.getText().equals(" ")) {
                                game.addMove(2, 2, box9);
                                if(game.isGameOver()) {
                                    gameMessage.setText(game.currentPlayer()+" Won!");
                                    turnNumber = 10;
                                    game.stopGame();
                                } else {
                                    turnNumber++;
                                }
                            }
                            break;
                    }
                }
            }
        };

        //Clears all board spaces
        resetBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.clearBoard();
                box1.setText(" ");
                box2.setText(" ");
                box3.setText(" ");
                box4.setText(" ");
                box5.setText(" ");
                box6.setText(" ");
                box7.setText(" ");
                box8.setText(" ");
                box9.setText(" ");
                turnNumber = 0;
                gameMessage.setText(playerName1+"'s Turn");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("WINNER", game.currentPlayer());
                setResult(RESULT_OK, result);
                finish();
            }
        });

        box1.setOnClickListener(gameClick);
        box2.setOnClickListener(gameClick);
        box3.setOnClickListener(gameClick);
        box4.setOnClickListener(gameClick);
        box5.setOnClickListener(gameClick);
        box6.setOnClickListener(gameClick);
        box7.setOnClickListener(gameClick);
        box8.setOnClickListener(gameClick);
        box9.setOnClickListener(gameClick);
        gameScreen.setOnClickListener(gameClick);
    }
}
