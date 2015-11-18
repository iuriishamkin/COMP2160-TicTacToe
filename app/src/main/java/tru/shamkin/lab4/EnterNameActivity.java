package tru.shamkin.lab4;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class EnterNameActivity extends AppCompatActivity {

    EditText playerName1, playerName2;
    String strName1, strName2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        //      Logging activity lifecycle
        Log.d("ActivityLife", "EnterNameActivity has been created");


        playerName1 = (EditText)findViewById(R.id.enterNamePlayer1);
        playerName2 = (EditText)findViewById(R.id.enterNamePlayer2);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strName1 = playerName1.getText().toString();
                strName2 = playerName2.getText().toString();

                SharedPreferences settings = getSharedPreferences(getString(R.string.PREFS_NAME), 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("player1Name", strName1);
                editor.putString("player2Name", strName2);

                editor.putInt("player1Score", 0);
                editor.putInt("player2Score", 0);

                editor.apply();
                finish();
            }
        });

    }



    //      Logging activity lifecycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLife", "MainMenuActivity has been started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLife", "EnterNameActivity has been resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLife", "EnterNameActivity has been paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLife", "EnterNameActivity has been stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLife", "EnterNameActivity has been destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLife", "EnterNameActivity has been restarted");
    }
}
