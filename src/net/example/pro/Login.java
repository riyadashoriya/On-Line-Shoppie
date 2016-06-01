package net.example.pro;


import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.login);	
		ParseUser currentUser = ParseUser.getCurrentUser();   
		// String struser = currentUser.getUsername().toString();   
		 //TextView txtuser = (TextView)findViewById(R.id.nameprint);   
		 //txtuser.setText("You are logged in as " + struser);   
		//final ParseUser user=new ParseUser();
		// ParseUser currentUser = ParseUser.getCurrentUser();
		 if(currentUser == null){
		   Intent intent = new Intent(this, User.class);
		   startActivity(intent);
		   finish();
		 }
		 
		 else
		 {
			 //final ParseUser user=new ParseUser();
			// if (user.getBoolean("emailVerified") )
			 //{ 
				String struser = currentUser.getUsername().toString();   
				 TextView txtuser = (TextView)findViewById(R.id.nameprint);   
				 txtuser.setText("You are logged in as " + struser); 
		 }
		 
			/*	 else 		 {
	 Intent intent = new Intent(this, User.class);
	   startActivity(intent);
	   finish();
	   Toast.makeText(getApplicationContext(),                   
				"Please verify your email id",                         
				Toast.LENGTH_LONG).show(); 
		 }
	 }
			 else	
			 { 
				 Intent intent = new Intent(this, User.class);
				   startActivity(intent);
				   Toast.makeText(getApplicationContext(),                   
							"Please verify your email id",                         
							Toast.LENGTH_LONG).show();                         
					finish();      
				   finish();
		 }}*/

	}
	public void onClick11(View v)
	{
		
		Intent i=new Intent(Login.this,AddItems.class);
		startActivity(i);
//	finish();
	}
	
	public void onClick16(View v)
	{
		Intent i=new Intent(Login.this,User.class);
	 
		ParseUser.logOut();                
		
		 finish();	 
		 startActivity(i);
		Toast.makeText(getApplicationContext(),   
				"You are now logged out!",         
				Toast.LENGTH_LONG).show();      
	finish();

	}
	
}
