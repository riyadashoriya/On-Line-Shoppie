package net.example.pro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

//import android.widget.EditText;

public class Login extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        //Check if user is logged in and perform actions for that
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ParseUser currentUser = ParseUser.getCurrentUser();
        // String struser = currentUser.getUsername().toString();
        //TextView txtuser = (TextView)findViewById(R.id.nameprint);
        //txtuser.setText("You are logged in as " + struser);
        //final ParseUser user=new ParseUser();
        // ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(this, User.class);
            startActivity(intent);
            finish();
        } else {
            //final ParseUser user=new ParseUser();
            // if (user.getBoolean("emailVerified") )
            //{
            String struser = currentUser.getUsername().toString();
            TextView txtuser = (TextView) findViewById(R.id.nameprint);
            txtuser.setText("You are logged in as " + struser);
        }

    }

    //Button for adding the items to the list
    public void onClick11(View v) {

        Intent i = new Intent(Login.this, AddItems.class);
        startActivity(i);
        //	finish();
    }

    //Perform when user clicks on logout button
    public void onClick16(View v) {
        Intent i = new Intent(Login.this, User.class);

        ParseUser.logOut();
        finish();
        startActivity(i);
        Toast.makeText(getApplicationContext(),
                "You are now logged out!",
                Toast.LENGTH_LONG).show();
        finish();

    }

}
