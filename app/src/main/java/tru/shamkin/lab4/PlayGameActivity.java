package tru.shamkin.lab4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class PlayGameActivity extends AppCompatActivity {


    // represent state of the board
    enum State{Blank, X, O};

    int dimensions = 3;

    // array representing game board
    State[][] board = new State[dimensions][dimensions];

    int moveCount = 0;

    State lastMove;

    TextView showCurrentPLayer;
    SharedPreferences gameData;

    Intent intentEndGame;
    int player1Score, player2Score;

    boolean itsDraw = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // Logging activity lifecycle
        Log.d("ActivityLife", "PlayGameActivity has been created");

        gameData = getSharedPreferences(getString(R.string.PREFS_NAME), 0);

        // Registering intents
        intentEndGame = new Intent(this, EndGameActivity.class);

        // adding listener to the buttons
        findViewById(R.id.iButton1).setOnClickListener(handleClick);
        findViewById(R.id.iButton2).setOnClickListener(handleClick);
        findViewById(R.id.iButton3).setOnClickListener(handleClick);
        findViewById(R.id.iButton4).setOnClickListener(handleClick);
        findViewById(R.id.iButton5).setOnClickListener(handleClick);
        findViewById(R.id.iButton6).setOnClickListener(handleClick);
        findViewById(R.id.iButton7).setOnClickListener(handleClick);
        findViewById(R.id.iButton8).setOnClickListener(handleClick);
        findViewById(R.id.iButton9).setOnClickListener(handleClick);

        showCurrentPLayer = (TextView)findViewById(R.id.currentPLayer);
        showCurrentPLayer.setText("It's " + gameData.getString("player1Name", "First PLayer") + "'s turn");

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moveCount != 0)
                    recreate();

            }
        });

        // initialize board to default value - blank
        Arrays.fill(board[0], State.Blank);
        Arrays.fill(board[1], State.Blank);
        Arrays.fill(board[2], State.Blank);
        
    }


    // listener for the X-O buttons
    private View.OnClickListener handleClick = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            ImageButton btn = (ImageButton)arg0;

            if (updateStatus(btn)) // which further calls updateLabel
                checkConditions();

        }
    };



    private boolean updateStatus(ImageButton button) {

        int id = button.getId();

        // determine position and status
        if (id == R.id.iButton1) {
            if(board[0][0] == State.Blank){
                board[0][0] = updateLabel(button);
                return true;
            }

        } else if (id == R.id.iButton2) {
            if(board[0][1] == State.Blank){
                board[0][1] = updateLabel(button);
                return true;
            }

        }else if (id == R.id.iButton3) {
            if(board[0][2] == State.Blank){
                board[0][2] = updateLabel(button);
                return true;
            }

        }else if (id == R.id.iButton4) {
            if(board[1][0] == State.Blank){
                board[1][0] = updateLabel(button);
            }

        }else if (id == R.id.iButton5) {
            if(board[1][1] == State.Blank){
                board[1][1] = updateLabel(button);
                return true;
            }

        }else if (id == R.id.iButton6) {
            if(board[1][2] == State.Blank){
                board[1][2] = updateLabel(button);
                return true;
            }

        }else if (id == R.id.iButton7) {
            if(board[2][0] == State.Blank){
                board[2][0] = updateLabel(button);
                return true;
            }

        }else if (id == R.id.iButton8) {
            if(board[2][1] == State.Blank){
                board[2][1] = updateLabel(button);
                return true;
            }

        }else if (id == R.id.iButton9) {
            if(board[2][2] == State.Blank){
                board[2][2] = updateLabel(button);
                return true;
            }
        }

        return false;
    }



    //  update Button Label method
    private State updateLabel(ImageButton button) {

        moveCount++;

        if (moveCount % 2 != 0) {

//            button.setImageResource(R.drawable.button_x);    // even -> X
            // btn.setImageResource(R.drawable.actions_record);
            button.setForeground(getDrawable(R.drawable.button_x));
            Log.d("PlayerTurn", "First player  (X) | total moves - " + moveCount);
            showCurrentPLayer.setText("It's " + gameData.getString("player2Name", "Second PLayer") + "'s turn");
            return lastMove = State.X;
        } else {
            button.setForeground(getDrawable(R.drawable.button_o));     // odd -> O
//            button.setImageResource(R.drawable.button_o);
            Log.d("PlayerTurn", "Second player (O) | total moves - " + moveCount);
            showCurrentPLayer.setText("It's " + gameData.getString("player1Name", "First PLayer") + "'s turn");
            return lastMove = State.O;
        }
    }



    // method checks winning conditions for the last played player
    private void checkConditions() {

        //check end conditions

        int sum;



            //check row
            for (int i = 0; i < dimensions; i++) {
                sum = 0;

                for (int j = 0; j < dimensions; j++) {
                    if (board[i][j] == lastMove)
                        sum++;
                }

                if (sum == dimensions) {
                    Log.d("RESULT", "WIN!!");
                    setWinner();
                }
            }


            //check col
            for (int i = 0; i < dimensions; i++) {
                sum = 0;

                for (int j = 0; j < dimensions; j++) {
                    if (board[j][i] == lastMove)
                        sum++;
                }

                if (sum == dimensions) {
                    Log.d("RESULT", "WIN!!");
                    setWinner();
                }
            }

            //check diag
            sum = 0;
            for (int j = 0; j < dimensions; j++) {
                if (board[j][j] == lastMove)
                    sum++;
            }
            if (sum == dimensions) {
                Log.d("RESULT", "WIN!!");
                setWinner();
            }


            //check anti diag
            sum = 0;
            for (int j = 0; j < dimensions; j++) {
                if (board[j][(dimensions - 1) - j] == lastMove)
                    sum++;
            }
            if (sum == dimensions) {
                Log.d("RESULT", "WIN!!");
                setWinner();
            }

        //check draw
        if(itsDraw && moveCount == 9) {
            Log.d("RESULT", "DRAW!!");
            intentEndGame.putExtra("winner", "It's a draw!");
            startActivity(intentEndGame);
            recreate();
        }
    }


    private void setWinner() {

        String message;

        SharedPreferences.Editor editor = gameData.edit();

        itsDraw = false;

        if (lastMove == State.X) {
//            playerXwin = true;
            message = gameData.getString("player1Name", "First PLayer") + " won!";

            player1Score = gameData.getInt("player1Score", 0);
            Log.d("SCORE", "PLayer 1 won " + player1Score + " times");
            player1Score ++;
            editor.putInt("player1Score", player1Score);

        } else {
//            playerYwin = true;
            message = gameData.getString("player2Name", "Second PLayer") + " won!";

            player2Score = gameData.getInt("player2Score", 0);
            Log.d("SCORE", "PLayer 2 won " + player2Score + " times");
            player2Score ++;
            editor.putInt("player1Score", player2Score);
        }

        editor.apply();

        intentEndGame.putExtra("winner", message);
        startActivity(intentEndGame);
        recreate();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    //      Logging activity lifecycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLife", "PlayGameActivity has been started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLife", "PlayGameActivity has been resumed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLife", "PlayGameActivity has been paused");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLife", "PlayGameActivity has been stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLife", "PlayGameActivity has been destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLife", "PlayGameActivity has been restarted");
    }
}
