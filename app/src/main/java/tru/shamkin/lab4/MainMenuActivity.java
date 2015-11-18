package tru.shamkin.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {


    Button Play, EnterNames, Standings;
    ImageView logoView;

    public static final String PREFS_NAME = "Players";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

//      Logging activity lifecycle
        Log.d("ActivityLife", "MainMenuActivity has been created");

//      Registering intents
        final Intent intentPlayGame = new Intent(this, PlayGameActivity.class);
        final Intent intentEnterNames = new Intent(this, EnterNameActivity.class);
        final Intent intentShowStandings = new Intent(this, ShowStandingsActivity.class);


//      action on logo click
        logoView = (ImageView)findViewById(R.id.logoView);
        logoView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Toast toast = Toast.makeText(getApplicationContext(), "TicTacToe game developed by Iurii Shamkin. Enjoy!", Toast.LENGTH_LONG);
                toast.show();
            }
        });


//      action on enter names click
        EnterNames = (Button)findViewById(R.id.button2);
        EnterNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEnterNames);
            }
        });


//      action on play game click
        Play = (Button)findViewById(R.id.button1);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPlayGame);
            }
        });



        //      action on play game click
        Play = (Button)findViewById(R.id.button3);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentShowStandings);
            }
        });

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
        Log.d("ActivityLife", "MainMenuActivity has been started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLife", "MainMenuActivity has been resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLife", "MainMenuActivity has been paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLife", "MainMenuActivity has been stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLife", "MainMenuActivity has been destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLife", "MainMenuActivity has been restarted");
    }
}
