package net.example.pro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

//import android.net.ParseException;

public class User extends Activity {

    private EditText aEdit;
    private EditText bEdit;

    //Initialize database
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "Dz3FMHXFQ0XzRS98PGv4TmAjDLasPvohYpQRhPzH", "fRjyTWPlYLuAbPIaO46plxiSy5JHErPHUrklE5vS");
        setContentView(R.layout.user);
    }


    //Button to direct to item class
    public void onClick1(View v) {
        Intent i = new Intent(User.this, Item.class);
        startActivity(i);
        //	finish();
    }

    //Button to direct to User class
    public void onClick2(View v) {

        Intent i = new Intent(User.this, User.class);
        startActivity(i);
        //finish();
    }

    //Button for login
    public void onClick3(View v) {
        aEdit = (EditText) findViewById(R.id.signup_username_value);
        final String a = aEdit.getText().toString();
        bEdit = (EditText) findViewById(R.id.signup_password_value);
        final String b = bEdit.getText().toString();

        ParseObject testObj1 = new ParseObject("TesOb1");
        testObj1.put("Username", a);
        testObj1.put("Password", b);
        //final ParseUser user=new ParseUser();
        //if(emailVerifie){
        ParseUser.logInInBackground(a, b, new LogInCallback() {
            public void done(ParseUser use, ParseException e) {
                if (use != null) {
                    Intent i = new Intent(User.this, Login.class);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(),
                            "Successfully Logged in. Welcome Back!",
                            Toast.LENGTH_LONG).show();
                    finish();

                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "No such user exist, please signup",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Button to direct to Signup
    public void onClick4(View v) {

        Intent i = new Intent(User.this, Signup.class);
        startActivity(i);
        //finish();
    }

}
