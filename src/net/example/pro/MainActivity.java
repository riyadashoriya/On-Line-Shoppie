package net.example.pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseAnalytics;

//import android.view.Menu;

//This is the main screen; comes after splash screen
public class MainActivity extends Activity {

    //Initialize database connectivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "Dz3FMHXFQ0XzRS98PGv4TmAjDLasPvohYpQRhPzH", "fRjyTWPlYLuAbPIaO46plxiSy5JHErPHUrklE5vS");
        ParseAnalytics.trackAppOpened(getIntent());
        setContentView(R.layout.activity_main);
    }

    //Button for directing to item class
    public void onClick1(View v) {
        Intent i = new Intent(MainActivity.this, Item.class);
        startActivity(i);
        //	finish();
    }

    //Button for directing to User class
    public void onClick2(View v) {

        Intent i = new Intent(MainActivity.this, User.class);
        startActivity(i);
        //finish();
    }
}
