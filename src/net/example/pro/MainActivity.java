package net.example.pro;

import com.parse.Parse;
import com.parse.ParseAnalytics;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
//import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this,"Dz3FMHXFQ0XzRS98PGv4TmAjDLasPvohYpQRhPzH", "fRjyTWPlYLuAbPIaO46plxiSy5JHErPHUrklE5vS");
		ParseAnalytics.trackAppOpened(getIntent());
		setContentView(R.layout.activity_main);
	}

	
	public void onClick1(View v)
	{
		Intent i=new Intent(MainActivity.this,Item.class);
		startActivity(i);
	//	finish();
	}
	public void onClick2(View v)
	{
		
		Intent i=new Intent(MainActivity.this,User.class);
		startActivity(i);
		//finish();
	}
}
