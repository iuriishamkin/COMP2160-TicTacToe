package tru.shamkin.lab4;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowStandingsActivity extends AppCompatActivity {

    TextView player1Score, player2Score;
    Button ok;

    SharedPreferences gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_standings);


        //     Logging activity lifecycle
        Log.d("ActivityLife", "ShowStandingsActivity has been created");

        player1Score = (TextView)findViewById(R.id.player1Score);
        player2Score = (TextView)findViewById(R.id.player2Score);
        ok = (Button)findViewById(R.id.okButton);


        gameData = getSharedPreferences(getString(R.string.PREFS_NAME), 0);
        String score1 = gameData.getString("player1Name", "First PLayer") + " won "
                + gameData.getInt("player1Score", 0) + " times";
        String score2 = gameData.getString("player2Name", "Second PLayer") + " won "
                + gameData.getInt("player2Score", 0) + " times";


        player1Score.setText(score1);
        player2Score.setText(score2);



        findViewById(R.id.okButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }









    //      Logging activity lifecycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLife", "ShowStandingsActivity has been started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLife", "ShowStandingsActivity has been resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLife", "ShowStandingsActivity has been paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLife", "ShowStandingsActivity has been stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLife", "ShowStandingsActivity has been destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLife", "ShowStandingsActivity has been restarted");
    }
}
