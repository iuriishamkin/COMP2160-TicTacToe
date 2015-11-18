package tru.shamkin.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView winner = (TextView)findViewById(R.id.winner);


        // Logging activity lifecycle
        Log.d("ActivityLife", "EndGameActivity has been created");

        Intent intent = getIntent();
        String message = intent.getStringExtra("winner");
        winner.setText(message);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
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
        Log.d("ActivityLife", "EndGameActivity has been started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLife", "EndGameActivity has been resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLife", "EndGameActivity has been paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLife", "EndGameActivity has been stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLife", "EndGameActivity has been destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLife", "EndGameActivity has been restarted");
    }
}
