package net.example.pro;


import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
//import android.net.ParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class User extends Activity {
	
	private EditText aEdit;
	private EditText bEdit;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this,"Dz3FMHXFQ0XzRS98PGv4TmAjDLasPvohYpQRhPzH", "fRjyTWPlYLuAbPIaO46plxiSy5JHErPHUrklE5vS");

		setContentView(R.layout.user);
	}


	public void onClick1(View v)
	{
		Intent i=new Intent(User.this,Item.class);
		startActivity(i);
	//	finish();
	}
	public void onClick2(View v)
	{
		
		Intent i=new Intent(User.this,User.class);
		startActivity(i);
		//finish();
	}
	
	public void onClick3(View v)
	{
		aEdit = (EditText)findViewById(R.id.signup_username_value);
		final String a=aEdit.getText().toString();
		bEdit = (EditText)findViewById(R.id.signup_password_value);
		final String b=bEdit.getText().toString();
		
		ParseObject testObj1 = new ParseObject("TesOb1");
		testObj1.put("Username", a);
		testObj1.put("Password", b);
		//final ParseUser user=new ParseUser();
		 //if(emailVerifie){	
		ParseUser.logInInBackground(a, b, new LogInCallback() {                        
			public void done(ParseUser use, ParseException e) {           
				if (use != null) {      
					//final ParseUser user=new ParseUser();
					//boolean emailVerified=true;
					
					// If user exist and authenticated, send user to Welcome.class   
					//emailVerified = user.getBoolean("emailVerified");
					//if(emailVerified)
					//{
					Intent i=new Intent(User.this,Login.class);
					startActivity(i);
				
					Toast.makeText(getApplicationContext(),                   
							"Successfully Logged in. Welcome Back!",                         
							Toast.LENGTH_LONG).show();                         
					finish();                               
					
					}
			/*		else{
						Toast.makeText(getApplicationContext(),                   
								"Please verify your email id",                         
								Toast.LENGTH_LONG).show();                         
						finish();                               
							
						
					}}*/
				else {                                   
						Toast.makeText(                          
								getApplicationContext(),        
								"No such user exist, please signup",   
								Toast.LENGTH_LONG).show();             
						}                             }
	}); 
		 }
				
		
	public void onClick4(View v)
	{
		
		Intent i=new Intent(User.this,Signup.class);
		startActivity(i);
		//finish();
	}

}
